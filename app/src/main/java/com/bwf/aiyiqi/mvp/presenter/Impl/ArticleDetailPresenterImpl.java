package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseArticleCommunite;
import com.bwf.aiyiqi.entity.ResponseArticleDetail;
import com.bwf.aiyiqi.mvp.model.ArticleDetailModel;
import com.bwf.aiyiqi.mvp.model.Impl.ArticleDetailModelImpl;
import com.bwf.aiyiqi.mvp.presenter.ArticleDetailPresenter;
import com.bwf.aiyiqi.mvp.view.ArticleDetailView;

/**
 * Created by lingchen52 on 2016/12/1.
 */

public class ArticleDetailPresenterImpl implements ArticleDetailPresenter, ArticleDetailModel.Callback {
    private ArticleDetailModel mModel;
    private ArticleDetailView mView;

    public ArticleDetailPresenterImpl(ArticleDetailView view) {
        this.mView = view;
        this.mModel = new ArticleDetailModelImpl();
    }


    @Override
    public void loadArticleDetail(String newsId) {
        mModel.loadArticleDetail(newsId, this);
    }

    @Override
    public void loadArticleCommunite(String newsId) {
        mModel.loadArticleCommunite(newsId,this);
    }

    @Override
    public void loadArticleDetailSuccess(ResponseArticleDetail.DataBean articleDetail) {
        mView.showArticleDetail(articleDetail);
        mView.showRelatedArticle(articleDetail.getRelatedNews());
    }

    @Override
    public void loadArticleCommuniteSuccess(ResponseArticleCommunite dataBean) {
        mView.showArticleCommunite(dataBean);
    }

    @Override
    public void loadArticleDetailFailed() {

    }

    @Override
    public void loadloadArticleCommuniteFailed() {

    }
}
