package com.bwf.aiyiqi.mvp.model.Impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseAutoOrder;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.AutoOrderModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lingchen52 on 2016/12/5.
 */

public class AutoOrderModelImpl implements AutoOrderModel {
    @Override
    public void loadDatas(final Callback callback) {
        String str = "version=1" +
                "&action=getSingleSupplementInfo" +
                "&cityId=2" +
                "&model=android" +
                "&app_version=android_com.aiyiqi.galaxy_1.1";
        OkHttpUtils.get()
                .addParams("version","1")
                .addParams("action","getSingleSupplementInfo")
                .addParams("cityId","2")
                .addParams("model","android")
                .addParams("app_version","android_com.aiyiqi.galaxy_1.1")
                .url(APIs.API_AUTO_ORDER)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("AutoOrderModelImpl", response);
                        ResponseAutoOrder datas = JSON.parseObject(response, ResponseAutoOrder.class);
                        if(datas != null){
                            if(datas.getError() == 0){
                                callback.loadDatasSuccess(datas);
                            }
                        }
                    }
                });
    }
}
