package com.bwf.aiyiqi.mvp.model.Impl;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseSelfOrderDatas;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.SelfOrderActivityModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/28.
 */

public class SelfOrderActivityModelImpl implements SelfOrderActivityModel {

    @Override
    public void loadDatas(HashMap<String,String> map,final CallBack callBack) {
        OkHttpUtils.get()
                .url(APIs.API_SELF_ORDER_ACTIVTY)
//              .params(map)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callBack.loadDataFeil();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("SelfOrderActivityModelI", response);
                        if(!TextUtils.isEmpty(response)){
                            ResponseSelfOrderDatas datas =
                                    JSON.parseObject(response,ResponseSelfOrderDatas.class);
                            if (datas != null){
                                callBack.loadDataSuccess(datas);
                            }
                            Log.d("SelfOrderActivityModelI", datas.getData().get(0).getName());
                        }
                    }
                });
    }
}
