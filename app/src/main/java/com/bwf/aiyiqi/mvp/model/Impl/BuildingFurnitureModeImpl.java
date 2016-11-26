package com.bwf.aiyiqi.mvp.model.Impl;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResposneBuildingFurnitureData;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.BuildingFurnitureModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/25.
 */

public class BuildingFurnitureModeImpl implements BuildingFurnitureModel {
    @Override
    public void loadDatas(final Callback callback) {
        OkHttpUtils.post()
                .url(APIs.API_BUILDING_FURNITURE)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadDataFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if(TextUtils.isEmpty(response))return;
                        ResposneBuildingFurnitureData data = JSON.parseObject
                                (response,ResposneBuildingFurnitureData.class);
                        if(data != null){
                            callback.loadDataSuccess(data);
                        }
                    }
                });
    }
}
