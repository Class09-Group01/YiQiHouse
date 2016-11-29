package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.TabFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 * 功能描述：
 * 作者：
 */

public class DecorateSchoolActivity extends BaseActivity {
    @BindView(R.id.decorateschool_backimage)
    ImageView mDecorateschoolBackimage;
    @BindView(R.id.decorateschool_tablayout)
    TabLayout mDecorateschoolTablayout;
    @BindView(R.id.decorateschool_imageall)
    ImageView mDecorateschoolImageall;
    @BindView(R.id.decorateschool_viewpager)
    ViewPager mDecorateschoolViewpager;
    private TabFragmentPagerAdapter tabFragmentPagerAdapter;

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mDecorateschoolTablayout.setupWithViewPager(mDecorateschoolViewpager);
        tabFragmentPagerAdapter=new TabFragmentPagerAdapter(getSupportFragmentManager());
        mDecorateschoolViewpager.setAdapter(tabFragmentPagerAdapter);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.decorateschool;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }
}
