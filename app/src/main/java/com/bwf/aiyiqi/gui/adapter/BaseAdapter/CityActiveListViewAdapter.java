package com.bwf.aiyiqi.gui.adapter.BaseAdapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseCityActiveDatas;
import com.bwf.aiyiqi.framwork.tool.TimeTools;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/11/26.
 */

public class CityActiveListViewAdapter extends ListViewBaseAdapter {

    private ResponseCityActiveDatas mDatas;
    private LayoutInflater mLayoutInflater;

    public CityActiveListViewAdapter(Context context, ResponseCityActiveDatas datas) {
        this.mDatas = datas;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas.getData().getForumlist().size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.getData().getForumlist().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_listview_activity_city_active, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mImageItemListviewCityActive.setImageURI(Uri.parse(mDatas.getData().getForumlist().get(position).getAttachments()));
        long expiration = mDatas.getData().getForumlist().get(position).getExpiration();
        holder.mDeteline.setText("报名截止日期: "+TimeTools.timestampToDate(expiration));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.image_item_listview_city_active)
        SimpleDraweeView mImageItemListviewCityActive;
        @BindView(R.id.deteline)
        TextView mDeteline;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
