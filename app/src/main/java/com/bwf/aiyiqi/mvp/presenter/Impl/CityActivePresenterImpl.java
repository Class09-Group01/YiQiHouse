package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseCityActiveDatas;
import com.bwf.aiyiqi.mvp.model.CityActivityModel;
import com.bwf.aiyiqi.mvp.model.Impl.CityActivityModelImpl;
import com.bwf.aiyiqi.mvp.presenter.CityActivePresenter;
import com.bwf.aiyiqi.mvp.view.CityActiveView;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public class CityActivePresenterImpl implements CityActivePresenter {
    private CityActiveView mActiveView;
    private CityActivityModel mActivityModel;

    public CityActivePresenterImpl(CityActiveView activeView) {
        this.mActiveView = activeView;
        this.mActivityModel = new CityActivityModelImpl();
    }

    @Override
    public void load() {
        mActivityModel.loadDatas(new CityActivityModel.Callback() {
            @Override
            public void loadDatasSuccess(ResponseCityActiveDatas datas) {
                mActiveView.showListView(datas);
            }

            @Override
            public void loadDatasFailed() {
                mActiveView.showLoadFailed();
            }
        });
    }
}
