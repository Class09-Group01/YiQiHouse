package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseArticleDetail;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.ListViewBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/12/2.
 */

public class RelatedArticleAdapter extends ListViewBaseAdapter {
    private List<ResponseArticleDetail.DataBean.RelatedNewsBean> mDataBeen;
    private LayoutInflater mLayoutInflater;

    public RelatedArticleAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mDataBeen = new ArrayList<>();
    }

    public void setDataBeen(List<ResponseArticleDetail.DataBean.RelatedNewsBean> mDataBeen) {
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
            convertView = mLayoutInflater.inflate(R.layout.item_listview_related_article, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTitleRelatedArticle.setText(mDataBeen.get(position).getTitle());
        holder.mImageRelatedArticle.setImageURI(Uri.parse(mDataBeen.get(position).getThumb()));
        holder.mLookupNumber.setText(mDataBeen.get(position).getClick()+"");
        holder.mCollectionNumber.setText(mDataBeen.get(position).getFavNums()+"");
        holder.mCommuniteNumber.setText(mDataBeen.get(position).getComment_count()+"");
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.title_related_article)
        TextView mTitleRelatedArticle;
        @BindView(R.id.image_related_article)
        SimpleDraweeView mImageRelatedArticle;
        @BindView(R.id.lookup_number)
        TextView mLookupNumber;
        @BindView(R.id.collection_number)
        TextView mCollectionNumber;
        @BindView(R.id.communite_number)
        TextView mCommuniteNumber;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
