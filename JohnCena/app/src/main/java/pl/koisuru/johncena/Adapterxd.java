package pl.koisuru.johncena;

import android.content.Context;
import android.support.v7.util.AsyncListUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-09-30.
 */

public class Adapterxd extends RecyclerView.Adapter<Holderxd> {
    private List<Album> lista;
    private Context context;

    public Adapterxd(Context context, List lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public Holderxd onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.recycle, parent, false);

        return new Holderxd(view, context);
    }

    @Override
    public void onBindViewHolder(Holderxd holder, int position) {
        Album a = lista.get(position);
        holder.widok(a);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
