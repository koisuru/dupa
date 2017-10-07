package pl.koisuru.tududu;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView text;
    private Button przycisk;
    private final String API_KAY = "&APPID=e600af897818f3effd73326b4559b1f8";
    private final String Base_url = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private ProgressBar progressBar;
    private List<Pogoda> pogo = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.q);
        text = (TextView) findViewById(R.id.e);
        przycisk = (Button) findViewById(R.id.w);
        progressBar = (ProgressBar) findViewById(R.id.r);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = Base_url + editText.getText().toString() + API_KAY + "&units=metric";
                Uri uri = Uri.parse(query);
                URL url = null;

                try {
                    url = new URL(uri.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                if (uri != null) {
                    new Pogodas().execute(url);
                }
            }
        });


    }

    public class Pogodas extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);
            text.setVisibility(View.VISIBLE);
            if (s != null && !s.equals("")) {
                pogo.clear();
                try {
                    JSONObject in = new JSONObject(s);


                    JSONObject cityobj = in.getJSONObject("city");
                    String city = cityobj.getString("name");
                    JSONArray jsonArray = in.getJSONArray("list");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        JSONObject main = obj.getJSONObject("main");
                        Double temp = main.getDouble("temp");
                        String data = obj.getString("dt_txt");
                        JSONArray opis = obj.getJSONArray("weather");
                        JSONObject opise = opis.getJSONObject(0);
                        String opisem = opise.getString("main");
                        Pogoda pogoda = new Pogoda( city, data, opisem, temp);
                        pogo.add(pogoda);
                    }
                    settext();

                } catch (JSONException e) {
                    e.printStackTrace(); 
                    text.setText(e.toString());
                }

            } else {
                text.setText("nie wyszukano");

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

        private void settext() {
            text.setText(" ");
            for (int i = 0; i < pogo.size(); i++) {
                Pogoda p = pogo.get(i);
                text.append(p.getMiasto() + "\n");
                text.append(p.getData() + "\n");
                text.append(p.getOpis() + "\n");
                text.append(p.getTemp() + "\n");
                text.append("---------------------\n");
            }


        }
    }
}
