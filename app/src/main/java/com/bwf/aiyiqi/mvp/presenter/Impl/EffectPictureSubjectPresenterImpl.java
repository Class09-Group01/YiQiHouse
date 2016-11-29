package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseEffectPictrueSubjectDatas;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.framwork.tool.UrlHandler;
import com.bwf.aiyiqi.mvp.model.EffectPictureSubjectModel;
import com.bwf.aiyiqi.mvp.model.Impl.EffectPictureSubjectModelImpl;
import com.bwf.aiyiqi.mvp.presenter.EffectPictureSubjectPresenter;
import com.bwf.aiyiqi.mvp.view.EffectPictureSubjectView;

/**
 * Created by Administrator on 2016/11/27.
 */

public class EffectPictureSubjectPresenterImpl implements EffectPictureSubjectPresenter {
    private EffectPictureSubjectModelImpl model;
    private EffectPictureSubjectView view;
    private int page = 1;

    public EffectPictureSubjectPresenterImpl(EffectPictureSubjectView view) {
        this.view = view;
        model = new EffectPictureSubjectModelImpl();
    }

    public void loadReflsuh(){
        page = 1;
        loadEffectPictureSubjectData();
    }


    @Override
    public void loadEffectPictureSubjectData() {
        String url = UrlHandler.handlUrl(APIs.API_EFFECT_PICTURE_SUJECT,page);
        model.loadDatas(url, new EffectPictureSubjectModel.Callback() {
            @Override
            public void loadDataSuccess(ResponseEffectPictrueSubjectDatas datas) {
                view.showEffectPictureSubjectDataSuccess(datas);
                page++;
            }
            @Override
            public void loadDataFailed() {
                view.showEffectPictureSubjectDataFail();
            }
        });
    }
}
