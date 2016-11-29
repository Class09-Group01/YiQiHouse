package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseCityActiveDatas;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public interface CityActiveView {
    void showListView(ResponseCityActiveDatas datas);
    void showLoadFailed();
}
