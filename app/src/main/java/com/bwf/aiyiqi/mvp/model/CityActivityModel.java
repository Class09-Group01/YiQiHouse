package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseCityActiveDatas;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public interface CityActivityModel {
    void loadDatas(Callback callback);
    public interface Callback{
        void loadDatasSuccess(ResponseCityActiveDatas datas);
        void loadDatasFailed();
    }
}
