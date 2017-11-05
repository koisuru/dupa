package pl.koisuru.powtorka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Klasa> klasas=new LinkedList<>();
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle);
        for (int i =0; i<10; i++) {

            klasas.add(new Klasa("Saper", "https://lh3.googleusercontent.com/0ov1-rv3uTpw4KQphQUemyHPslZ4a8q-5C3c89lbXUKjbo9RzVaYH4F8_sMJBm4dsR0=w300-rw", getResources().getString(R.string.opis1), 4.6f));
        }
        recyclerView = (RecyclerView)findViewById(R.id.recycle);
        recyclerView.setAdapter(new Adaptertru(this,klasas));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
