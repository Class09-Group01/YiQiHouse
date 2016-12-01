package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.PlateSay;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.Impl.PlateSayModelImple;
import com.bwf.aiyiqi.mvp.model.PlateSayModel;
import com.bwf.aiyiqi.mvp.presenter.PlateSayPresenter;
import com.bwf.aiyiqi.mvp.view.PlateSayView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 * 功能描述：
 * 作者：
 */

public class PlateSayPresenterImple implements PlateSayPresenter {
    private PlateSayModel mModel;
    private PlateSayView mView;

    public PlateSayPresenterImple(PlateSayView view) {
        mModel=new PlateSayModelImple();
        mView = view;
    }

    @Override
    public void loadPlateSayPresenter(String cityName, int cityId) {
        String url= APIs.SAY_PLATE_URL;
        mModel.loadPlateSay(url, cityName, cityId, new PlateSayModel.CallBack() {
            @Override
            public void loadPlateSaySuccess(List<List<PlateSay.DataBean>> dataBeen) {
                mView.showPlateSayView(dataBeen);
            }

            @Override
            public void loadPlateSayFailed() {
                mView.showViewFialed();
            }
        });

    }
}
