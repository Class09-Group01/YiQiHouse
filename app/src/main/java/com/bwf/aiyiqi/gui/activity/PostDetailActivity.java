package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponsePostCommunite;
import com.bwf.aiyiqi.entity.ResponsePostDetail;
import com.bwf.aiyiqi.entity.ResponsePostZan;
import com.bwf.aiyiqi.mvp.presenter.Impl.PostDetailPresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.PostDetailPresenter;
import com.bwf.aiyiqi.mvp.view.PostView;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.lankton.flowlayout.FlowLayout;

/**
 * Created by Administrator on 2016/11/29.
 */

public class PostDetailActivity extends BaseActivity implements PostView{
    @BindView(R.id.back_activity_decoration_company)
    ImageView mBackActivityDecorationCompany;
    @BindView(R.id.mf_recycleview_post_image)
    SimpleDraweeView mMfRecycleviewPostImage;
    @BindView(R.id.mf_recycleview_post_textview_name)
    TextView mMfRecycleviewPostTextviewName;
    @BindView(R.id.mf_recycleview_post_textview_time)
    TextView mMfRecycleviewPostTextviewTime;
    @BindView(R.id.mf_recycleview_post_image_add_attention)
    ImageView mMfRecycleviewPostImageAddAttention;
    @BindView(R.id.mf_recycleview_post_layout)
    LinearLayout mMfRecycleviewPostLayout;
    @BindView(R.id.activity_postdetail_title)
    TextView mActivityPostdetailTitle;
    @BindView(R.id.activity_postdetail_from)
    TextView mActivityPostdetailFrom;
    @BindView(R.id.activity_postdetail_time)
    TextView mActivityPostdetailTime;
    @BindView(R.id.ll_detail_postdetail_activity)
    LinearLayout mLlDetailPostdetailActivity;
    @BindView(R.id.flowlayout_tag_postdetail_activity)
    FlowLayout mFlowlayoutTagPostdetailActivity;

    private PostDetailPresenter mPresenter;
    @Override
    protected int getContentViewResId() {
        return R.layout.activity_postdetail_activity;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        String tid = getIntent().getStringExtra("tid");
        mPresenter = new PostDetailPresenterImpl(this);
        mPresenter.loadPostDetail(tid);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showPostDetail(ResponsePostDetail postDetail) {

    }

    @Override
    public void showPostZan(ResponsePostZan postZan) {

    }

    @Override
    public void showPostCommunite(ResponsePostCommunite postCommunite) {

    }

    @Override
    public void showPostDetailFailed() {

    }

    @Override
    public void showPostZanFailed() {

    }

    @Override
    public void showPostCommuniteFailed() {

    }
}
