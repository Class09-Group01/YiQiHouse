package com.bwf.aiyiqi.mvp.model.Impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseYiQiGroup;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.YiQiGroupModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lingchen52 on 2016/11/28.
 */

public class YiQiGroupModelImpl implements YiQiGroupModel {
    @Override
    public void loadDatas(String type, int pageNo, final Callback callback) {
        OkHttpUtils.post()
                .url(APIs.API_YIQIGROUP)
                .addParams("token","DAB088BA50C9405E84C789055D657614")
                .addParams("app_version","android_com.aiyiqi.galaxy_1.1")
                .addParams("type",type)
                .addParams("haspermission","yes")
                .addParams("pageNo ",pageNo+"")
                .addParams("pageSize","10")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadDatasFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("YiQiGroupModelImpl", response);
                        ResponseYiQiGroup datas = JSON.parseObject(response, ResponseYiQiGroup.class);
                        if(datas.getBaseOutput().getCode() == 0){
                            callback.loadDatasSuccess(datas);
                        }
                    }
                });
    }
}
