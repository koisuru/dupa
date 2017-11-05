package pl.koisuru.powtorka;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by uczen on 2017-11-04.
 */

public class Holdertru extends RecyclerView.ViewHolder implements View.OnClickListener{
    private Context context;
    private TextView tytul;
    private ImageView logo;
    private RatingBar ocena;
    private Klasa klasa;
    public Holdertru(View itemView, Context context) {
        super(itemView);
        this.context=context;
        tytul = (TextView)itemView.findViewById(R.id.tytul);
        logo = (ImageView)itemView.findViewById(R.id.icona);
        ocena = (RatingBar)itemView.findViewById(R.id.gwiazdki);

        itemView.setOnClickListener(this);
    }
    public void binData(Klasa klasa){
        this.klasa=klasa;
        tytul.setText(klasa.getTytul());
        ocena.setRating(klasa.getOcena());
        Glide.with(context)
                .load(klasa.getLogo())
                .into(logo);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent( context, Drugie.class);
        intent.putExtra("app", klasa);
        context.startActivity(intent);



    }
}
