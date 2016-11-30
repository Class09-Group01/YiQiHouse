package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.FragmentSayViewpagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/23.
 */

public class SayFragment extends BaseFragment {
    @BindView(R.id.fragment_say_searchimage)
    ImageView mFragmentSaySearchimage;
    @BindView(R.id.fragment_say_tablayout)
    TabLayout mFragmentSayTablayout;
    @BindView(R.id.fragment_say_viewpager)
    ViewPager mFragmentSayViewpager;
    private FragmentSayViewpagerAdapter mAdapter;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_say;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         init();
        loadData();

    }
    public void init(){
        mFragmentSayTablayout.setupWithViewPager(mFragmentSayViewpager);
        mAdapter=new FragmentSayViewpagerAdapter(getFragmentManager());
        mFragmentSayViewpager.setAdapter(mAdapter);
    }
    public void loadData(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
