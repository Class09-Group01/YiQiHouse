package com.bwf.aiyiqi.mvp.model.Impl;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseMainFragmentRecycleviewData;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.MainFragmentRecycleModelImpl;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainFragmentRecycleModel implements MainFragmentRecycleModelImpl{
    @Override
    public void loadDatas(final Callback callback, HashMap<String,String> map) {

        OkHttpUtils.post()
                .url(APIs.API_SEARCH)
                .params(map)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadDataFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if(!TextUtils.isEmpty(response)){
                            ResponseMainFragmentRecycleviewData data = JSON.parseObject(response,
                                    ResponseMainFragmentRecycleviewData.class);
                            callback.loadDataSuccess(data);
                        }
                    }
                });


    }
}
