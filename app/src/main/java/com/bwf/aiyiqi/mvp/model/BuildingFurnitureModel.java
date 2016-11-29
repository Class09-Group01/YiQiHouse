package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResposneBuildingFurnitureData;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface BuildingFurnitureModel {
    void loadDatas(Callback callback);
    public interface Callback{
        void loadDataSuccess(ResposneBuildingFurnitureData data);
        void loadDataFailed();
    }
}
