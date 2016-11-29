package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.bwf.aiyiqi.framwork.tool.Contact;
import com.bwf.aiyiqi.gui.fragment.DecorateSchoolListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 * 功能描述：
 * 作者：
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> mFragments;
    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments=new ArrayList<>();
        for (int i = 0; i < Contact.tab.length ; i++) {
            mFragments.add(DecorateSchoolListFragment.newInstance(i+1));
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
    //复写destroyItem方法，去掉调用父类的，表示不销毁容器里的
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
    @Override
    public CharSequence getPageTitle(int position) {
        return Contact.tab[position];
    }
}
