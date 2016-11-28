package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseEffectPictrueSubjectDatas;
import com.bwf.aiyiqi.gui.adapter.FragmentEffectPictureSubjectAdapter;
import com.bwf.aiyiqi.mvp.presenter.EffectPictureSubjectPresenterImpl;
import com.bwf.aiyiqi.mvp.view.EffectPictureSubjectView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class EffectPictureSubjectFragment extends BaseFragment implements EffectPictureSubjectView {
    @BindView(R.id.feps_listview)
    ListView fepsListview;
    @BindView(R.id.reflush)
    MaterialRefreshLayout reflush;
    private EffectPictureSubjectPresenterImpl mPresenter;
    private FragmentEffectPictureSubjectAdapter mAdapter;
    private boolean isLoading =true;
    private boolean noMoreData;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_effect_picture_subject;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = new EffectPictureSubjectPresenterImpl(this);
        mPresenter.loadEffectPictureSubjectData();
        mAdapter = new FragmentEffectPictureSubjectAdapter
                (getActivity(), R.layout.fragment_effect_picture_subject_item);
        fepsListview.setAdapter(mAdapter);
        //下拉刷新
        reflush.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                mPresenter.loadReflsuh();
                noMoreData = false;
            }
        });
        //上拉加载下一页
        fepsListview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(totalItemCount - 2 <= firstVisibleItem + visibleItemCount){
                    if(noMoreData)return;
                    if(!isLoading){
                        mPresenter.loadEffectPictureSubjectData();
                        isLoading = true;
                    }
                }
            }
        });

    }

    @Override
    public void showEffectPictureSubjectDataSuccess(ResponseEffectPictrueSubjectDatas datas) {
        mAdapter.addData(datas.getData().getList());
        reflush.finishRefresh();
        isLoading = false;
    }

    @Override
    public void showEffectPictureSubjectDataFail() {
        Toast.makeText(getActivity(), "fail:", Toast.LENGTH_SHORT).show();
        reflush.finishRefresh();
        isLoading = false;

    }

    @Override
    public void showNoMoreData() {
        reflush.finishRefresh();
        noMoreData = true;
        isLoading = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
