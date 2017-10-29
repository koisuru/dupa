package pl.koisuru.film;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by uczen on 2017-10-22.
 */

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView textView;
    private Context context;
    public Holder(Context context, View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.tekscik);
        itemView.setOnClickListener(this);
        this.context = context;

    }
    public void data (String string){
        textView.setText(string);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context,Main2Activity.class);
        intent.putExtra("film",textView.getText().toString());
        context.startActivity(intent);
    }
}
