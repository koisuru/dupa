package pl.koisuru.tududu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by uczen on 2017-10-08.
 */

public class Ak extends AppCompatActivity {
    private Button far;
    private Button kal;
    private Button changr;
    private TextView deg;
    private TextView city;
    private EditText cityEt;
    private Button cel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pref);

        cel = (Button)findViewById(R.id.cel);
        far = (Button)findViewById(R.id.far);
        kal = (Button)findViewById(R.id.kal);
        changr =(Button)findViewById(R.id.change);
        deg = (TextView)findViewById(R.id.deg);
        city= (TextView)findViewById(R.id.city);
        cityEt = (EditText) findViewById(R.id.city_et);
        final SharedPreferences sharedPref = getSharedPreferences("pogoda", Context.MODE_PRIVATE);

        cel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("stopnie", "C" );
                editor.commit();
                String b = sharedPref.getString("stopnie","C");
                deg.setText(b);


            }
        });
        far.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("stopnie", "F" );
                editor.commit();
                String b = sharedPref.getString("stopnie","F");
                deg.setText(b);
            }
        });
        kal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("stopnie", "K" );
                editor.commit();
                String b = sharedPref.getString("stopnie","K");
                deg.setText(b);
            }
        });
        changr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("miasto", cityEt.getText().toString() );
                editor.commit();
                String b = sharedPref.getString("miasto",cityEt.getText().toString());
                city.setText(b);


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("pogoda", Context.MODE_PRIVATE);
        String s = sharedPref.getString("stopnie", "C");
        String m = sharedPref.getString("miasto", "Warszawa");

        deg.setText(s);
        city.setText(m);

    }
}
