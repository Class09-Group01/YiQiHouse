package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class EffectPictureFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    private String titles[];


    public EffectPictureFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        data = new ArrayList<>();
        titles = new String[]{"专题","美图"};
    }

    public void addData(List<Fragment> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setData(List<Fragment> data){
        this.data.clear();
        addData(data);
    }

    public void clearData(){
        this.data.clear();
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
