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
import com.bwf.aiyiqi.entity.EssenceSay;
import com.bwf.aiyiqi.gui.adapter.EssenceFragmentAdapter;
import com.bwf.aiyiqi.gui.view.CustomRefreshLayout;
import com.bwf.aiyiqi.mvp.presenter.EssenceSayPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.EssenceSayPresenterImple;
import com.bwf.aiyiqi.mvp.view.EssenceSayView;
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

public class EssenceFragment extends BaseFragment implements EssenceSayView {
    @BindView(R.id.essence_fragmenat_recycleview)
    RecyclerView mEssenceFragmenatRecycleview;
    @BindView(R.id.essence_fragmenat_refresh)
    CustomRefreshLayout mEssenceFragmenatRefresh;
    private LinearLayoutManager mLayoutManager;
    private EssenceFragmentAdapter mAdapter;
    private EssenceSayPresenter mPresenter;
    private boolean isNoMoreData;
    private boolean isLoading;
    //RecyclerView 滑动的时候当显示到为当前页的某一Item时自动加载下一页
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (isNoMoreData) {
                return;
            }
            if (!isLoading && mLayoutManager.findLastVisibleItemPosition() == mLayoutManager.getItemCount() - 1) {
                loadNextData();
            }
            if (mLayoutManager.findFirstVisibleItemPosition() == 0) {
                mEssenceFragmenatRefresh.setCanPull(true);
            } else {
                mEssenceFragmenatRefresh.setCanPull(false);//设置后不拦截recycleview的滑动
            }
        }
    };

    @Override
    protected int getContentViewResId() {
        return R.layout.essencefragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mEssenceFragmenatRecycleview.addOnScrollListener(mOnScrollListener);
        init();
        loadNextData();
    }

    public void init() {
        mPresenter = new EssenceSayPresenterImple(this);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mEssenceFragmenatRecycleview.setLayoutManager(mLayoutManager);
        mAdapter = new EssenceFragmentAdapter(getActivity());
        mEssenceFragmenatRecycleview.setAdapter(mAdapter);
        mEssenceFragmenatRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loadNextData();
            }
        });
    }

    private void loadNextData() {
        mPresenter.loadEssenceSayPresenter();
        isLoading = true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showEssenceSayView(List<EssenceSay.DataBean> dataBeen) {
        mEssenceFragmenatRefresh.finishRefresh();
        if (dataBeen.size() == 0) {
            isNoMoreData = true;
            return;
        }
        Toast.makeText(getActivity(), dataBeen.get(0).getSubject(), Toast.LENGTH_SHORT).show();
        mAdapter.addData(dataBeen);
        isLoading = false;

    }

    @Override
    public void showViewFialed() {

    }

}
