package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseAutoOrder;
import com.bwf.aiyiqi.gui.adapter.OrderFragmentPagerAdapter;
import com.bwf.aiyiqi.mvp.presenter.AutoOrderPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.AutoOrderPresenterImpl;
import com.bwf.aiyiqi.mvp.view.AutoOrderView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lingchen52 on 2016/12/5.
 */

public class AutoOrderActivity extends BaseActivity implements AutoOrderView {
    @BindView(R.id.tablayout_auto_order)
    TabLayout mTablayoutAutoOrder;
    @BindView(R.id.viewpager_auto_order)
    ViewPager mViewpagerAutoOrder;
    @BindView(R.id.back_activity_decoration_company)
    ImageView mBackActivityDecorationCompany;
    @BindView(R.id.title)
    TextView mTitle;

    private AutoOrderPresenter mPresenter;
    private OrderFragmentPagerAdapter mPagerAdapter;

    @Override
    protected void initDatas() {
        mPresenter = new AutoOrderPresenterImpl(this);
        mPresenter.loadData();
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mTitle.setText("自助下单");

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_auto_order;
    }


    @Override
    public void showGridview(ResponseAutoOrder datas) {
        mPagerAdapter = new OrderFragmentPagerAdapter(getSupportFragmentManager(), datas);
        mViewpagerAutoOrder.setAdapter(mPagerAdapter);
        mTablayoutAutoOrder.setupWithViewPager(mViewpagerAutoOrder);
    }

    @Override
    public void showLoadFailed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_activity_decoration_company)
    public void onClick() {
        finish();
        return;
    }
}
