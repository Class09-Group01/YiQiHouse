package com.bwf.aiyiqi.mvp.model.Impl;

import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.MainFragmentImageModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lingchen52 on 2016/11/24.
 */

public class MainFragmentImageModelImpl implements MainFragmentImageModel {
    @Override
    public void loadDatas(Callback callback) {
        OkHttpUtils.get()
                .url(APIs.API_MAIN_FRAGMENT_VIEWPAGER)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Log.e("MainFragmentImageModelImpl","response"+response);
                    }
                });
    }
}