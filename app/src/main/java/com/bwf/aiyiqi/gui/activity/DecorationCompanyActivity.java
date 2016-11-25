package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityListView;
import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityViewPager;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.gui.view.MyListView;
import com.bwf.aiyiqi.mvp.presenter.DecorationCompanyActivityPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.DecorationCompanyActivityPresenterImpl;
import com.bwf.aiyiqi.mvp.view.DecorationCompanyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lingchen52 on 2016/11/24.
 */

public class DecorationCompanyActivity extends BaseActivity implements DecorationCompanyView{
    @BindView(R.id.back_activity_decoration_company)
    View mBackActivityDecorationCompany;
    @BindView(R.id.newhouse_decoration_activity_decoration)
    RelativeLayout mNewhouseDecorationActivityDecoration;
    @BindView(R.id.oldhouse_decoration_activity_decoration)
    RelativeLayout mOldhouseDecorationActivityDecoration;
    @BindView(R.id.look_site_playing_decoration_activity_decoration)
    RelativeLayout mLookSitePlayingDecorationActivityDecoration;
    @BindView(R.id.site_playing_decoration_activity_decoration)
    RelativeLayout mSitePlayingDecorationActivityDecoration;
    @BindView(R.id.yiqi_group_decoration_activity_decoration)
    RelativeLayout mYiqiGroupDecorationActivityDecoration;
    @BindView(R.id.listView_activity_decoration_company)
    MyListView mListViewActivityDecorationCompany;

    private DecorationCompanyActivityPresenter mPresenter;

    @Override
    protected void initDatas() {
        mPresenter = new DecorationCompanyActivityPresenterImpl(this);
        mPresenter.load();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_decoration_company;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_activity_decoration_company, R.id.viewpager_fragment_main, R.id.newhouse_decoration_activity_decoration, R.id.oldhouse_decoration_activity_decoration, R.id.look_site_playing_decoration_activity_decoration, R.id.site_playing_decoration_activity_decoration, R.id.yiqi_group_decoration_activity_decoration})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_activity_decoration_company:

                break;
            case R.id.viewpager_fragment_main:

                break;
            case R.id.newhouse_decoration_activity_decoration:
                Intent intentnew = new Intent(this,HouseDecorationActivity.class);
                intentnew.putExtra("url", APIs.API_NEW_HOUSE_DECORATION);
                startActivity(intentnew);
                break;
            case R.id.oldhouse_decoration_activity_decoration:
                Intent intentold = new Intent(this,HouseDecorationActivity.class);
                intentold.putExtra("url", APIs.API_OLD_HOUSE_DECORATION);
                startActivity(intentold);
                break;
            case R.id.look_site_playing_decoration_activity_decoration:
                break;
            case R.id.site_playing_decoration_activity_decoration:
                break;
            case R.id.yiqi_group_decoration_activity_decoration:
                break;
        }
    }

    @Override
    public void showViewPager(ResponseDecorationCompanyActivityViewPager datas) {

    }

    @Override
    public void showListView(ResponseDecorationCompanyActivityListView datas) {

    }

    @Override
    public void showViewPagerFailed() {

    }

    @Override
    public void showListViewFailed() {

    }
}
