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
    public void loadRecenterSay(String url, final CallBack callBack) {
        OkHttpUtils.get()
                .url(url)
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
