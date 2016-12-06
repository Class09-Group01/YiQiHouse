package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.fragment.YiQiGroupFragmentDesign;
import com.bwf.aiyiqi.gui.fragment.YiQiGroupFragmentHeadman;
import com.bwf.aiyiqi.gui.fragment.YiQiGroupFragmentSupervision;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lingchen52 on 2016/11/28.
 */

public class YiQiGroupActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    @BindView(R.id.tablayout_yiqigroup_activity)
    SmartTabLayout mTablayout;
    @BindView(R.id.viewpager_yiqigroup_activity)
    ViewPager mViewpager;
    @BindView(R.id.back_activity_decoration_company)
    ImageView mBackActivityDecorationCompany;
    @BindView(R.id.title)
    TextView mTitle;

    private FragmentPagerItemAdapter itemAdapter;

    @Override
    protected void initDatas() {
        mViewpager.setOffscreenPageLimit(3);
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mTitle.setText("一起团队");
        FragmentPagerItems.Creator creator = FragmentPagerItems.with(this);
        creator.add("设计师", YiQiGroupFragmentDesign.class)
                .add("工长", YiQiGroupFragmentHeadman.class)
                .add("监理", YiQiGroupFragmentSupervision.class);
        itemAdapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), creator.create());
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

    @OnClick(R.id.back_activity_decoration_company)
    public void onClick() {
        finish();
        return;
    }
}
