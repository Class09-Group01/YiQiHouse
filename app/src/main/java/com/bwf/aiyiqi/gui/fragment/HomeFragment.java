package com.bwf.aiyiqi.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainFragmentViewPagerDatas;
import com.bwf.aiyiqi.gui.activity.ScanActivity;
import com.bwf.aiyiqi.gui.activity.SearchActivity;
import com.bwf.aiyiqi.gui.adapter.MainFragmentPagerAdapter;
import com.bwf.aiyiqi.mvp.presenter.Impl.MainFragmentImagePresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.MainFragmentImagePresenter;
import com.bwf.aiyiqi.mvp.view.MainFragmentImage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/23.
 */

public class HomeFragment extends BaseFragment implements MainFragmentImage {
    @BindView(R.id.fragment_home_title_bar_scan)
    ImageView fragmentHomeTitleBarScan;
    @BindView(R.id.fragment_home_title_bar_search)
    RelativeLayout fragmentHomeTitleBarSearch;
    @BindView(R.id.fragment_home_title_bar_city)
    LinearLayout fragmentHomeTitleBarCity;
    @BindView(R.id.viewpager_fragment_main)
    ViewPager mViewpagerFragmentMain;
    @BindView(R.id.ll_indicator_fragment_main)
    LinearLayout mLlIndicatorFragmentMain;

    private MainFragmentImagePresenter mFragmentImagePresenter;
    private MainFragmentPagerAdapter mPagerAdapter;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentImagePresenter = new MainFragmentImagePresenterImpl(this);
        mFragmentImagePresenter.load();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.fragment_home_title_bar_scan, R.id.fragment_home_title_bar_search, R.id.fragment_home_title_bar_city})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_title_bar_scan:
                startActivity(new Intent(getActivity(), ScanActivity.class));
                break;
            case R.id.fragment_home_title_bar_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.fragment_home_title_bar_city:
                break;
        }
    }
    private ImageView[] mButtonImages;
    @Override
    public void showMainFragmentViewPagerImage(ResponseMainFragmentViewPagerDatas datas) {
        mPagerAdapter = new MainFragmentPagerAdapter(getContext(), datas.getData());
        mViewpagerFragmentMain.setAdapter(mPagerAdapter);
        mButtonImages = new ImageView[datas.getData().size()];
        for (int i = 0; i < mButtonImages.length; i++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10,10);
            params.setMargins(5,0,5,0);
            imageView.setLayoutParams(params);
            if(i == 0){
                imageView.setBackgroundResource(R.mipmap.jshop_banner_point_active);
            }else{
                imageView.setBackgroundResource(R.mipmap.jshop_banner_point_inactive);
            }
            mButtonImages[i] = imageView;
            mLlIndicatorFragmentMain.addView(mButtonImages[i]);
        }

    }

    @Override
    public void showLoadFailed() {

    }
}
