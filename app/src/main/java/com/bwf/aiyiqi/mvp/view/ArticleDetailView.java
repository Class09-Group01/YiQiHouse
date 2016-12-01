package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseArticleDetail;

/**
 * Created by lingchen52 on 2016/12/1.
 */

public interface ArticleDetailView {
    void showArticleDetail(ResponseArticleDetail.DataBean dataBean);
    void showRelatedArticle(ResponseArticleDetail.DataBean.RelatedNewsBean relatedNewsBean);
    void showArticleCommunite();
    void showArticleDetailFailed();
    void showRelatedArticleFailed();
    void showArticleCommuniteFailed();
}
