package pl.koisuru.powtorka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by uczen on 2017-11-04.
 */

public class Drugie extends AppCompatActivity {
    private ImageView logo;
    private TextView tytul;
    private RatingBar bar;
    private TextView opis;
    private Klasa klasa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widok);
        logo=(ImageView)findViewById(R.id.okladka);
        tytul=(TextView)findViewById(R.id.tytulik);
        bar=(RatingBar)findViewById(R.id.ocena);
        opis = (TextView)findViewById(R.id.opis);

        Intent intent = getIntent();
        if (intent !=null){
            klasa=(Klasa)intent.getSerializableExtra("app");
        }


                if(klasa != null){
                    tytul.setText(klasa.getTytul());
                    bar.setRating(klasa.getOcena());
                    opis.setText(klasa.getOpis());
                    Glide.with(this)
                            .load(klasa.getLogo()).into(logo);

                }
    }

}
