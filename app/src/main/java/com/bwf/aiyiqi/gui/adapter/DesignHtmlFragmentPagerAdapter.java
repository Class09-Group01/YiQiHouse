package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.bwf.aiyiqi.gui.fragment.DesignFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingchen52 on 2016/12/5.
 */

public class DesignHtmlFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    String[] tabs = {"免费设计","免费量房"};
    public DesignHtmlFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mFragments.add(DesignFragment.newInstant(1));
        mFragments.add(DesignFragment.newInstant(2));
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
