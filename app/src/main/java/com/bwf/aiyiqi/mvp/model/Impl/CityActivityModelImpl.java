package com.bwf.aiyiqi.mvp.model.Impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseCityActiveDatas;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.CityActivityModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public class CityActivityModelImpl implements CityActivityModel {
    @Override
    public void loadDatas(final Callback callback) {
        OkHttpUtils.get()
                .url(APIs.API_CITY_ACTIVE)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadDatasFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("CityActivityModelImpl", response);
                        ResponseCityActiveDatas activeDatas = JSON.parseObject(response, ResponseCityActiveDatas.class);
                        if(activeDatas.getError().equals("0")){
                            callback.loadDatasSuccess(activeDatas);
                        }

                    }
                });
    }
}
