package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwf.aiyiqi.gui.adapter.BaseAdapter.BaseFragmentPagerAdapter;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.BasePagerAdapter;
import com.bwf.aiyiqi.gui.fragment.SelfOrderFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/29.
 */

public class SelfOrderPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> selfOrder_fragments ;
    private List<String> selfOrder_Titles ;


    public SelfOrderPagerAdapter(FragmentManager fm) {
        super(fm);
        selfOrder_fragments=new ArrayList<>();
        selfOrder_Titles=new ArrayList<>();

    }

    public void addTab(List<String> selfOrder_Titles){
        this.selfOrder_Titles.addAll(selfOrder_Titles);
        for (int i = 0; i < selfOrder_Titles.size(); i++) {
            selfOrder_fragments.add(new SelfOrderFragment().getFragment());
        }
    }


    public Fragment getItem(int position) {
        return selfOrder_fragments.get(position);
    }

    public CharSequence getPageTitle(int position) {
        return selfOrder_Titles.get(position);
    }

    public int getCount() {
        return selfOrder_fragments.size();
    }
}
