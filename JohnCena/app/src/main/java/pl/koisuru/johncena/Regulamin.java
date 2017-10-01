package pl.koisuru.johncena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Regulamin extends AppCompatActivity {
    private Button przycisk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regulamin);

        przycisk =(Button) findViewById(R.id.przy);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"zaakceptowano",Toast.LENGTH_SHORT).show();

            }
        });


    }

}
