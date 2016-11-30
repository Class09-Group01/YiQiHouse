package com.bwf.aiyiqi.mvp.model.Impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponsePostCommunite;
import com.bwf.aiyiqi.entity.ResponsePostDetail;
import com.bwf.aiyiqi.entity.ResponsePostZan;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.PostDetailModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lingchen52 on 2016/11/30.
 */

public class PostDetailModelImpl implements PostDetailModel {
    @Override
    public void loadPostDetailDatas(String tid, final Callback callback) {
        OkHttpUtils.get()
                .url(APIs.API_POSTDETAIL)
                .addParams("a","viewThread")
                .addParams("c","forumThread")
                .addParams("imgwidth","330")
                .addParams("uuid","86305803367590")
                .addParams("tid",tid)
                .addParams("m","forum")
                .addParams("haspermission","yes")
                .addParams("model","android")
                .addParams("app_version","android_com.aiyiqi.galaxy_1.1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadPostDetailDatasFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("PostDetailModelImpl", "loadPostDetailDatas:"+response);
                        ResponsePostDetail postDetail = JSON.parseObject(response, ResponsePostDetail.class);
                        if(postDetail.getError().equals("0")){
                            callback.loadPostDetailDatasSuccess(postDetail);
                        }
                    }
                });

    }

    @Override
    public void loadPostZanDatas(String tid, final Callback callback) {
        OkHttpUtils.get()
                .url(APIs.API_POSTDETAIL)
                .addParams("a","threadZan")
                .addParams("c","forumThread")
                .addParams("uuid","86305803367590")
                .addParams("tid",tid)
                .addParams("uid","1633055")
                .addParams("m","forum")
                .addParams("haspermission","yes")
                .addParams("model","android")
                .addParams("sessionToken","6U49kCYKE260RqvPqEdFsBGskNQStKhm")
                .addParams("app_version","android_com.aiyiqi.galaxy_1.1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadPostZanDatasFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("PostDetailModelImpl", "loadPostZanDatas:"+response);
                        ResponsePostZan postZan = JSON.parseObject(response, ResponsePostZan.class);
                        if (postZan.getError().equals("0")){
                            callback.loadPostZanDatasSuccess(postZan);
                        }
                    }
                });
    }

    @Override
    public void loadPostCommuniteDatas(String tid, int page, final Callback callback) {
        OkHttpUtils.get()
                .url(APIs.API_POSTDETAIL)
                .addParams("a","viewThread")
                .addParams("c","forumThread")
                .addParams("imgwidth","270")
                .addParams("uuid","86305803367590")
                .addParams("pageSize","10")
                .addParams("tid",tid)
                .addParams("uid","1633055")
                .addParams("m","forum")
                .addParams("type","post")
                .addParams("page",page+"")
                .addParams("haspermission","yes")
                .addParams("model","android")
                .addParams("sessionToken","6U49kCYKE260RqvPqEdFsBGskNQStKhm")
                .addParams("app_version","android_com.aiyiqi.galaxy_1.1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadPostCommuniteDatasFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("PostDetailModelImpl","loadPostCommuniteDatas:"+ response);
                        ResponsePostCommunite postCommunite = JSON.parseObject(response, ResponsePostCommunite.class);
                        if(postCommunite.getError().equals("0")){
                            callback.loadPostCommuniteDatasSuccess(postCommunite);
                        }
                    }
                });
    }
}
