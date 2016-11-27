package com.bwf.aiyiqi.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.bwf.aiyiqi.gui.activity.BuildingFurnitureActivity;
import com.bwf.aiyiqi.gui.activity.DecorateSchoolActivity;
import com.bwf.aiyiqi.gui.activity.SearchActivity;
import com.bwf.aiyiqi.gui.adapter.MainFragmentRecycleAdapter;
import com.bwf.aiyiqi.mvp.presenter.Impl.MainFragmentImagePresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.Impl.MainFragmentRecyclePresenterImpl;
import com.bwf.aiyiqi.mvp.view.MainFragmentImage;
import com.bwf.aiyiqi.mvp.view.MainFragmentRecycleView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import com.bwf.aiyiqi.gui.adapter.MainFragmentPagerAdapter;
/**
 * Created by bobo on 2016/11/23.
 */




public class HomeFragment extends BaseFragment implements MainFragmentImage,MainFragmentRecycleView {


    @BindView(R.id.fragment_home_title_bar_scan)
    ImageView fragmentHomeTitleBarScan;
    @BindView(R.id.fragment_home_title_bar_search)
    RelativeLayout fragmentHomeTitleBarSearch;
    @BindView(R.id.fragment_home_title_bar_city)
    LinearLayout fragmentHomeTitleBarCity;
    @BindView(R.id.reflush)
    MaterialRefreshLayout reflush;
    @BindView(R.id.activity_home_recycleview)
    RecyclerView activityHomeRecycleview;
    private MainFragmentRecyclePresenterImpl mRecyclePresenter;
    private MainFragmentRecycleAdapter mRecycleAdapter;
    private MainFragmentImagePresenterImpl mFragmentImagePresenter;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        mFragmentImagePresenter.load();

        MainFragmentImagePresenterImpl mFragmentImagePresenter = new MainFragmentImagePresenterImpl(this);
        mFragmentImagePresenter.load();
        mFragmentImagePresenter=new MainFragmentImagePresenterImpl(this);




        //进入后自动刷新，首次加载
        mRecyclePresenter = new MainFragmentRecyclePresenterImpl(this);
        mRecyclePresenter.loadRecycleData();


        //设置Recycleview的布局管理，以及adapter 必须设置，否则空白
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleAdapter = new MainFragmentRecycleAdapter(getActivity());
        activityHomeRecycleview.setAdapter(mRecycleAdapter);
        activityHomeRecycleview.setLayoutManager(manager);

        //设置下拉刷新监听
        reflush.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                //每次只加载第一页
                mRecyclePresenter.loadReflresh();
            }
        });
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
        reflush.finishRefresh();
        mRecycleAdapter.addData(data.getData());
        Toast.makeText(getActivity(), "data.getData().size():" + data.getData().size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRecycleFail() {
        Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
        reflush.finishRefresh();
    }

    @Override
    public void showRecycleNoMoreData() {
        Toast.makeText(getActivity(), "nodata", Toast.LENGTH_SHORT).show();
        reflush.finishRefresh();
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
                break;
            case R.id.fragment_home_title_bar_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.fragment_home_title_bar_city:
                break;
            case R.id.recycle_linearlayout_package_new:
                break;
            case R.id.recycle_linearlayout_activity:
                break;
            case R.id.recycle_linearlayout_school:
                startActivity(new Intent(getActivity(), DecorateSchoolActivity.class));
                break;
            case R.id.recycle_linearlayout_my_budget:
                break;
            case R.id.recycle_linearlayout_category:
                startActivity(new Intent(getActivity(), BuildingFurnitureActivity.class));
                break;
            case R.id.recycle_linearlayout_rending_new:
                break;
            case R.id.recycle_linearlayout_self_order:
                break;
            case R.id.recycle_linearlayout_design_measure:
                break;
        }
    }



    @Override
    public void showMainFragmentViewPagerImage(ResponseMainFragmentViewPagerDatas datas) {

    }

    @Override
    public void showLoadFailed() {

    }

}

