package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.mvp.presenter.YiQiGroupPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/11/28.
 */

public class YiQiGroupActivity extends BaseActivity {
    @BindView(R.id.tablayout_yiqigroup_activity)
    TabLayout mTablayoutYiqigroupActivity;
    @BindView(R.id.viewpager_yiqigroup_activity)
    ViewPager mViewpagerYiqigroupActivity;

    private YiQiGroupPresenter mPresenter;

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initViews() {
        mTablayoutYiqigroupActivity.setupWithViewPager(mViewpagerYiqigroupActivity);

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_yiqigroup;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
