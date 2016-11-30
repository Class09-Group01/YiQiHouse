package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.EssenceSay;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.framwork.tool.UrlHandler;
import com.bwf.aiyiqi.mvp.model.EssenceSayModel;
import com.bwf.aiyiqi.mvp.model.Impl.EssenceSayModelImple;
import com.bwf.aiyiqi.mvp.presenter.EssenceSayPresenter;
import com.bwf.aiyiqi.mvp.view.EssenceSayView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class EssenceSayPresenterImple implements EssenceSayPresenter {
    private int page=1;
    private EssenceSayModel mModel;
    private EssenceSayView mView;

    public EssenceSayPresenterImple(EssenceSayView view) {
        mModel=new EssenceSayModelImple();
        mView = view;
    }

    @Override
    public void loadEssenceSayPresenter() {
        String url= UrlHandler.handlUrl(APIs.SAY_ESSENCE_URL,page);
        mModel.loadEssenceSay(url, new EssenceSayModel.CallBack() {
            @Override
            public void loadEssenceSaySuccess(List<EssenceSay.DataBean> dataBeen) {
                mView.showEssenceSayView(dataBeen);
                page++;
            }

            @Override
            public void loadEssenceSayFailed() {
                mView.showViewFialed();
            }
        });

    }
}
