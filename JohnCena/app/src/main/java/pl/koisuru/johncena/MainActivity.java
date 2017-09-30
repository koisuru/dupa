package pl.koisuru.johncena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private Button przycisk;private Button przycisk1;private Button przycisk2;
    private TextView teksik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        przycisk = (Button) findViewById(R.id.gus);
        przycisk1 = (Button) findViewById(R.id.andre);
        przycisk2 = (Button) findViewById(R.id.miron);
        teksik = (TextView) findViewById(R.id.tex);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teksik.setTextColor( getResources().getColor(R.color.gugus));
            }
        });
        przycisk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teksik.setTextColor( getResources().getColor(R.color.andre));
            }
        });
        przycisk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teksik.setTextColor( getResources().getColor(R.color.miron));
            }
        });




    }
}
