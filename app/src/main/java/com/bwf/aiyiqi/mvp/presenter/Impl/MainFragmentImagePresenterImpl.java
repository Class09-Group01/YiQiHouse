package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseMainFragmentViewPagerDatas;
import com.bwf.aiyiqi.mvp.model.Impl.MainFragmentImageModelImpl;
import com.bwf.aiyiqi.mvp.model.MainFragmentImageModel;
import com.bwf.aiyiqi.mvp.presenter.MainFragmentImagePresenter;
import com.bwf.aiyiqi.mvp.view.MainFragmentImage;

/**
 * Created by lingchen52 on 2016/11/24.
 */

public class MainFragmentImagePresenterImpl implements MainFragmentImagePresenter {
    private MainFragmentImageModel mModel;
    private MainFragmentImage view;

    public MainFragmentImagePresenterImpl(MainFragmentImage view) {
        this.view = view;
        this.mModel = new MainFragmentImageModelImpl();
    }

    @Override
    public void load() {
        mModel.loadDatas(new MainFragmentImageModel.Callback() {
            @Override
            public void loadDataSuccess(ResponseMainFragmentViewPagerDatas datas) {
                view.showMainFragmentViewPagerImage(datas);
            }

            @Override
            public void loadDataFailed() {

            }
        });
    }
}
