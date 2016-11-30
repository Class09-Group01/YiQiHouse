package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.RecenterSay;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.RecycleViewBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/29.
 * 功能描述：
 * 作者：
 */

public class RecenterFragmentAdapter extends RecycleViewBaseAdapter<RecenterSay> {
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
        if(position<getItemCount()-1){

        }

    }

    static class RecenterViewHolder extends RecyclerView.ViewHolder{
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

        RecenterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
