package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseSearchDatas;

import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface SearchActivityModel {
    void loadData(Map<String,String> map, Callback callback);
    public interface Callback{
        void loadDataSuccess(ResponseSearchDatas datas);
        void loadFail();
        void loadNoMoreData();
    }

}
