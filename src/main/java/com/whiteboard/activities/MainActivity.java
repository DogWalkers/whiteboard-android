package com.whiteboard.activities;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.whiteboard.R;
import com.whiteboard.adapters.MainPagerAdapter;

public class MainActivity extends ActionBarActivity {

    MainPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create a pager adapter, and pass it to the view pager
        mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        ViewPager vp = (ViewPager) findViewById(R.id.pager);
        vp.setAdapter(mPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}