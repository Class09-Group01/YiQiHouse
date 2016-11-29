package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityListView;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.ListViewBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public class DecorationCompanyListViewAdapter extends ListViewBaseAdapter {
    private List<ResponseDecorationCompanyActivityListView.DataBean> siteBeanList;
    private LayoutInflater mLayoutInflater;

    public DecorationCompanyListViewAdapter(Context context, List<ResponseDecorationCompanyActivityListView.DataBean> siteBeanList) {
        this.siteBeanList = siteBeanList;
        mLayoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return siteBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return siteBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_listview_activity_decoration_company, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mImageListviewActivityDecorationCompany.setImageURI(Uri.parse(siteBeanList.get(position).getImageUrl()));
        holder.mSiteItemListviewDecoration.setText(siteBeanList.get(position).getOrderHouse().getCommunity());
        holder.mCompositionItemListviewDecoration.setText(siteBeanList.get(position).getOrderHouse().getLayout());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.image_listview_activity_decoration_company)
        SimpleDraweeView mImageListviewActivityDecorationCompany;
        @BindView(R.id.site_item_listview_decoration)
        TextView mSiteItemListviewDecoration;
        @BindView(R.id.composition_item_listview_decoration)
        TextView mCompositionItemListviewDecoration;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
