package pl.koisuru.tududu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by uczen on 2017-10-08.
 */

public class Ak extends AppCompatActivity {
    private Button far;
    private Button kal;
    private Button changr;
    private TextView deg;
    private TextView city;
    private EditText cityEt;
    private Button cel;
    private Boolean czyzmieniono = false;
    private String miast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pref);

        cel = (Button) findViewById(R.id.cel);
        far = (Button) findViewById(R.id.far);
        kal = (Button) findViewById(R.id.kal);
        changr = (Button) findViewById(R.id.change);
        deg = (TextView) findViewById(R.id.deg);
        city = (TextView) findViewById(R.id.city);


        cel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deg.setText("C");
                czyzmieniono = true;


            }
        });
        far.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deg.setText("F");
                czyzmieniono = true;
            }
        });
        kal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deg.setText("K");
                czyzmieniono = true;
            }
        });
        changr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Ak.this);
                LayoutInflater inflater = Ak.this.getLayoutInflater();
                View dialogview = inflater.inflate(R.layout.zmiana, null);
                builder.setView(dialogview);
                final AlertDialog alertDialog = builder.create();
                final EditText editText = (EditText) dialogview.findViewById(R.id.miasto);
                Button button = (Button) dialogview.findViewById(R.id.zatwierdz);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        miast = editText.getText().toString();

                        city.setText(editText.getText().toString());
                        alertDialog.dismiss();
                        czyzmieniono = true;
                    }
                });
                alertDialog.show();


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("pogoda", Context.MODE_PRIVATE);
        String s = sharedPref.getString("stopnie", "C");
        String m = sharedPref.getString("miasto", "Warszawa");

        deg.setText(s);
        city.setText(m);

    }

    @Override
    public void onBackPressed() {
        if (czyzmieniono == true) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Ak.this);
            builder.setTitle("czy chcesz zapisać")
                    .setMessage("chcesz zapisać swoje ustawienia")
                    .setPositiveButton("tak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SharedPreferences sharedPref = getSharedPreferences("pogoda", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor;
                            editor = sharedPref.edit();
                            editor.putString("stopnie", deg.getText().toString());
                            editor.putString("miasto", city.getText().toString());
                            editor.commit();
                            Ak.super.onBackPressed();


                        }
                    })
                    .setNegativeButton("nie", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Ak.super.onBackPressed();

                        }
                    })
                    .show();

        } else {
            super.onBackPressed();
        }

    }
}
