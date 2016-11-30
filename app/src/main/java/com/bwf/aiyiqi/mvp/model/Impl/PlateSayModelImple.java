package com.bwf.aiyiqi.mvp.model.Impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.PlateSay;
import com.bwf.aiyiqi.mvp.model.PlateSayModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/30.
 * 功能描述：
 * 作者：
 */

public class PlateSayModelImple implements PlateSayModel {
    @Override
    public void loadPlateSay(String url, String cityName, int cityId, final CallBack callBack) {
        OkHttpUtils.get()
                .url(url)
                .addParams("a","miscForum")
                .addParams("uuid","86305803367590")
                .addParams("cityName",cityName)
                .addParams("m","misc")
                .addParams("haspermission","yes")
                .addParams("cityId",cityId+"")
                .addParams("model","android")
                .addParams("sessionToken","")
                .addParams("app version","android com.aiyiqi.galaxy 1.1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callBack.loadPlateSayFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                       PlateSay plateSay= JSON.parseObject(response, PlateSay.class);
                        if(plateSay.getError().equals("0")){
                          List<List<PlateSay.DataBean>> dataBeen= plateSay.getData();
                            callBack.loadPlateSaySuccess(dataBeen);
                        }
                    }
                });
    }
}
