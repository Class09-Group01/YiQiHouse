package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseSelfOrderDatas;
import com.bwf.aiyiqi.mvp.model.Impl.SelfOrderActivityModelImpl;
import com.bwf.aiyiqi.mvp.model.SelfOrderActivityModel;
import com.bwf.aiyiqi.mvp.presenter.SelfOrderActivityPresenter;
import com.bwf.aiyiqi.mvp.view.SelfOrderActivityView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */

public class SelfOrderActivityPresenterImpl implements SelfOrderActivityPresenter {

    private SelfOrderActivityModelImpl model;
    private SelfOrderActivityView view;
    private Map<String,String> map;

    public SelfOrderActivityPresenterImpl(SelfOrderActivityView view) {
        this.view = view;
        model = new SelfOrderActivityModelImpl();
        map = new HashMap<>();
    }
    private void setaMap(){
        map.clear();
        map.put("version","1");
        map.put("action","getSingleSupplementInfo");
        map.put("cityId","2");
        map.put("model","android");
        map.put("app_version","android_com.aiyiqi.galaxy_1.1");
    }

    @Override
    public void loadSelfOrderDatas() {
        setaMap();
        model.loadDatas((HashMap<String, String>) map, new SelfOrderActivityModel.CallBack() {
            @Override
            public void loadDataSuccess(ResponseSelfOrderDatas datas) {
                view.loadDatasSuccess(datas);
            }

            @Override
            public void loadDataFeil() {
                view.loadDatasFeil();
            }
        });
    }
}
