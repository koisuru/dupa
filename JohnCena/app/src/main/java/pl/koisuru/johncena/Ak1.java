package pl.koisuru.johncena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by uczen on 2017-10-01.
 */

public class Ak1 extends AppCompatActivity {

    private Button przycisk;
    private EditText tekst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ak2);

        przycisk = (Button)findViewById(R.id.zxc);
        tekst = (EditText)findViewById(R.id.xz);


        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = tekst.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Ak2.class);
                intent.putExtra("dupa", a);
                startActivity(intent);
            }
        });


    }
}
