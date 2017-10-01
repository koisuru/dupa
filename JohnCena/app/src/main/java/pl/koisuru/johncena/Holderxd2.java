package pl.koisuru.johncena;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by uczen on 2017-10-01.
 */

public class Holderxd2 extends RecyclerView.ViewHolder {
    private TextView tekscik;

    public Holderxd2(View itemView) {
        super(itemView);
        tekscik=(TextView)itemView.findViewById(R.id.te);
    }
    public void pfff(int i ){
        tekscik.setText(i+"TUTUTUTUTU");
    }
}
