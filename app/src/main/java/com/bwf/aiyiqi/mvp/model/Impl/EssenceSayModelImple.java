package com.bwf.aiyiqi.mvp.model.Impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.EssenceSay;
import com.bwf.aiyiqi.mvp.model.EssenceSayModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class EssenceSayModelImple implements EssenceSayModel{
    @Override
    public void loadEssenceSay(String url, final CallBack callBack) {
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callBack.loadEssenceSayFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        EssenceSay essenceSay= JSON.parseObject(response, EssenceSay.class);
                        List<EssenceSay.DataBean> dataBeen=essenceSay.getData();
                        callBack.loadEssenceSaySuccess(dataBeen);
                    }
                });
    }
}
