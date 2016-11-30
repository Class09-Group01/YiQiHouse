package com.bwf.aiyiqi.mvp.model.Impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.RecenterSay;
import com.bwf.aiyiqi.mvp.model.RecenterSayModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class RecenterSayModelImple implements RecenterSayModel {
    @Override
    public void loadRecenterSay(String url,String cityName,int page, final CallBack callBack) {
        OkHttpUtils.get()
                .url(url)
                .addParams("a","allThread")
                .addParams("c","forumThreadList")
                .addParams("uuid","86305803367590")
                .addParams("pageSize","10")
                .addParams("cityName",cityName)
                .addParams("m","forum")
                .addParams("page",page+"")
                .addParams("haspermission","yes")
                .addParams("model","android")
                .addParams("sessionToken","")
                .addParams("app version","android com.aiyiqi.galaxy 1.1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callBack.loadRecenterSayFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        RecenterSay recenterSay= JSON.parseObject(response, RecenterSay.class);
                        List<RecenterSay.DataBean> dataBeen=recenterSay.getData();
                        callBack.loadRecenterSaySuccess(dataBeen);
                    }
                });
    }
}
