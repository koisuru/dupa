package pl.koisuru.tududu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by uczen on 2017-10-08.
 */

public class Holderxd extends RecyclerView.ViewHolder {
    private TextView desc;
    private TextView city;
    private TextView data;
    private TextView temp;
    private Context context;
    private ImageView imageView;


    public Holderxd(View itemView, Context context) {
        super(itemView);
        this.context=context;
        imageView = (ImageView)itemView.findViewById(R.id.logo);
        city= (TextView)itemView.findViewById(R.id.city_res);
        data = (TextView)itemView.findViewById(R.id.date_res);
        temp = (TextView)itemView.findViewById(R.id.temp_res);
        desc = (TextView)itemView.findViewById(R.id.group);

    }
    public void blindData (Pogoda f){
        city.setText(f.getMiasto());
        data.setText(f.getData());
        temp.setText(f.getTemp() + "");
        desc.setText(f.getOpis());

        Glide.with(context).load("http://openweathermap.org/img/w/" + f.getIcon()+".png").into(imageView);
    }
}
