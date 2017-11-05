package pl.koisuru.powtorka;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-11-04.
 */

public class Adaptertru extends RecyclerView.Adapter<Holdertru> {
    private Context context;
    private LinkedList<Klasa> klasas;
    public  Adaptertru (Context context,LinkedList<Klasa> klasas){
        this.context=context;
        this.klasas=klasas;

    }
    @Override
    public Holdertru onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main,parent,false);

        return new Holdertru(view,context);
    }

    @Override
    public void onBindViewHolder(Holdertru holder, int position) {
        holder.binData(klasas.get(position));

    }

    @Override
    public int getItemCount() {
        return klasas.size();
    }
}
