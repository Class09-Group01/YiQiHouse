package com.bwf.aiyiqi.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainFragmentRecycleviewData;
import com.bwf.aiyiqi.entity.ResponseMainFragmentViewPagerDatas;
import com.bwf.aiyiqi.gui.activity.AutoOrderActivity;
import com.bwf.aiyiqi.gui.activity.BuildingFurnitureActivity;
import com.bwf.aiyiqi.gui.activity.CityActiveActivity;
import com.bwf.aiyiqi.gui.activity.DecorateBudgetActivity;
import com.bwf.aiyiqi.gui.activity.DecorateSchoolActivity;
import com.bwf.aiyiqi.gui.activity.DecorationCompanyActivity;
import com.bwf.aiyiqi.gui.activity.DesignActivity;
import com.bwf.aiyiqi.gui.activity.EffectPictureActivity;
import com.bwf.aiyiqi.gui.activity.SearchActivity;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.BasePagerAdapter;
import com.bwf.aiyiqi.gui.adapter.MainFragmentPagerAdapter;
import com.bwf.aiyiqi.gui.adapter.MainFragmentRecycleAdapter;
import com.bwf.aiyiqi.gui.view.PagerDotIndicator;
import com.bwf.aiyiqi.gui.view.RecycleViewCustom;
import com.bwf.aiyiqi.gui.view.SlideViewPager;
import com.bwf.aiyiqi.mvp.presenter.Impl.MainFragmentImagePresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.Impl.MainFragmentRecyclePresenterImpl;
import com.bwf.aiyiqi.mvp.view.MainFragmentImage;
import com.bwf.aiyiqi.mvp.view.MainFragmentRecycleView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.uuzuche.lib_zxing.activity.CaptureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import com.bwf.aiyiqi.gui.adapter.MainFragmentPagerAdapter;

/**
 * Created by bobo on 2016/11/23.
 */


public class HomeFragment extends BaseFragment implements MainFragmentImage, MainFragmentRecycleView {


    @BindView(R.id.fragment_home_title_bar_scan)
    ImageView fragmentHomeTitleBarScan;
    @BindView(R.id.fragment_home_title_bar_search)
    RelativeLayout fragmentHomeTitleBarSearch;
    @BindView(R.id.fragment_home_title_bar_city)
    LinearLayout fragmentHomeTitleBarCity;
    @BindView(R.id.reflush)
    MaterialRefreshLayout reflush;
    @BindView(R.id.activity_home_recycleview)
    RecycleViewCustom activityHomeRecycleview;

    private LinearLayout mLinearLayout_dot;
    private SlideViewPager mSlideViewPager;
    private BasePagerAdapter mPagerAdapter;
    private PagerDotIndicator mDotIndicator;
    private MainFragmentRecyclePresenterImpl mRecyclePresenter;
    private MainFragmentRecycleAdapter mRecycleAdapter;
    private MainFragmentImagePresenterImpl mFragmentImagePresenter;
    private boolean isLoading = true;//是否正在加载，一进入就正在加载
    private boolean isNoMoreData;//判断是否是最后一页，没有更多数据了

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        mFragmentImagePresenter = new MainFragmentImagePresenterImpl(this);
        mFragmentImagePresenter.load();

        //进入后自动刷新，首次加载
        mRecyclePresenter = new MainFragmentRecyclePresenterImpl(this);
        mRecyclePresenter.loadRecycleData();

        //设置Recycleview的布局管理，以及adapter 必须设置，否则空白
        final LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        //解决scrollview 里面嵌套 Recycleview 滚动卡的问题配置
        manager.setSmoothScrollbarEnabled(true);
        manager.setAutoMeasureEnabled(true);
        activityHomeRecycleview.setHasFixedSize(true);
        activityHomeRecycleview.setNestedScrollingEnabled(false);

        mRecycleAdapter = new MainFragmentRecycleAdapter(getActivity());
        activityHomeRecycleview.setAdapter(mRecycleAdapter);
        activityHomeRecycleview.setLayoutManager(manager);


