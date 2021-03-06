package pl.koisuru.johncena;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by uczen on 2017-09-30.
 */

class Holderxd extends RecyclerView.ViewHolder implements View.OnClickListener ,View.OnLongClickListener {
    private TextView text;
    private TextView text2;
    private TextView text3;
    private ImageView obrazek;
    private Context context;
    private Adapterxd adapter;

    public Holderxd(View itemView, Context context, Adapterxd adapter ) {
        super(itemView);
        this.context = context;
        text = itemView.findViewById(R.id.nazwa);
        text2 = itemView.findViewById(R.id.studio);
        text3 = itemView.findViewById(R.id.rok);
        obrazek = itemView.findViewById(R.id.imige);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        this.adapter = adapter;


    }
    public void widok(Album a){
        text.setText(a.getTytul());
        text2.setText(a.getWydawnictwo());
        text3.setText(a.getRok());
        obrazek.setImageDrawable(context.getDrawable(a.getOkladka()));


    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, text.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view) {
        adapter.usun(getAdapterPosition());

        return false;
    }
}
