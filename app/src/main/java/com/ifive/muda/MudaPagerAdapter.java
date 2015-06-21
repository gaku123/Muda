package com.ifive.muda;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Locale;


public class MudaPagerAdapter extends FragmentStatePagerAdapter {

    MudaFragment[] mudas = new MudaFragment[2];

    public MudaPagerAdapter(FragmentManager fm) {
        super(fm);
        mudas[0] = MudaFragment.newInstance();
        mudas[1] = MudaFragment.newInstance();
    }

    public void update() {
        mudas[0].setMudaChishiki(mudas[1].getMudaChishiki());
        mudas[1].setMudaChishiki(new MudaChishiki(mudas[1]));
        mudas[0].update();
        mudas[1].update();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return mudas[0];
            case 1:
                return mudas[1];
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

}
