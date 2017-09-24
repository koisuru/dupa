package pl.koisuru.hansxhitori;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by uczen on 2017-09-24.
 */

public class Activity extends AppCompatActivity {
    private AppCompatEditText tekst;
    private Button przycisk;
    private TextView napis;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flejm);
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


    }

}
