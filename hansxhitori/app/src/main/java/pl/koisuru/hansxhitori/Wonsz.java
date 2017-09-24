package pl.koisuru.hansxhitori;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Wonsz extends Activity {
    AppCompatEditText edit;
    AppCompatEditText edit2;
    Button loguj;
    boolean xd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noob);
        edit = (AppCompatEditText) findViewById(R.id.log);
        loguj = (Button) findViewById(R.id.przy);
        edit2 = (AppCompatEditText) findViewById(R.id.has);

        loguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xd = true;
                if (edit.getText().toString().isEmpty()) {
                    edit.setError("Login nie może być pusty");
                    xd = false;
                } else {
                    edit.setError(null);
                }
                if (edit.getText().toString().isEmpty()) {
                    edit2.setError("hasło nie może być puste");
                    xd = false;
                } else {
                    edit2.setError(null);
                }

                if (xd == true) {
                    if (edit.getText().toString().equals("koisuru") && edit2.getText().toString().equals("dupa")) {
                        Toast.makeText(getApplicationContext(), "zalogowano", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "błędne dane", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
