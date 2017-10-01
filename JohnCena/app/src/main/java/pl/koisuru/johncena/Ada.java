package pl.koisuru.johncena;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by uczen on 2017-10-01.
 */

public class Ada extends PagerAdapter {
    private Context context;
    private List<Ksiazka> ksiazkaList;

    public Ada(Context context, List ksiazkaList) {
        this.context = context;
        this.ksiazkaList = ksiazkaList;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.przejscia, container, false);
        TextView tytul;
        TextView opis;
        tytul = (TextView) view.findViewById(R.id.qw);
        opis = (TextView) view.findViewById(R.id.wq);
        Ksiazka ksiazka = ksiazkaList.get(position);
        tytul.setText(ksiazka.getTytul());
        opis.setText(ksiazka.getStreszczenie());
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return ksiazkaList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == (object);
    }
}
