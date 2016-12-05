package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.RecenterSay;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.Impl.RecenterSayModelImple;
import com.bwf.aiyiqi.mvp.model.RecenterSayModel;
import com.bwf.aiyiqi.mvp.presenter.RecenterSayPresenter;
import com.bwf.aiyiqi.mvp.view.RecenterSayView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class RecenterSayPresenterImple implements RecenterSayPresenter{
    private int page;
    private RecenterSayModel mModel;
    private RecenterSayView mView;

    public RecenterSayPresenterImple(RecenterSayView view) {
        mModel=new RecenterSayModelImple();
        mView = view;
    }


    @Override
    public void loadRecenterSayPresenter(String cityName,String lastCityName) {
        if(cityName==lastCityName){
            page++;
        }else {
            page=1;
        }
        String url= APIs.SAY_RECENTER_URL;
        mModel.loadRecenterSay(url,cityName,page, new RecenterSayModel.CallBack() {
            @Override
            public void loadRecenterSaySuccess(List<RecenterSay.DataBean> dataBeen) {
                mView.showRecenterSayView(dataBeen);

            }

            @Override
            public void loadRecenterSayFailed() {
                mView.showViewFialed();
            }
        });

    }
}
