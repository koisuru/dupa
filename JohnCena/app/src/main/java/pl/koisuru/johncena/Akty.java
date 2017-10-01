package pl.koisuru.johncena;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-10-01.
 */

public class Akty extends AppCompatActivity {
    private ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.przejcie);

        pager = (ViewPager) findViewById(R.id.przej);

        List<Ksiazka> ksiazkas = new LinkedList<>();
        ksiazkas.add(new Ksiazka(getResources().getString(R.string.Full), getResources().getString(R.string.fullo)));
        ksiazkas.add(new Ksiazka(getResources().getString(R.string.nounai), getResources().getString(R.string.nounaio)));
        ksiazkas.add(new Ksiazka(getResources().getString(R.string.ore), getResources().getString(R.string.oreo)));
        ksiazkas.add(new Ksiazka(getResources().getString(R.string.one), getResources().getString(R.string.oneo)));
        ksiazkas.add(new Ksiazka(getResources().getString(R.string.ojciec), getResources().getString(R.string.ojcieco)));

        Ada ada = new Ada(this,ksiazkas);
        pager.setAdapter(ada);


    }
}
