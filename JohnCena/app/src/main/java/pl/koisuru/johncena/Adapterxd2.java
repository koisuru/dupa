package pl.koisuru.johncena;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by uczen on 2017-10-01.
 */

public class Adapterxd2 extends RecyclerView.Adapter<Holderxd2>{

    private List<Integer> data;
    private Context context;

    public Adapterxd2(Context context,List data){
        this.context=context;
        this.data=data;
    }


    @Override
    public Holderxd2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle2,parent,false);
        return new Holderxd2(view);
    }

    @Override
    public void onBindViewHolder(Holderxd2 holder, int position) {
        int i =data.get(position);
        holder.pfff(i);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
