package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseAutoOrder;
import com.bwf.aiyiqi.mvp.model.AutoOrderModel;
import com.bwf.aiyiqi.mvp.model.Impl.AutoOrderModelImpl;
import com.bwf.aiyiqi.mvp.presenter.AutoOrderPresenter;
import com.bwf.aiyiqi.mvp.view.AutoOrderView;

/**
 * Created by lingchen52 on 2016/12/5.
 */

public class AutoOrderPresenterImpl implements AutoOrderPresenter {
    private AutoOrderModel mModel;
    private AutoOrderView mView;

    public AutoOrderPresenterImpl(AutoOrderView view) {
        this.mView = view;
        this.mModel = new AutoOrderModelImpl();
    }

    @Override
    public void loadData() {
        mModel.loadDatas(new AutoOrderModel.Callback() {
            @Override
            public void loadDatasSuccess(ResponseAutoOrder datas) {
                mView.showGridview(datas);
            }

            @Override
            public void loadFailed() {
                mView.showLoadFailed();
            }
        });
    }
}
