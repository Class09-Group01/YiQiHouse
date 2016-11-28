package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.bwf.aiyiqi.gui.fragment.DecorateBudgetFragmentOffer;
import com.bwf.aiyiqi.gui.fragment.DecorateMyBudgetFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */
public class DecorateBudgetAdaper  extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private String tab[]={"装修报价","我的预算"};
    public DecorateBudgetAdaper(FragmentManager fm) {
        super(fm);
        mFragments=new ArrayList<>();
        for (int i = 0; i <tab.length ; i++) {
            if(i==0){
                mFragments.add(DecorateBudgetFragmentOffer.newInstance());
            }else{
               mFragments.add(DecorateMyBudgetFragment.newInstance());
            }

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
        return tab[position];
    }
}
