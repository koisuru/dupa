package pl.koisuru.johncena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by uczen on 2017-10-01.
 */

public class Ak2 extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ak1);
        String text;
        textView = (TextView)findViewById(R.id.cxz);

        Intent intent = getIntent();
        if (intent != null){
            text=intent.getStringExtra("dupa");
            textView.setText(text);


        }

    }
}
