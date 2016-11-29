package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseYiQiGroup;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/11/29.
 */

public class YiQiGroupGridViewAdapter extends BaseAdapter {
    private List<ResponseYiQiGroup.DataBean> mDataBeens;
    private LayoutInflater mLayoutInflater;

    public YiQiGroupGridViewAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mDataBeens = new ArrayList<>();
    }

    public void addDatas(List<ResponseYiQiGroup.DataBean> mDatas) {
        this.mDataBeens.addAll(mDatas);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDataBeens.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataBeens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.item_gridview_yiqigroup_activity, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mImageYiqigroupActivity.setImageURI(Uri.parse(mDataBeens.get(position).getAvatar()));
        holder.mTextviewNameYiqigroup.setText(mDataBeens.get(position).getVendorName());
        holder.mTextviewDecorationNumber.setText("装修案例："+mDataBeens.get(position).getCaseNumber());
        holder.mRatingbarRatingYiqiqroup.setRating(mDataBeens.get(position).getRating());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.image_yiqigroup_activity)
        SimpleDraweeView mImageYiqigroupActivity;
        @BindView(R.id.textview_name_yiqigroup)
        TextView mTextviewNameYiqigroup;
        @BindView(R.id.textview_decoration_number)
        TextView mTextviewDecorationNumber;
        @BindView(R.id.ratingbar_rating_yiqiqroup)
        RatingBar mRatingbarRatingYiqiqroup;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
