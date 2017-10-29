package pl.koisuru.tududu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by uczen on 2017-10-29.
 */

public class PagerAdapet extends FragmentPagerAdapter {

    public PagerAdapet(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return Pierwszyfragment.newInstance();
            case 1:
                return Drugifragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
