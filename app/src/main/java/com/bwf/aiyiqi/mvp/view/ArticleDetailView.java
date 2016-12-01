package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseArticleCommunite;
import com.bwf.aiyiqi.entity.ResponseArticleDetail;

import java.util.List;

/**
 * Created by lingchen52 on 2016/12/1.
 */

public interface ArticleDetailView {
    void showArticleDetail(ResponseArticleDetail.DataBean dataBean);
    void showRelatedArticle(List<ResponseArticleDetail.DataBean.RelatedNewsBean> relatedNewsBean);
    void showArticleCommunite(ResponseArticleCommunite dataBean);
    void showArticleDetailFailed();
    void showRelatedArticleFailed();
    void showArticleCommuniteFailed();
}
