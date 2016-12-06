package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.DesignHtmlFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lingchen52 on 2016/12/3.
 */

public class DesignActivity extends BaseActivity {
    @BindView(R.id.tablayout_activity_design)
    TabLayout mTablayoutActivityDesign;
    @BindView(R.id.viewpager_activity_design)
    ViewPager mViewpagerActivityDesign;
    @BindView(R.id.back_design_activity)
    View mBackDesignActivity;

    private DesignHtmlFragmentPagerAdapter mPagerAdapter;

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mTablayoutActivityDesign.setupWithViewPager(mViewpagerActivityDesign);
        mPagerAdapter = new DesignHtmlFragmentPagerAdapter(getSupportFragmentManager());
        mViewpagerActivityDesign.setAdapter(mPagerAdapter);

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_design;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    @OnClick(R.id.back_design_activity)
    public void onClick() {
        finish();
        return;
    }
}
