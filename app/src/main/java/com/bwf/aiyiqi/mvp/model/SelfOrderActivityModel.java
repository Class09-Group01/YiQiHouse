package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseSelfOrderDatas;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface SelfOrderActivityModel {
    void loadDatas(HashMap<String,String> map,CallBack callBack);
    public interface CallBack{
        void loadDataSuccess(ResponseSelfOrderDatas datas);
        void loadDataFeil();
    }
}
