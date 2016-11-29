package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.fragment.YiQiGroupFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/11/28.
 */

public class YiQiGroupActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    @BindView(R.id.tablayout_yiqigroup_activity)
    SmartTabLayout mTablayout;
    @BindView(R.id.viewpager_yiqigroup_activity)
    ViewPager mViewpager;

    private FragmentPagerItemAdapter itemAdapter;
    @Override
    protected void initDatas() {
        mViewpager.setOffscreenPageLimit(3);
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        FragmentPagerItems.Creator creator = FragmentPagerItems.with(this);
        creator.add("设计师", YiQiGroupFragment.class)
                .add("工长",YiQiGroupFragment.class)
                .add("监理",YiQiGroupFragment.class);
        itemAdapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),creator.create());
        mViewpager.setAdapter(itemAdapter);
        mTablayout.setViewPager(mViewpager);
        mTablayout.setOnPageChangeListener(this);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_yiqigroup;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
