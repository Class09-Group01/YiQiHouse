package com.bwf.aiyiqi.mvp.model.Impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseDecorateSchoolNews;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.framwork.tool.UrlHandler;
import com.bwf.aiyiqi.mvp.model.DecorateSchoolModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/24.
 * 功能描述：
 * 作者：
 */

public class DecorateSchoolModelImple implements DecorateSchoolModel {
    @Override
    public void loadTagDatas(int stage, final TagCallBack mCallBack) {
        String url= UrlHandler.handlUrl(APIs.DEOORATESCHOOL_TAGE_URL,stage);
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                mCallBack.loadTagFailed();
            }

            @Override
            public void onResponse(String response, int id) {
                mCallBack.loadTagDatasSuccess(response);
                Log.d("DecorateSchoolModelImpl", response.toString());
            }
        });
    }


    @Override
    public void loadNewsDatas(int stage, int page, int pageSize, final NewsCallBack mCallBack) {
        OkHttpUtils.get().url(APIs.DECORATESCHOOL_NEWS_URL).addParams("version",1+"").addParams("action","getNewsByStage")
                    .addParams("stage",stage+"").addParams("page",page+"").addParams("pagesize",pageSize+"").addParams("model","android")
                    .build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    mCallBack.loadNewsFailed();
                }

                @Override
                public void onResponse(String response, int id) {
                    ResponseDecorateSchoolNews decorateSchoolNews= JSON.parseObject(response, ResponseDecorateSchoolNews.class);
                    if(decorateSchoolNews.getError()==0){
                        mCallBack.loadNewsDatasSuccess(decorateSchoolNews);
                    }
                }
            });
    }
}
