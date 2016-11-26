package com.bwf.aiyiqi.gui.adapter.BaseAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */



//没有封装
public class BaseFragmentPagerAdapter<T> extends FragmentPagerAdapter {

    private List<T> t;


    public BaseFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
