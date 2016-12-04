package com.bwf.aiyiqi.mvp.model.Impl;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseEffectctBeautyDatas;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.EffectPictureBeautyFragmentModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/4.
 */

public class EffectPictureBeautyFragmentModelImpl implements EffectPictureBeautyFragmentModel {
    @Override
    public void loadDatas(final Callback callback, HashMap<String, String> map) {
        OkHttpUtils.get()
                .url(APIs.API_EFFECT_PICTURE_BEAUTY)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadDataFailed();
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("EffectPictureBeautyFrag", "res:" + response);
                        if (TextUtils.isEmpty(response)) return;
                        ResponseEffectctBeautyDatas datas = JSON.parseObject(response, ResponseEffectctBeautyDatas.class);
                        if (datas != null) {
                            callback.loadDataSuccess(datas);
                        }
                    }
                });

    }
}