        //启动上拉加载更多 ，需要手动启动否则不生效
        reflush.setLoadMore(true);
        //设置下拉刷新监听
        reflush.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                //每次只加载第一页
                //设置下拉刷新监听
                mRecycleAdapter.clearData();
                mRecyclePresenter.loadReflresh();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                //设置上拉加载更多
                mRecyclePresenter.loadRecycleData();
            }
        });
    }

    private void initViews() {
        mSlideViewPager = (SlideViewPager) getActivity().findViewById(R.id.viewpager_fragment_main);
        mLinearLayout_dot = (LinearLayout) getActivity().findViewById(R.id.ll_indicator_fragment_main);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void showRecycleSuccess(ResponseMainFragmentRecycleviewData data) {
        isLoading = false;//已经加载完成
        reflush.finishRefresh();
        reflush.finishRefreshLoadMore();
        mRecycleAdapter.addData(data.getData());
        Toast.makeText(getActivity(), "data.getData().size():" + data.getData().size(), Toast.LENGTH_SHORT).show();

        //刷新一下当前底部的状态 -- FOORET_LOADING
        updateFooterState(mRecycleAdapter.FOORET_LOADING);
    }

    @Override
    public void showRecycleFail() {
        isLoading = false;//已经加载完成
        Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
//        reflush.finishRefresh();
//        reflush.finishRefreshLoadMore();


        //刷新一下当前底部的状态 -- FOOTER_FAIL
        updateFooterState(mRecycleAdapter.FOOTER_FAIL);
    }

    @Override
    public void showRecycleNoMoreData() {
        isLoading = false;//已经加载完成
        isNoMoreData = true;//没有更多数据了
        Toast.makeText(getActivity(), "nodata", Toast.LENGTH_SHORT).show();
        reflush.finishRefresh();
        reflush.finishRefreshLoadMore();

        //刷新一下当前底部的状态 -- FOORET_NOMOREDATA
        updateFooterState(mRecycleAdapter.FOORET_NOMOREDATA);
    }

    //更新底部的当前状态
    public void updateFooterState(int foot_style) {
        mRecycleAdapter.setFooter_type(foot_style);
        mRecycleAdapter.notifyItemChanged(mRecycleAdapter.getItemCount() - 1);
    }


    @OnClick({R.id.fragment_home_title_bar_scan, R.id.fragment_home_title_bar_search,
            R.id.fragment_home_title_bar_city, R.id.recycle_linearlayout_package_new,
            R.id.recycle_linearlayout_activity, R.id.recycle_linearlayout_school,
            R.id.recycle_linearlayout_my_budget, R.id.recycle_linearlayout_category,
            R.id.recycle_linearlayout_rending_new, R.id.recycle_linearlayout_self_order,
            R.id.recycle_linearlayout_design_measure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_title_bar_scan:
                startActivity(new Intent(getActivity(), CaptureActivity.class));
                break;
            case R.id.fragment_home_title_bar_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.fragment_home_title_bar_city:
                break;
            case R.id.recycle_linearlayout_package_new:
                startActivity(new Intent(getActivity(), DecorationCompanyActivity.class));
                break;
            case R.id.recycle_linearlayout_activity:
                startActivity(new Intent(getActivity(), CityActiveActivity.class));
                break;
            case R.id.recycle_linearlayout_school:
                startActivity(new Intent(getActivity(), DecorateSchoolActivity.class));
                break;
            case R.id.recycle_linearlayout_my_budget:
                startActivity(new Intent(getActivity(), DecorateBudgetActivity.class));
                break;
            case R.id.recycle_linearlayout_category:
                startActivity(new Intent(getActivity(), BuildingFurnitureActivity.class));
                break;
            case R.id.recycle_linearlayout_rending_new:
                startActivity(new Intent(getActivity(), EffectPictureActivity.class));
                break;
            case R.id.recycle_linearlayout_self_order:
                startActivity(new Intent(getActivity(), AutoOrderActivity.class));
                break;
            case R.id.recycle_linearlayout_design_measure:
                startActivity(new Intent(getActivity(), DesignActivity.class));
                break;
        }
    }


    @Override
    public void showMainFragmentViewPagerImage(ResponseMainFragmentViewPagerDatas datas) {
        mDotIndicator = new PagerDotIndicator(getActivity(), mLinearLayout_dot, mSlideViewPager);
        mDotIndicator.setNumberDots(datas.getData().size());
        mDotIndicator.setCurrentDot(0);
        mPagerAdapter = new MainFragmentPagerAdapter<>(getContext(), datas.getData());
        mSlideViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void showLoadFailed() {

    }

}

