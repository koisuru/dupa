package pl.koisuru.tududu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-10-29.
 */

public class Pierwszyfragment extends android.support.v4.app.Fragment  implements LoaderManager.LoaderCallbacks<String> {


    private TextView text;

    private final String API_KAY = "&APPID=e600af897818f3effd73326b4559b1f8";
    private final String Base_url = "http://api.openweathermap.org/data/2.5/forecast?q=";


    String jednostki = "&units=metric";

    private ProgressBar progressBar;
    private List<Pogoda> pogo = new LinkedList<>();
    private RecyclerView recyclerView;
    private final int Loader_id = 34;
    Baza db;

    public static Pierwszyfragment newInstance(){
        Pierwszyfragment fragment = new Pierwszyfragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container,false);

        db = new Baza(getContext());
        text = (TextView) view.findViewById(R.id.e);
        progressBar = (ProgressBar) view.findViewById(R.id.r);
        recyclerView = (RecyclerView) view.findViewById(R.id.t);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        Decorator decorator = new Decorator(10);
        recyclerView.addItemDecoration(decorator);
        final LoaderManager.LoaderCallbacks<String> callbacks = this;
        getActivity().getSupportLoaderManager().initLoader(Loader_id, null, callbacks);

        return view;
    }

    @Override
     public void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getActivity().getSharedPreferences("pogoda", Context.MODE_PRIVATE);
        String s = sharedPref.getString("stopnie", "C");
        if (s.equals("C")) {
            jednostki = "&units=metric";

        } else if (s.equals("F")) {
            jednostki = "&units=imperial";
        } else if (s.equals("K")) {
            jednostki = "&units=default";
        }
        String miastos = sharedPref.getString("miasto", "Warszawa");

        String query = Base_url + miastos + API_KAY + jednostki;
        Uri uri = Uri.parse(query);
        URL url = null;
        if (jestinternet()) {

            try {
                url = new URL(uri.toString());
                Bundle quertBundle = new Bundle();
                quertBundle.putString("query", url.toString());

                Loader<String> stringLoader =getActivity().getSupportLoaderManager().getLoader(Loader_id);
                if (stringLoader == null) {
                    getActivity().getSupportLoaderManager().initLoader(Loader_id, quertBundle, this);
                } else {
                   getActivity().getSupportLoaderManager().restartLoader(Loader_id, quertBundle, this);

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            if (uri != null) {

            }

        } else {
            Adapterxd adapterxd = new Adapterxd(getContext(), db.getAllPogodas());
            recyclerView.setAdapter(adapterxd);
        }

    }


    public boolean jestinternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnected();

    }

    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<String>(getContext()) {
            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                if (args == null) {
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                text.setVisibility(View.INVISIBLE);
                forceLoad();
            }

            @Override
            public String loadInBackground() {
                String urlString = args.getString("query");
                if (urlString == null || urlString.isEmpty()) {
                    return null;
                }
                try {
                    URL url = new URL(urlString);
                    return Internet.odpowiedz(url);


                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }

            }
        };
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        progressBar.setVisibility(View.INVISIBLE);
        text.setVisibility(View.VISIBLE);

        if (data != null && !data.equals("")) {
            pogo.clear();
            db.clearRepos();
            try {
                JSONObject in = new JSONObject(data);

                JSONObject cityobj = in.getJSONObject("city");
                String city = cityobj.getString("name");
                JSONArray jsonArray = in.getJSONArray("list");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    JSONObject main = obj.getJSONObject("main");
                    Double temp = main.getDouble("temp");
                    String datas = obj.getString("dt_txt");
                    JSONArray opis = obj.getJSONArray("weather");
                    JSONObject opise = opis.getJSONObject(0);
                    String opisem = opise.getString("main");
                    String icon = opise.getString("icon");
                    Pogoda pogoda = new Pogoda(city, datas, opisem, temp, icon);
                    pogo.add(pogoda);
                    db.addRepo(pogoda);
                }
                Adapterxd adapterxd = new Adapterxd(getContext(), pogo);
                recyclerView.setAdapter(adapterxd);
            } catch (JSONException e) {
                e.printStackTrace();
                text.setText(e.toString());
            }

        } else {
            text.setText("nie wyszukano");

        }
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
