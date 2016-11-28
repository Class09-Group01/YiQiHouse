package com.bwf.aiyiqi.mvp.model.Impl;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseEffectPictrueSubjectDatas;
import com.bwf.aiyiqi.mvp.model.EffectPictureSubjectModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/27.
 */

public class EffectPictureSubjectModelImpl implements EffectPictureSubjectModel {
    @Override
    public void loadDatas(String url,final Callback callback) {
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadDataFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if(TextUtils.isEmpty(response))return;
                        ResponseEffectPictrueSubjectDatas datas = JSON.parseObject(response,ResponseEffectPictrueSubjectDatas.class);
                        if(datas != null){
                            callback.loadDataSuccess(datas);
                        }
                    }
                });
    }
}
