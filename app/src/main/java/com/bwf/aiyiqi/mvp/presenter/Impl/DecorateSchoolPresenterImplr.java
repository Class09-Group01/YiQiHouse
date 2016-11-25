package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseDecorateSchoolNews;
import com.bwf.aiyiqi.mvp.model.DecorateSchoolModel;
import com.bwf.aiyiqi.mvp.model.Impl.DecorateSchoolModelImple;
import com.bwf.aiyiqi.mvp.presenter.DecorateSchoolPresenter;
import com.bwf.aiyiqi.mvp.view.DecorateSchoolView;

/**
 * Created by Administrator on 2016/11/24.
 * 功能描述：
 * 作者：
 */

public class DecorateSchoolPresenterImplr implements DecorateSchoolPresenter {
    private DecorateSchoolModel mModel;
    private DecorateSchoolView mView;
    private int stageTag;
    private int stageNews;
    private int page=1;
    private int pageSize=10;

    public DecorateSchoolPresenterImplr(DecorateSchoolView view) {
        mModel=new DecorateSchoolModelImple();
        mView = view;
    }


    @Override
    public void loadDecorateSchoolTagPresenter(int stage) {
        this.stageTag=stage;
        mModel.loadTagDatas(stageTag, new DecorateSchoolModel.TagCallBack() {
            @Override
            public void loadTagDatasSuccess(String str) {
                mView.showDecorateSchoolTagView(str);
            }

            @Override
            public void loadTagFailed() {
                mView.showDataFailed();
            }
        });

    }

    @Override
    public void loadDecorateSchoolNewsPresenter(int stage) {
        this.stageNews=stage;
        mModel.loadNewsDatas(stageNews, page, pageSize, new DecorateSchoolModel.NewsCallBack() {
            @Override
            public void loadNewsDatasSuccess(ResponseDecorateSchoolNews decorateSchoolNews) {
                mView.showDecorateSchoolNewsView(decorateSchoolNews);
                page++;
            }

            @Override
            public void loadNewsFailed() {
                mView.showDataFailed();
            }
        });
    }
}
