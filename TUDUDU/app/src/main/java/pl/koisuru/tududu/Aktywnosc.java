package pl.koisuru.tududu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by uczen on 2017-10-08.
 */

public class Aktywnosc extends AppCompatActivity {
    private EditText editText;
    private EditText editText2;
    private Button przycisk;
    private TextView text;
    private final String Base = "http://api.fixer.io/latest?base=";
    private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waluty);
        editText = (EditText) findViewById(R.id.qu);
        editText2 = (EditText) findViewById(R.id.eu);
        przycisk = (Button) findViewById(R.id.tu);
        text = (TextView) findViewById(R.id.ru);
        progressBar = (ProgressBar) findViewById(R.id.yu);



        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String query = Base + editText.getText().toString();
                Uri uri = Uri.parse(query);
                URL url = null;

                try {
                    url = new URL(uri.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                if (uri != null) {
                    new Niewiem().execute(url);
                }
            }

        });
    }


    public class Niewiem extends AsyncTask<URL, Void, String> {
        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);
            text.setVisibility(View.VISIBLE);
            if (s != null && !s.equals("")) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONObject obj = object.getJSONObject("rates");
                    Double wynik = obj.getDouble(editText2.getText().toString());
                    text.setText("" + wynik);


                } catch (JSONException e) {
                    e.printStackTrace();
                    text.setText(e.toString());

                }

            }

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            text.setVisibility(View.INVISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];
            String tu = null;
            try {
                tu = Internet.odpowiedz(url);


            } catch (IOException e) {
                e.printStackTrace();
            }
            return tu;
        }

    }


}
