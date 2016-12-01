package com.bwf.aiyiqi.mvp.model.Impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseArticleCommunite;
import com.bwf.aiyiqi.entity.ResponseArticleDetail;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.ArticleDetailModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lingchen52 on 2016/12/1.
 */

public class ArticleDetailModelImpl implements ArticleDetailModel {
    @Override
    public void loadArticleDetail(String newsId, final Callback callback) {
        OkHttpUtils.get()
                .url(APIs.API_ARTICLE_DETAIL)
                .addParams("version","1")
                .addParams("newsId",newsId)
                .addParams("page","1")
                .addParams("action","newsDetail")
                .addParams("relatedNum","3")
                .addParams("model","android")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadArticleDetailFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("ArticleDetailModelImpl", response);
                        ResponseArticleDetail articleDetail = JSON.parseObject(response, ResponseArticleDetail.class);
                        if(articleDetail != null){
                            if(articleDetail.getError() == 0){
                                callback.loadArticleDetailSuccess(articleDetail.getData());
                            }
                        }
                    }
                });
    }

    @Override
    public void loadArticleCommunite(String newsId, final Callback callback) {
        OkHttpUtils.get()
                .url(APIs.API_ARTICLE_DETAIL)
                .addParams("version","1")
                .addParams("page","1")
                .addParams("dataId",newsId)
                .addParams("action","commentList")
                .addParams("limit","10")
                .addParams("model","android")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadloadArticleCommuniteFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("ArticleDetailModelImpl", response);
                        ResponseArticleCommunite articleCommunite = JSON.parseObject(response, ResponseArticleCommunite.class);
                        if(articleCommunite != null){
                            if(articleCommunite.getError() != 0){
                                callback.loadArticleCommuniteSuccess(articleCommunite);
                            }
                        }
                    }
                });
    }
}
