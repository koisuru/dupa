package pl.koisuru.johncena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by uczen on 2017-10-01.
 */

public class Stare extends AppCompatActivity {
    private AppCompatEditText tekst;
    private Button przycisk;
    private TextView napis;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stare);
        tekst = (AppCompatEditText) findViewById(R.id.eu);
        przycisk = (Button) findViewById(R.id.wu);
        napis = (TextView) findViewById(R.id.ru);


        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = tekst.getText().toString();
                napis.setText(a);


            }


        });

        if (savedInstanceState != null) {
            String a = savedInstanceState.getString("dup");
            napis.setText(a);

        }



    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String nap = napis.getText().toString();
        outState.putString("dup", nap);
    }
}
