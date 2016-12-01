package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseArticleDetail;
import com.bwf.aiyiqi.entity.ResponsePostCommunite;

/**
 * Created by lingchen52 on 2016/12/1.
 */

public interface ArticleDetailModel {
    void loadArticleDetail(String newsId,Callback callback);
    void loadArticleCommunite(String newsId,Callback callback);
    public interface Callback{
        void loadArticleDetailSuccess(ResponseArticleDetail.DataBean articleDetail);
        void loadArticleCommuniteSuccess(ResponsePostCommunite dataBean);
        void loadArticleDetailFailed();
        void loadloadArticleCommuniteFailed();
    }
}
