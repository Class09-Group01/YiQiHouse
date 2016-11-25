package com.bwf.aiyiqi.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.ScanActivity;
import com.bwf.aiyiqi.gui.activity.SearchActivity;
import com.bwf.aiyiqi.mvp.presenter.MainFragmentImagePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import com.bwf.aiyiqi.gui.adapter.MainFragmentPagerAdapter;


/**
 * Created by Administrator on 2016/11/23.
 */

public class HomeFragment extends BaseFragment{
    @BindView(R.id.fragment_home_title_bar_scan)
    ImageView fragmentHomeTitleBarScan;
    @BindView(R.id.fragment_home_title_bar_search)
    RelativeLayout fragmentHomeTitleBarSearch;
    @BindView(R.id.fragment_home_title_bar_city)
    LinearLayout fragmentHomeTitleBarCity;

    private MainFragmentImagePresenter mFragmentImagePresenter;
//    private MainFragmentPagerAdapter mPagerAdapter;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
}
