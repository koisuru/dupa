package pl.koisuru.tududu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by uczen on 2017-10-08.
 */

public class Adapterxd extends RecyclerView.Adapter<Holderxd> {

    private Context context;
    private List<Pogoda> pogodaList;

    public Adapterxd(Context context, List pogodaList) {
        this.context = context;
        this.pogodaList = pogodaList;
    }

    @Override
    public Holderxd onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.xd, parent, false);

        return new Holderxd(view, context);
    }

    @Override
    public void onBindViewHolder(Holderxd holder, int position) {
        holder.blindData(pogodaList.get(position));
    }

    @Override
    public int getItemCount() {
        return pogodaList.size();
    }


    public void podmien (List<Pogoda> list){
        pogodaList.clear();
        for (int i=0; i < list.size();i++){
            pogodaList.add(list.get(i));
            notifyItemInserted(pogodaList.size()-1);

        }



    }




}
