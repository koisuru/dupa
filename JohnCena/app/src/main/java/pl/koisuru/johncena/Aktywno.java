package pl.koisuru.johncena;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-10-01.
 */

public class Aktywno extends AppCompatActivity  {

    private TextView text;
    private RecyclerView recy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xd2);

        text = (TextView) findViewById(R.id.te);
        recy = (RecyclerView) findViewById(R.id.recy);

        List<Integer>data = new LinkedList<>();
        for (int i=0; i < 60; i++){
            data.add(i);

        }

        Adapterxd2 adapterxd2= new Adapterxd2(this,data);

        recy.setAdapter(adapterxd2);
        recy.setLayoutManager(new LinearLayoutManager(this));






    }
}
