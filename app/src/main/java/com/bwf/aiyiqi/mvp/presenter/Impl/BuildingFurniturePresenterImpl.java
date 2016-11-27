package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResposneBuildingFurnitureData;
import com.bwf.aiyiqi.mvp.model.BuildingFurnitureModel;
import com.bwf.aiyiqi.mvp.model.Impl.BuildingFurnitureModeImpl;
import com.bwf.aiyiqi.mvp.presenter.BuildingFurniturePresenter;
import com.bwf.aiyiqi.mvp.view.BuildingFurnitureView;

/**
 * Created by Administrator on 2016/11/25.
 */

public class BuildingFurniturePresenterImpl implements BuildingFurniturePresenter {
    private BuildingFurnitureModel model;
    private BuildingFurnitureView view;

    public BuildingFurniturePresenterImpl(BuildingFurnitureView view) {
        this.view = view;
        model = new BuildingFurnitureModeImpl();
    }

    @Override
    public void loadResponseBfpData() {
        model.loadDatas(new BuildingFurnitureModel.Callback() {
            @Override
            public void loadDataSuccess(ResposneBuildingFurnitureData data) {
                view.showResposeSuccess(data);
            }

            @Override
            public void loadDataFailed() {
                view.ShowFailed();
            }
        });
    }
}
