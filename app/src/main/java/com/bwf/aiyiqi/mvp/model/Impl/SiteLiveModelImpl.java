package com.bwf.aiyiqi.mvp.model.Impl;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseSiteLiveComments;
import com.bwf.aiyiqi.entity.ResponseSiteLiveData;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.SiteLiveModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/29.
 */

public class SiteLiveModelImpl implements SiteLiveModel {
    private Callback callback;

    @Override
    public void loadData(Map<String, String> mapPro, Map<String, String> mapCom, Callback callback) {
        this.callback = callback;
        loadProgressData(mapPro);
        loadComentsData(mapCom);
    }

    @Override
    public void loadProgressData(Map<String, String> mapPro) {
        OkHttpUtils.post()
                .url(APIs.API_SITELIVE_BASE_INFO)
                .params(mapPro)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.progressDataFail();
            }

            @Override
            public void onResponse(String response, int id) {
                if (TextUtils.isEmpty(response))return;
                ResponseSiteLiveData data = JSON.parseObject(response, ResponseSiteLiveData.class);
                if(data != null){
                    callback.progressDataSuccess(data);
                }
            }
        });
    }

    @Override
    public void loadComentsData(Map<String, String> mapCom) {
        OkHttpUtils.post()
                .url(APIs.API_SITELIVE_COMMENTS)
                .params(mapCom)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.commentsDataFail();
            }

            @Override
            public void onResponse(String response, int id) {
                Log.d("SiteLiveModelImpl", "loadComentsData:"+response);
                if (TextUtils.isEmpty(response))return;
                ResponseSiteLiveComments data = JSON.parseObject(response, ResponseSiteLiveComments.class);
                if(data != null){
                    callback.commentsDataSuccess(data);
                }
            }
        });
    }
}
