package com.bwf.aiyiqi.mvp.model.Impl;

<<<<<<< HEAD
=======
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseMainFragmentViewPagerDatas;
>>>>>>> 5bb382542208c8440309983cf76d3869d35e0a11
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.MainFragmentImageModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * 首页viewpager数据
 * Created by lingchen52 on 2016/11/24.
 */

public class MainFragmentImageModelImpl implements MainFragmentImageModel {
    @Override
    public void loadDatas(final Callback callback) {
        OkHttpUtils.get()
                .url(APIs.API_MAIN_FRAGMENT_VIEWPAGER)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadDataFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("MainFragmentModelImpl","response"+response);
                        ResponseMainFragmentViewPagerDatas datas = JSON.parseObject(response, ResponseMainFragmentViewPagerDatas.class);
                        if(datas.getError() == 0){
                            //请求成功
                            callback.loadDataSuccess(datas);
                        }
                    }
                });
    }
}
