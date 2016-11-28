package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.bwf.aiyiqi.gui.fragment.YiQiGroupFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingchen52 on 2016/11/28.
 */

public class TabLayoutYiQiGroupAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    String[] tabs = {"设计师","工长","监理"};
    public TabLayoutYiQiGroupAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        for (int i = 0; i < tabs.length; i++) {
            mFragments.add(YiQiGroupFragment.newInstance(i+1));
        }
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
