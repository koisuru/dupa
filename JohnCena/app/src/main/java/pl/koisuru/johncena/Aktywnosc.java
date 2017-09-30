package pl.koisuru.johncena;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-09-30.
 */

public class Aktywnosc extends AppCompatActivity {
    private RecyclerView recy;
    private FloatingActionButton przycisk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xd);
        recy = (RecyclerView) findViewById(R.id.xd);
        przycisk =(FloatingActionButton) findViewById(R.id.przyc) ;

        final List<Album> albums = new LinkedList<>();
        albums.add(new Album(" 鋼の錬金術師", "Bones", "2009", R.drawable.full));
        albums.add(new Album(" グレート・ティーチャー・オニヅカ", "Studio Pierrot", "1999", R.drawable.gto));
        albums.add(new Album(" ワンパンマン", " Madhouse", "2015", R.drawable.punch));
        albums.add(new Album("モンスター", "Madhouse", " 2004", R.drawable.mos));
        albums.add(new Album(" 鋼の錬金術師", "Bones", "2009", R.drawable.full));
        albums.add(new Album(" グレート・ティーチャー・オニヅカ", "Studio Pierrot", "1999", R.drawable.gto));
        albums.add(new Album(" ワンパンマン", " Madhouse", "2015", R.drawable.punch));
        albums.add(new Album("モンスター", "Madhouse", " 2004", R.drawable.mos));
        albums.add(new Album(" 鋼の錬金術師", "Bones", "2009", R.drawable.full));
        albums.add(new Album(" グレート・ティーチャー・オニヅカ", "Studio Pierrot", "1999", R.drawable.gto));
        albums.add(new Album(" ワンパンマン", " Madhouse", "2015", R.drawable.punch));
        albums.add(new Album("モンスター", "Madhouse", " 2004", R.drawable.mos));
        albums.add(new Album(" 鋼の錬金術師", "Bones", "2009", R.drawable.full));
        albums.add(new Album(" グレート・ティーチャー・オニヅカ", "Studio Pierrot", "1999", R.drawable.gto));
        albums.add(new Album(" ワンパンマン", " Madhouse", "2015", R.drawable.punch));
        albums.add(new Album("モンスター", "Madhouse", " 2004", R.drawable.mos));
        albums.add(new Album(" 鋼の錬金術師", "Bones", "2009", R.drawable.full));
        albums.add(new Album(" グレート・ティーチャー・オニヅカ", "Studio Pierrot", "1999", R.drawable.gto));
        albums.add(new Album(" ワンパンマン", " Madhouse", "2015", R.drawable.punch));
        albums.add(new Album("モンスター", "Madhouse", " 2004", R.drawable.mos));

        final Adapterxd adapter = new Adapterxd(this, albums);
        recy.setAdapter(adapter);
        recy.setLayoutManager(new LinearLayoutManager(this));


        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Album album = new Album(" 鋼の錬金術師", "Bones", "2009", R.drawable.full);
                adapter.dodaj(album);
                recy.scrollToPosition(adapter.getItemCount()-1);
            }
        });


    }
}
