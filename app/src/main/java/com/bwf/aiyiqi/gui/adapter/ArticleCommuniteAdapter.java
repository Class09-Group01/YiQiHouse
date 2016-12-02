package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseArticleCommunite;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.ListViewBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/12/2.
 */

public class ArticleCommuniteAdapter extends ListViewBaseAdapter {
    private List<ResponseArticleCommunite.DataBeanX.DataBean> mDataBeen;
    private LayoutInflater mLayoutInflater;

    public ArticleCommuniteAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
        mDataBeen = new ArrayList<>();
    }

    public void setDataBeen(List<ResponseArticleCommunite.DataBeanX.DataBean> mDataBeen) {
        this.mDataBeen.addAll(mDataBeen);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return mDataBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.item_listview_article_communite, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mImageUserCommunite.setImageURI(Uri.parse(mDataBeen.get(position).getUserheadimage()));
        holder.mNameUserCommunite.setText(mDataBeen.get(position).getComment_user_name());
        holder.mDetailUserCommunite.setText(mDataBeen.get(position).getComment_content());
        holder.mTimeUserCommunite.setText(mDataBeen.get(position).getComment_time());
        Log.d("ArticleCommuniteAdapter", mDataBeen.get(position).getComment_user_name());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.image_user_communite)
        SimpleDraweeView mImageUserCommunite;
        @BindView(R.id.name_user_communite)
        TextView mNameUserCommunite;
        @BindView(R.id.time_user_communite)
        TextView mTimeUserCommunite;
        @BindView(R.id.detail_user_communite)
        TextView mDetailUserCommunite;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
