package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseYiQiGroup;
import com.bwf.aiyiqi.gui.adapter.YiQiGroupGridViewAdapter;
import com.bwf.aiyiqi.mvp.presenter.Impl.YiQiGroupPresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.YiQiGroupPresenter;
import com.bwf.aiyiqi.mvp.view.YiQiGroupView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/11/28.
 */
public class YiQiGroupFragment extends BaseFragment implements YiQiGroupView, AbsListView.OnScrollListener {

    @BindView(R.id.gridview_yiqigroup_activity)
    GridView mGridview;

    public YiQiGroupGridViewAdapter mGridViewAdapter;
    public YiQiGroupPresenter mPresenter;

    public void initDatas(){
        mPresenter = new YiQiGroupPresenterImpl("1701",this);
        loadNextPage();
    }
    public boolean isLoading;
    public void loadNextPage(){
        mPresenter.loadNextPage("1701");
        isLoading = true;
    }
    public void initViews(){

    }
    @Override
    public int getContentViewResId() {
        return R.layout.gridview_yiqigroup;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initDatas();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }



    @Override
    public void showGridView(ResponseYiQiGroup datas) {
        if(mGridViewAdapter == null){
            mGridViewAdapter = new YiQiGroupGridViewAdapter(getContext());
            mGridview.setAdapter(mGridViewAdapter);
        }
        mGridViewAdapter.addDatas(datas.getData());
        mGridview.setOnScrollListener(this);
        isLoading = false;
    }

    @Override
    public void showLoadFailed() {

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if(!isLoading && firstVisibleItem + visibleItemCount == totalItemCount - 1){
            isLoading = true;
            mPresenter.loadNextPage("1701");
        }
    }
}
