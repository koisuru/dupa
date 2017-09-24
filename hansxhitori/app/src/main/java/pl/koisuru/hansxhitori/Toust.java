package pl.koisuru.hansxhitori;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by uczen on 2017-09-24.
 */

public class Toust extends Activity {
    private Button przycisk;
    private Button przycisk2;
    private Button przycisk3;
    private Button przycisk4;
    private Button przycisk5;
    private Button przycisk6;
    private Button przycisk7;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jd);

        Toast.makeText(getApplicationContext(), "xd", Toast.LENGTH_SHORT).show();
        przycisk = (Button) findViewById(R.id.czerwony);

        przycisk2 = (Button) findViewById(R.id.czer);
        przycisk3 = (Button) findViewById(R.id.q);

        przycisk4 = (Button) findViewById(R.id.w);

        przycisk5 = (Button) findViewById(R.id.e);

        przycisk6 = (Button) findViewById(R.id.wu);

        
        przycisk7 = (Button) findViewById(R.id.wu);


        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), przycisk.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}