package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseMainFragmentViewPagerDatas;

/**
 * Created by lingchen52 on 2016/11/24.
 */

public interface MainFragmentImageModel {
    void loadDatas(Callback callback);
    public interface Callback{
        void loadDataSuccess(ResponseMainFragmentViewPagerDatas datas);
        void loadDataFailed();
    }
}
