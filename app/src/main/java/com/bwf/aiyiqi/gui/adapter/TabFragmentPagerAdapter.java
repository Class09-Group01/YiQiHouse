package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

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
    private String tab[]={"验房收房","装修公司","量房设计","辅材选购","主材选购","家居选购","装修合同","主体拆迁",
    "水电改造","防水处理","木土工程","瓦工工程","油工工程","主材安装","竣工验收","软装配饰","居家生活"};
    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments=new ArrayList<>();
        for (int i = 0; i <tab.length ; i++) {
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
        return tab[position];
    }
}
