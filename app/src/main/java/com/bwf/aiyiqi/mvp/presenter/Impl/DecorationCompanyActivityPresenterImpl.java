package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityListView;
import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityViewPager;
import com.bwf.aiyiqi.mvp.model.DecorationCompanyActivityModel;
import com.bwf.aiyiqi.mvp.model.Impl.DecorationCompanyActivityModelImpl;
import com.bwf.aiyiqi.mvp.presenter.DecorationCompanyActivityPresenter;
import com.bwf.aiyiqi.mvp.view.DecorationCompanyView;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public class DecorationCompanyActivityPresenterImpl implements DecorationCompanyActivityPresenter {
    private DecorationCompanyView mView;
    private DecorationCompanyActivityModel mModel;

    public DecorationCompanyActivityPresenterImpl(DecorationCompanyView view) {
        this.mView = view;
        this.mModel = new DecorationCompanyActivityModelImpl();
    }

    @Override
    public void load() {
        mModel.loadDatas(new DecorationCompanyActivityModel.Callback() {
            @Override
            public void loadViewPagerDatasSuccess(ResponseDecorationCompanyActivityViewPager datas) {
                mView.showViewPager(datas);
            }

            @Override
            public void loadListViewDatasSuccess(ResponseDecorationCompanyActivityListView datas) {
                mView.showListView(datas);
            }

            @Override
            public void loadViewPagerDatasFailed() {
                mView.showViewPagerFailed();
            }

            @Override
            public void loadListViewDatasFailed() {
                mView.showListViewFailed();
            }
        });
    }
}
