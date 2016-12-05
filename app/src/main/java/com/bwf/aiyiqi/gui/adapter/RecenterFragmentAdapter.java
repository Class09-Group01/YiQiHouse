package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.RecenterSay;
import com.bwf.aiyiqi.gui.activity.PostDetailActivity;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.RecycleViewBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/29.
 * 功能描述：
 * 作者：
 */

public class RecenterFragmentAdapter extends RecycleViewBaseAdapter<RecenterSay.DataBean> {
    public RecenterFragmentAdapter(Context context) {
        super(context);
    }

    @Override
    public int getHeaderCount() {
        return 0;
    }

    @Override
    public int getFooterCount() {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {
            View view = inflater.inflate(R.layout.recentersay_contentitem, parent, false);
            return new RecenterViewHolder(view);
        }
        return super.onCreateViewHolder(parent, viewType);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (position < getItemCount() - 1) {
            RecenterViewHolder mRecenterViewHolder = (RecenterViewHolder) holder;
            RecenterSay.DataBean dataBean = data.get(position);
            mRecenterViewHolder.mRecenterSaySimple.setImageURI(Uri.parse(dataBean.getAvtUrl()));
            mRecenterViewHolder.mRecenterSaySubject.setText(dataBean.getSubject());
            mRecenterViewHolder.mRecenterSayAuthor.setText(dataBean.getAuthor());
            mRecenterViewHolder.mRecenterSayDateline.setText(dataBean.getDateline());
            mRecenterViewHolder.mRecenterSayReplies.setText(dataBean.getReplies());
            mRecenterViewHolder.mRecenterSayViews.setText(dataBean.getViews());
            if(dataBean.getAttachments()==null){
                mRecenterViewHolder.mRecenterSayIsimage.setVisibility(View.GONE);
            }
        }
    }

     class RecenterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recenter_say_simple)
        SimpleDraweeView mRecenterSaySimple;
        @BindView(R.id.recenter_say_subject)
        TextView mRecenterSaySubject;
        @BindView(R.id.recenter_say_author)
        TextView mRecenterSayAuthor;
        @BindView(R.id.recenter_say_dateline)
        TextView mRecenterSayDateline;
        @BindView(R.id.recenter_say_replies)
        TextView mRecenterSayReplies;
        @BindView(R.id.recenter_say_comment_image)
        ImageView mRecenterSayCommentImage;
        @BindView(R.id.recenter_say_views)
        TextView mRecenterSayViews;
        @BindView(R.id.recenter_say_isimage)
        ImageView mRecenterSayIsimage;

        RecenterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition=getAdapterPosition();
//                    mItemOnClickListener.itemListener(v,itemPosition);
                    String tid=data.get(itemPosition).getTid();
                    Intent intent=new Intent(mContext, PostDetailActivity.class);
                    intent.putExtra("tid",tid);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    public interface RecenterItemOnClickListener{
        void itemListener(View view,int position);
    }
    private RecenterFragmentAdapter.RecenterItemOnClickListener mItemOnClickListener;

    public void setItemOnClickListener(RecenterItemOnClickListener itemOnClickListener) {
        mItemOnClickListener = itemOnClickListener;
    }
}
