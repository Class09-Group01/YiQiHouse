package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseYiQiGroup;

/**
 * Created by lingchen52 on 2016/11/28.
 */

public interface YiQiGroupModel {
    void loadDatas(String type,int pageNo,Callback callback);
    public interface Callback{
        void loadDatasSuccess(ResponseYiQiGroup datas);
        void loadDatasFailed();
    }
}
