package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponsePostCommunite;
import com.bwf.aiyiqi.entity.ResponsePostDetail;
import com.bwf.aiyiqi.entity.ResponsePostZan;
import com.bwf.aiyiqi.mvp.model.Impl.PostDetailModelImpl;
import com.bwf.aiyiqi.mvp.model.PostDetailModel;
import com.bwf.aiyiqi.mvp.presenter.PostDetailPresenter;
import com.bwf.aiyiqi.mvp.view.PostView;

/**
 * Created by lingchen52 on 2016/11/30.
 */

public class PostDetailPresenterImpl implements PostDetailPresenter, PostDetailModel.Callback {
    private PostView mPostView;
    private PostDetailModel mDetailModel;
    private int page;

    public PostDetailPresenterImpl(PostView postView) {
        this.mPostView = postView;
        this.mDetailModel = new PostDetailModelImpl();
    }

    @Override
    public void loadPostDetail(String tid) {
        mDetailModel.loadPostDetailDatas(tid,this );
    }

    @Override
    public void loadPostZan(String tid) {
        mDetailModel.loadPostZanDatas(tid,this);
    }

    @Override
    public void loadPostCommunite(String tid) {
        mDetailModel.loadPostCommuniteDatas(tid,page,this);
        page++;
    }

    @Override
    public void loadPostDetailDatasSuccess(ResponsePostDetail responsePostDetail) {
        mPostView.showPostDetail(responsePostDetail);
    }

    @Override
    public void loadPostZanDatasSuccess(ResponsePostZan responsePostZan) {
        mPostView.showPostZan(responsePostZan);
    }

    @Override
    public void loadPostCommuniteDatasSuccess(ResponsePostCommunite responsePostCommunite) {
        mPostView.showPostCommunite(responsePostCommunite);
    }

    @Override
    public void loadPostDetailDatasFailed() {
        mPostView.showPostDetailFailed();
    }

    @Override
    public void loadPostZanDatasFailed() {
        mPostView.showPostZanFailed();
    }

    @Override
    public void loadPostCommuniteDatasFailed() {
        mPostView.showPostCommuniteFailed();
        page--;
    }
}
