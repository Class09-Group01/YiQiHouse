package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseAutoOrder;

/**
 * Created by lingchen52 on 2016/12/5.
 */

public interface AutoOrderModel {
    void loadDatas(Callback callback);
    public interface Callback{
        void loadDatasSuccess(ResponseAutoOrder datas);
        void loadFailed();
    }
}
