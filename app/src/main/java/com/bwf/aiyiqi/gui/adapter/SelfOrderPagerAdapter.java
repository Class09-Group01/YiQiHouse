package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

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

    public void addTab(List<String> titles){
        selfOrder_Titles.addAll(titles);
        for (int i = 0; i < selfOrder_Titles.size() +1; i++) {
            selfOrder_fragments.add(new SelfOrderFragment().getFragment());
        }
        notifyDataSetChanged();
    }


    public Fragment getItem(int position) {
        return selfOrder_fragments.get(position);
    }

    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "全部";
        }else{
            return selfOrder_Titles.get(position - 1);
        }
    }

    public int getCount() {
        return selfOrder_fragments.size();
    }
}
