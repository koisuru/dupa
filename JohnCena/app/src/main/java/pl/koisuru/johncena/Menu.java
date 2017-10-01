package pl.koisuru.johncena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by uczen on 2017-10-01.
 */

public class Menu extends AppCompatActivity {

    private Button przycisk;
    private Button przycisk1;
    private Button przycisk2;
    private Button przycisk3;
    private Button przycisk4;
    private Button przycisk5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        przycisk = (Button) findViewById(R.id.m);
        przycisk1 = (Button) findViewById(R.id.n);
        przycisk2 = (Button) findViewById(R.id.b);
        przycisk3= (Button) findViewById(R.id.v);
        przycisk4 = (Button) findViewById(R.id.c);
        przycisk5 = (Button) findViewById(R.id.x);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Regulamin.class);
                startActivity(intent);
            }
        });


        przycisk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        przycisk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Aktywnosc.class);
                startActivity(intent);
            }
        });

        przycisk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Aktywno.class);
                startActivity(intent);
            }
        });

        przycisk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Akty.class);
                startActivity(intent);
            }
        });

        przycisk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Ak1.class);
                startActivity(intent);
            }
        });


    }

}
