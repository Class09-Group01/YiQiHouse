package com.bwf.aiyiqi.gui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseArticleCommunite;
import com.bwf.aiyiqi.entity.ResponseArticleDetail;
import com.bwf.aiyiqi.gui.adapter.ArticleCommuniteAdapter;
import com.bwf.aiyiqi.gui.adapter.RelatedArticleAdapter;
import com.bwf.aiyiqi.gui.view.MyListView;
import com.bwf.aiyiqi.mvp.presenter.ArticleDetailPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.ArticleDetailPresenterImpl;
import com.bwf.aiyiqi.mvp.view.ArticleDetailView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.lankton.flowlayout.FlowLayout;

/**
 * Created by lingchen52 on 2016/12/1.
 */

public class ArticleDetailActivity extends BaseActivity implements ArticleDetailView {


    @BindView(R.id.back_activity_decoration_company)
    ImageView mBackActivityDecorationCompany;
    @BindView(R.id.article_title)
    TextView mArticleTitle;
    @BindView(R.id.flowlayout_article_detail)
    FlowLayout mFlowlayoutArticleDetail;
    @BindView(R.id.ll_article_detail)
    LinearLayout mLlArticleDetail;
    @BindView(R.id.listview_related_article)
    MyListView mListviewRelatedArticle;
    @BindView(R.id.textview_communite_number)
    TextView mTextviewCommuniteNumber;
    @BindView(R.id.listview_article_communite)
    MyListView mListviewArticleCommunite;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.edit_input)
    EditText mEditInput;
    private ArticleDetailPresenter mPresenter;
    private RelatedArticleAdapter mRelatedArticleAdapter;
    private ArticleCommuniteAdapter mCommuniteAdapter;

    @Override
    protected void initDatas() {
        String newsId = getIntent().getStringExtra("newsId");
        mPresenter = new ArticleDetailPresenterImpl(this);
        mPresenter.loadArticleDetail(newsId);
        mPresenter.loadArticleCommunite(newsId);
        mRelatedArticleAdapter = new RelatedArticleAdapter(this);
        mCommuniteAdapter = new ArticleCommuniteAdapter(this);
        mListviewRelatedArticle.setAdapter(mRelatedArticleAdapter);
        mListviewArticleCommunite.setAdapter(mCommuniteAdapter);
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mTitle.setText("文章详情");

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_article_detail;
    }

    @Override
    public void showArticleDetail(ResponseArticleDetail.DataBean dataBean) {
        mArticleTitle.setText(dataBean.getCurrentNews().getTitle());
        List<String> content = dataBean.getCurrentNews().getContent();
        for (int i = 0; i < content.size(); i++) {
            if (i % 2 == 0) {
                TextView textView = new TextView(this);
                textView.setText(content.get(i));
                textView.setTextColor(getResources().getColor(R.color.black));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                textView.setPadding(30, 10, 30, 10);
                mLlArticleDetail.addView(textView);
            } else {
                SimpleDraweeView image = new SimpleDraweeView(this);
                image.setMinimumHeight(600);
                image.setMaxHeight(800);
                image.setPadding(30, 10, 30, 10);
                image.setImageURI(Uri.parse(content.get(i)));
                mLlArticleDetail.addView(image);
            }
        }

    }

    @Override
    public void showRelatedArticle(List<ResponseArticleDetail.DataBean.RelatedNewsBean> relatedNewsBean) {
        mRelatedArticleAdapter.setDataBeen(relatedNewsBean);

    }


    @Override
    public void showArticleCommunite(ResponseArticleCommunite dataBean) {
        if (!dataBean.getData().getTotal().equals("0")) {
            Log.d("ArticleDetailActivity", dataBean.getData().getTotal());
            mCommuniteAdapter.setDataBeen(dataBean.getData().getData());
        }

    }

    @Override
    public void showArticleDetailFailed() {

    }

    @Override
    public void showRelatedArticleFailed() {

    }

    @Override
    public void showArticleCommuniteFailed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    @OnClick(R.id.back_activity_decoration_company)
    public void onClick() {
        finish();
        return;
    }
}
