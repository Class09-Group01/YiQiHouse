package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.view.CustomRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class RecentFragment extends BaseFragment {
    @BindView(R.id.essence_fragmenat_recycleview)
    RecyclerView mEssenceFragmenatRecycleview;
    @BindView(R.id.essence_fragmenat_refresh)
    CustomRefreshLayout mEssenceFragmenatRefresh;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected int getContentViewResId() {
        return R.layout.essencefragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        loadData();
    }

    public void init() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mEssenceFragmenatRecycleview.setLayoutManager(mLayoutManager);
    }

    public void loadData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
