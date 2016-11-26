package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResposneBuildingFurnitureData;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface BuildingFurnitureView {

    void showResposeSuccess(ResposneBuildingFurnitureData data);
    void ShowFailed();
    void SHowNoMoreData();


}
