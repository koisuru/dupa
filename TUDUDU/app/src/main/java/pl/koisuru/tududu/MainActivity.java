package pl.koisuru.tududu;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView text;
    private Button przycisk;
    private final String API_KAY = "&APPID=e600af897818f3effd73326b4559b1f8";
    private final String Base_url = "http://api.openweathermap.org/data/2.5/forecast?q=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.q);
        text = (TextView)findViewById(R.id.e);
        przycisk=(Button)findViewById(R.id.w);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = Base_url + editText.getText().toString() + API_KAY;
                Uri uri = Uri.parse(query);
                URL url = null;

                try {
                    url = new URL(uri.toString());
                }catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                if (uri != null){
                    new Pogoda().execute(url);
                }
            }
        });




    }
    public class Pogoda extends AsyncTask<URL, Void, String>{

        @Override
        protected void onPostExecute(String s) {
            if (s != null && !s.equals("")){
                text.setText(s);

            }else {
                text.setText("nie wyszukano");

            }
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];
            String tu = null;
            try {

                tu = Internet.odpowiedz(url);
            }catch (IOException e){
                e.printStackTrace();
            }
            return tu;
        }
    }
}
