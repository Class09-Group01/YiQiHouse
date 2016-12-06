package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.bwf.aiyiqi.entity.ResponseAutoOrder;
import com.bwf.aiyiqi.gui.fragment.AutoOrderFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingchen52 on 2016/12/5.
 */

public class OrderFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private ResponseAutoOrder datas;
    public OrderFragmentPagerAdapter(FragmentManager fm ,ResponseAutoOrder datas) {
        super(fm);
        this.datas = datas;
        mFragments = new ArrayList<>();
        mFragments.add(new AutoOrderFragment(0,datas));
        for (int i = 0; i < datas.getData().size(); i++) {
            mFragments.add(new AutoOrderFragment(i+1,datas));
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
        if(position == 0){
            return "全部";
        }
        return datas.getData().get(position-1).getName();
    }
}
