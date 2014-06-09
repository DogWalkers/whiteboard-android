package com.whiteboard.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.whiteboard.fragments.FragmentA;
import com.whiteboard.fragments.FragmentB;
import com.whiteboard.fragments.FragmentC;

/**
 * Created by Sahil Jain on 07/06/2014.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    public static final String[] TITLES = {"Browse", "Add", "Discover"};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FragmentA();
                break;
            case 1:
                fragment = new FragmentB();
                break;
            default:
                fragment = new FragmentC();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
