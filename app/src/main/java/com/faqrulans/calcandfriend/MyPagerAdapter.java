package com.faqrulans.calcandfriend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by faqrulan on 12/24/16.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 4; //Harus Diubah kalo mau nambah atau ngurangin fragment

    public MyPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                //return FirstFragment.newInstance(0,"Page 1");
                return new CalculatorFragment();
            case 1:
                return new TemperatureFragment();
            case 2:
                return new LengthConvertFragment();
            case 3:
                return new MassConvertFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {

        return NUM_ITEMS;
    }

    /**
     * Faqrul
     * Method untuk ngasiih text di indicatornya tiap fragmentnya
     */

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}

/**
 * Created by faqrulan on 2/8/17.
 */

