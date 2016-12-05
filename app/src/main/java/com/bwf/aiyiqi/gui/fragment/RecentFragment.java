package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.RecenterSay;
import com.bwf.aiyiqi.gui.adapter.RecenterFragmentAdapter;
import com.bwf.aiyiqi.gui.view.CustomRefreshLayout;
import com.bwf.aiyiqi.mvp.presenter.Impl.RecenterSayPresenterImple;
import com.bwf.aiyiqi.mvp.presenter.RecenterSayPresenter;
import com.bwf.aiyiqi.mvp.view.RecenterSayView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class RecentFragment extends BaseFragment implements RecenterSayView{
    @BindView(R.id.essence_fragmenat_recycleview)
    RecyclerView mEssenceFragmenatRecycleview;
    @BindView(R.id.essence_fragmenat_refresh)
    CustomRefreshLayout mEssenceFragmenatRefresh;
    private LinearLayoutManager mLayoutManager;
    private RecenterSayPresenter mPresenter;
    private String cityName = "成都";
    private String lastCityName;
    private RecenterFragmentAdapter mRecenterFragmentAdapter;

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
        mEssenceFragmenatRecycleview.addOnScrollListener(onScrollListener);

        mRecenterFragmentAdapter = new RecenterFragmentAdapter(getActivity());
        mEssenceFragmenatRecycleview.setAdapter(mRecenterFragmentAdapter);
        mEssenceFragmenatRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loadData();
            }
        });
        mPresenter = new RecenterSayPresenterImple(this);

    }

    public void loadData() {
        mPresenter.loadRecenterSayPresenter(cityName, lastCityName);
        isLoading = true;
    }

    private boolean isLoading;
    private boolean isNomoreData;

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (isNomoreData) {
                return;
            }
            if (!isLoading && mLayoutManager.findLastVisibleItemPosition() == mLayoutManager.getItemCount() - 2) {
                loadData();
            }
            if (mLayoutManager.findFirstVisibleItemPosition() == 0) {
                mEssenceFragmenatRefresh.setCanPull(true);
            } else {
                mEssenceFragmenatRefresh.setCanPull(false);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showRecenterSayView(List<RecenterSay.DataBean> dataBeen) {
        mEssenceFragmenatRefresh.finishRefresh();
        if (dataBeen.size() == 0) {
            Toast.makeText(getActivity(), "没有更多的数据了", Toast.LENGTH_SHORT).show();
            isNomoreData = true;
            return;
        }
        cityName = lastCityName;
        Toast.makeText(getActivity(), dataBeen.get(0).getAuthor(), Toast.LENGTH_SHORT).show();
        mRecenterFragmentAdapter.addData(dataBeen);
        isLoading = false;

    }

    @Override
    public void showViewFialed() {

    }
}
