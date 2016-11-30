package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.bwf.aiyiqi.gui.fragment.EssenceFragment;
import com.bwf.aiyiqi.gui.fragment.PlateFragment;
import com.bwf.aiyiqi.gui.fragment.RecentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */
public class FragmentSayViewpagerAdapter extends FragmentPagerAdapter{
   private List<Fragment> fragments;
    private String [] tabs={"精华","最新","板块"};
    public FragmentSayViewpagerAdapter(FragmentManager fm) {
        super(fm);
        fragments=new ArrayList<>();
        fragments.add(new EssenceFragment());
        fragments.add(new RecentFragment());
        fragments.add(new PlateFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
