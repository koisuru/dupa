package pl.koisuru.film;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button przycisk1;
    private Button przycisk2;
    private EditText editText;
    private static int permisja = 6969;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przycisk1=(Button)findViewById(R.id.przy);
        przycisk2 = (Button)findViewById(R.id.przyc);
        editText = (EditText)findViewById(R.id.edi);

        przycisk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("film",editText.getText().toString());
                startActivity(intent);

            }
        });
        przycisk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >=23){
                    int pytanie = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
                    if (pytanie != PackageManager.PERMISSION_GRANTED){
                        //nie masz permisji
                        ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},permisja);
                    }else {
                        Startowanie();
                        // todo tu odpali sie aktywnosc
                    }
                }else {
                  //todo tu odpali sie funkcja startu aktywnosci
                    Startowanie();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == permisja) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Startowanie();

            } else {
                //permisji nie nadano
                Toast.makeText(getApplicationContext(), "nie dla psa", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void Startowanie(){
        Intent intent =new Intent(this, Pliki.class);
        startActivity(intent);
    }
}
