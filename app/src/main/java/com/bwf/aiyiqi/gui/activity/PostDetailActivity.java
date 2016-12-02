package com.bwf.aiyiqi.gui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponsePostCommunite;
import com.bwf.aiyiqi.entity.ResponsePostDetail;
import com.bwf.aiyiqi.entity.ResponsePostZan;
import com.bwf.aiyiqi.framwork.tool.UnicodeParser;
import com.bwf.aiyiqi.gui.adapter.PostCommuniteListViewAdapter;
import com.bwf.aiyiqi.gui.view.MyListView;
import com.bwf.aiyiqi.mvp.presenter.Impl.PostDetailPresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.PostDetailPresenter;
import com.bwf.aiyiqi.mvp.view.PostView;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.lankton.flowlayout.FlowLayout;

/**
 * Created by Administrator on 2016/11/29.
 */

public class PostDetailActivity extends BaseActivity implements PostView {
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
    @BindView(R.id.ll_postzan)
    LinearLayout mLlPostzan;
    @BindView(R.id.review_number)
    TextView mReviewNumber;
    @BindView(R.id.listview_post_communite)
    MyListView mListviewPostCommunite;

    private PostDetailPresenter mPresenter;
    private PostCommuniteListViewAdapter adapter;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_postdetail_activity;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initDatas() {
        String tid = getIntent().getStringExtra("tid");
        mPresenter = new PostDetailPresenterImpl(this);
        adapter = new PostCommuniteListViewAdapter(this);
        mListviewPostCommunite.setAdapter(adapter);
        mPresenter.loadPostDetail(tid);
        mPresenter.loadPostZan(tid);
        mPresenter.loadPostCommunite(tid);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    @Override
    public void showPostDetail(ResponsePostDetail postDetail) {
        ResponsePostDetail.DataBean data = postDetail.getData();
        mMfRecycleviewPostImage.setImageURI(Uri.parse(data.getAvtUrl()));
        mMfRecycleviewPostTextviewName.setText(data.getAuthor());
        mActivityPostdetailTitle.setText(data.getTitle());
        mActivityPostdetailTime.setText(data.getDateline());
        List<ResponsePostDetail.DataBean.MessageBean> message = data.getMessage();
        for (int i = 0; i < message.size(); i++) {
            if (message.get(i).getMsgType() == 0) {
                //文字
                TextView tv = new TextView(this);
                String text = UnicodeParser.decodeUnicode(message.get(i).getMsg());
//                webview.loadData(text,"text/plain", "UTF-8");
                Log.d("PostDetailActivity", "tv:" + tv);
                tv.setText(message.get(i).getMsg());
                tv.setTextColor(getResources().getColor(R.color.black));
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                mLlDetailPostdetailActivity.addView(tv);
            } else if (message.get(i).getMsgType() == 1) {
                //图片
                SimpleDraweeView image = new SimpleDraweeView(this);
                image.setMinimumHeight(500);
                image.setMaxHeight(600);
                image.setPadding(0,20,0,20);
                image.setImageURI(Uri.parse(message.get(i).getMsg()));
                mLlDetailPostdetailActivity.addView(image);
            }
        }
        //Tag 流式布局
        List<ResponsePostDetail.DataBean.TagsBean> tags = data.getTags();
        for (int i = 0; i < tags.size(); i++) {
            TextView textview = new TextView(this);
            textview.setText(tags.get(i).getTagname());
            textview.setPadding(10,10,10,10);
            mFlowlayoutTagPostdetailActivity.addView(textview);
        }
    }

    @Override
    public void showPostZan(ResponsePostZan postZan) {
        if (postZan.getData() != null) {
            mLlPostzan.setVisibility(View.VISIBLE);
            TextView zannumber = new TextView(this);
            zannumber.setText("赞（" + postZan.getData().size() + ")");
            mLlPostzan.addView(zannumber);
            for (int i = 0; i < postZan.getData().size(); i++) {
                SimpleDraweeView userImage = new SimpleDraweeView(this);
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
                roundingParams.setRoundAsCircle(true);
                userImage.getHierarchy().setRoundingParams(roundingParams);
                userImage.setImageURI(Uri.parse(postZan.getData().get(i).getAvtUrl()));
                userImage.setMinimumHeight(100);
                userImage.setMinimumWidth(100);
                mLlPostzan.addView(userImage);
            }
        }
    }

    @Override
    public void showPostCommunite(ResponsePostCommunite postCommunite) {
        if (postCommunite.getData() != null) {
            mReviewNumber.setText("回帖 （"+postCommunite.getData().size()+")");
            adapter.addDatas(postCommunite.getData());
        }
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
