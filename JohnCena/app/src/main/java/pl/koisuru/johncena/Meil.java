package pl.koisuru.johncena;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by uczen on 2017-10-01.
 */

public class Meil extends AppCompatActivity {
    private EditText adrees;
    private EditText temat;
    private EditText widad;
    private Button przycisk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meil);

        adrees=(EditText)findViewById(R.id.meil);
        temat=(EditText)findViewById(R.id.temat);
        widad=(EditText)findViewById(R.id.wiad);
        przycisk=(Button)findViewById(R.id.wyslij);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = adrees.getText().toString();
                String te = temat.getText().toString();
                String mess = widad.getText().toString();

                String[]tabAdres = {email};
                composeEmail(tabAdres,te,mess);

            }
        });
    }
    public void composeEmail(String[] addresses, String subject, String tekst) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,tekst);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }else{
            Toast.makeText(this,"nie masz apki do maili",Toast.LENGTH_SHORT).show();
        }
    }
}
