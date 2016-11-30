package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseYiQiGroup;
import com.bwf.aiyiqi.mvp.model.Impl.YiQiGroupModelImpl;
import com.bwf.aiyiqi.mvp.model.YiQiGroupModel;
import com.bwf.aiyiqi.mvp.presenter.YiQiGroupPresenter;
import com.bwf.aiyiqi.mvp.view.YiQiGroupView;

/**
 * Created by lingchen52 on 2016/11/28.
 */

public class YiQiGroupPresenterImpl implements YiQiGroupPresenter {
    private YiQiGroupView mYiQiGroupView;
    private YiQiGroupModel mYiQiGroupModel;
    private String currentType;
    private String lastType;
    private int nextPage;

    public YiQiGroupPresenterImpl(String currentType, YiQiGroupView yiQiGroupView) {
        this.currentType = currentType;
        this.mYiQiGroupView = yiQiGroupView;
        this.mYiQiGroupModel = new YiQiGroupModelImpl();
    }


    @Override
    public void loadNextPage(String type) {
        if(type != currentType && nextPage != 0){
            nextPage = 0;
//            lastType = type;
        }
        mYiQiGroupModel.loadDatas(type, nextPage, new YiQiGroupModel.Callback() {
            @Override
            public void loadDatasSuccess(ResponseYiQiGroup datas) {
                mYiQiGroupView.showGridView(datas);
                nextPage++;
            }

            @Override
            public void loadDatasFailed() {
                mYiQiGroupView.showLoadFailed();
            }
        });
    }
}
