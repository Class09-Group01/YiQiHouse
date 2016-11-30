package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.mvp.model.Impl.RecenterSayModelImple;
import com.bwf.aiyiqi.mvp.model.RecenterSayModel;
import com.bwf.aiyiqi.mvp.presenter.RecenterSayPresenter;
import com.bwf.aiyiqi.mvp.view.RecenterSayView;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class RecenterSayPresenterImple implements RecenterSayPresenter{
    private int page=1;
    private RecenterSayModel mModel;
    private RecenterSayView mView;

    public RecenterSayPresenterImple(RecenterSayView view) {
        mModel=new RecenterSayModelImple();
        mView = view;
    }


    @Override
    public void loadRecenterSayPresenter() {

    }
}
