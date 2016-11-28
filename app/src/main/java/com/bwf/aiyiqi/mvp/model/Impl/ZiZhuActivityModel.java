package com.bwf.aiyiqi.mvp.model.Impl;

import com.bwf.aiyiqi.entity.ResponseZiZhuDatas;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface ZiZhuActivityModel {
    void loadDatas();
    public interface CallBack{
        void loadDataSuccess(ResponseZiZhuDatas datas);
        void loadDataFeil();
    }
}
