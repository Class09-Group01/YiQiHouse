package com.bwf.aiyiqi.mvp.model.Impl;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseSearchDatas;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.SearchActivityModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/28.
 */

public class SearchActivityModelIml implements SearchActivityModel {

    @Override
    public void loadData(Map<String, String> map, final Callback callback) {
        //写网络加载模块
        OkHttpUtils.get()
                .url(APIs.API_SEARCH)
                .params(map)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadFail();
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("SearchActivityModelIml", response);
                        if(TextUtils.isEmpty(response))return;
                        ResponseSearchDatas datas = JSON.parseObject(response,ResponseSearchDatas.class);
                        if(datas != null){
                            if(TextUtils.isEmpty(datas.getMessage())){
                                callback.loadNoMoreData();
                                return;
                            }
                            callback.loadDataSuccess(datas);
                        }
                    }
                });
    }
}
