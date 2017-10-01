package pl.koisuru.johncena;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by uczen on 2017-10-01.
 */

public class Google extends AppCompatActivity {

    private EditText editText;
            private Button przycisk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wyszukaj);
        editText=(EditText)findViewById(R.id.szukaj);
        przycisk=(Button)findViewById(R.id.wyszukaj);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                openWebPage(str);

            }
        });



    }
    public void openWebPage(String url) {
        Uri webpage = Uri.parse("https://www.google.pl/search?q="+url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
