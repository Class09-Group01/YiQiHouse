package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainFragmentRecycleviewData;
import com.bwf.aiyiqi.gui.activity.ArticleDetailActivity;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.RecycleViewBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainFragmentRecycleAdapter extends RecycleViewBaseAdapter
        <ResponseMainFragmentRecycleviewData.DataBean> {
    private final int TYPE_COTENT_NEWS = 1;
    private final int TYPE_COTENT_CARD = 3;
    private Context mContext;

    public MainFragmentRecycleAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public int getHeaderCount() {
        return 0;
    }

    @Override
    public int getFooterCount() {
        return 1;
    }

    /**
     * 设置两种不同的显示内容
     * @param positon
     * @return
     */
    @Override
    public int getContentType(int positon) {
        int type = data.get(positon).getType();
        if (type == TYPE_COTENT_NEWS) {
            return TYPE_COTENT_NEWS;
        } else if (type == TYPE_COTENT_CARD) {
            return TYPE_COTENT_CARD;
        }
        return super.getContentType(positon);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("MainFragmentRecycleAdap", "viewType:" + viewType);
        if (viewType == TYPE_COTENT_NEWS) {
            View view = inflater.inflate(R.layout.mainfragment_recycleview_article_item, parent, false);
            return new NewsViewHolder(view);
        } else if (viewType == TYPE_COTENT_CARD) {
            View view = inflater.inflate(R.layout.mainfragment_recycleview_post_item, parent, false);
            return new CardViewHolder(view);
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        int type = getItemViewType(position);

        if (type == TYPE_COTENT_NEWS) {
            NewsViewHolder newsViewHolder = (NewsViewHolder) holder;

            ResponseMainFragmentRecycleviewData.DataBean dataBean = data.get(position);
            if(dataBean.getPath() != null){
                newsViewHolder.mfRecycleviewArticleImage.setVisibility(View.VISIBLE);
                newsViewHolder.mfRecycleviewArticleImage.setImageURI(Uri.parse(dataBean.getPath()));
            }else{
                newsViewHolder.mfRecycleviewArticleImage.setVisibility(View.GONE);
            }
            newsViewHolder.mfRecycleviewArticleTextviewContent.setText(dataBean.getTitle());
            newsViewHolder.mfRecycleviewArticleComments.setText(dataBean.getViews()+"");
            newsViewHolder.mfRecycleviewArticleTime.setText(dataBean.getDateline());
            newsViewHolder.mfRecycleviewArticleConcern.setText(dataBean.getFollowed()+"");

        } else if (type == TYPE_COTENT_CARD) {
            CardViewHolder cardViewHolder = (CardViewHolder) holder;
            ResponseMainFragmentRecycleviewData.DataBean dataBean = data.get(position);
            if(dataBean.getPath() != null){
                cardViewHolder.mfRecycleviewPostImageContent.setVisibility(View.VISIBLE);
                cardViewHolder.mfRecycleviewPostImageContent.setImageURI(Uri.parse(dataBean.getPath()));
            }else{
                cardViewHolder.mfRecycleviewPostImageContent.setVisibility(View.GONE);
            }
            //TODO
            cardViewHolder.mfRecycleviewPostTextviewName.setText(dataBean.getAuthor());
            cardViewHolder.mfRecycleviewPostImage.setImageURI(Uri.parse(dataBean.getAvtUrl()));
            cardViewHolder.mfRecycleviewPostTextviewTime.setText(dataBean.getDateline());
            cardViewHolder.mfRecycleviewPostComments.setText(dataBean.getReplies()+"");
            cardViewHolder.mfRecycleviewArticleConcern.setText(dataBean.getLike_num()+"");
            cardViewHolder.mfRecycleviewPostForm.setText(dataBean.getForum().getName());
            cardViewHolder.mfRecycleviewPostTextContent.setText(dataBean.getTitle());
        }

    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.mf_recycleview_article_textview_titile)
        TextView mfRecycleviewArticleTextviewTitile;
        @BindView(R.id.mf_recycleview_article_textview_content)
        TextView mfRecycleviewArticleTextviewContent;
        @BindView(R.id.mf_recycleview_article_image)
        SimpleDraweeView mfRecycleviewArticleImage;
        @BindView(R.id.mf_recycleview_article_time)
        TextView mfRecycleviewArticleTime;
        @BindView(R.id.mf_recycleview_article_concern)
        TextView mfRecycleviewArticleConcern;
        @BindView(R.id.mf_recycleview_article_comments_image)
        ImageView mfRecycleviewArticleCommentsImage;
        @BindView(R.id.mf_recycleview_article_comments)
        TextView mfRecycleviewArticleComments;
        NewsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO 跳转详情页面
                    Log.d("MainFragmentRecycleAdap", "position:" + getAdapterPosition());
                    Intent intent = new Intent(mContext, ArticleDetailActivity.class);
                    intent.putExtra("newsId",data.get(getAdapterPosition()).getId());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.mf_recycleview_post_image)
        SimpleDraweeView mfRecycleviewPostImage;
        @BindView(R.id.mf_recycleview_post_textview_name)
        TextView mfRecycleviewPostTextviewName;
        @BindView(R.id.mf_recycleview_post_textview_time)
        TextView mfRecycleviewPostTextviewTime;
        @BindView(R.id.mf_recycleview_post_image_add_attention)
        ImageView mfRecycleviewPostImageAddAttention;
        @BindView(R.id.mf_recycleview_post_layout)
        LinearLayout mfRecycleviewPostLayout;
        @BindView(R.id.mf_recycleview_post_image_content)
        SimpleDraweeView mfRecycleviewPostImageContent;
        @BindView(R.id.mf_recycleview_post_form)
        TextView mfRecycleviewPostForm;
        @BindView(R.id.mf_recycleview_article_concern)
        TextView mfRecycleviewArticleConcern;
        @BindView(R.id.mf_recycleview_post_comments_image)
        ImageView mfRecycleviewPostCommentsImage;
        @BindView(R.id.mf_recycleview_post_comments)
        TextView mfRecycleviewPostComments;
        @BindView(R.id.mf_recycleview_post_text_content)
        TextView mfRecycleviewPostTextContent;

        CardViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO 跳转详情页面
                    Log.d("MainFragmentRecycleAdap", "position:" + getAdapterPosition());
                }
            });
        }
    }




}
