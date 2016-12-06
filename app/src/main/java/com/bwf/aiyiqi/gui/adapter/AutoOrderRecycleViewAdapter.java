package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseAutoOrder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/12/6.
 */

public class AutoOrderRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private int tag;
    private List<ResponseAutoOrder.DataBeanX> datas;
    private List<ResponseAutoOrder.DataBeanX.DataBean> bean;
    public AutoOrderRecycleViewAdapter(Context context,int tag) {
        mLayoutInflater = LayoutInflater.from(context);
        this.tag = tag;
        this.datas = new ArrayList<>();
        this.bean = new ArrayList<>();
    }
    public void setDatas(List<ResponseAutoOrder.DataBeanX> datas) {
//        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_gridview_auto_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (tag == 0) {
            Log.d("AutoOrderGridviewAdapte", "tag:" + tag);
            String url = bean.get(position).getLogo();
            String text = bean.get(position).getBusiness_name();
            viewHolder.mImageGridviewAutoOrder.setImageURI(Uri.parse(url));
            viewHolder.mNameGridviewAutoOrder.setText(text);
        } else {
            Log.d("AutoOrderGridviewAdapte", "tag:" + tag);
            String url = datas.get(tag - 1).getData().get(position).getLogo();
            Log.d("AutoOrderGridviewAdapte", url);
            String text = datas.get(tag - 1).getData().get(position).getBusiness_name();
            viewHolder.mImageGridviewAutoOrder.setImageURI(Uri.parse(url));
            viewHolder.mNameGridviewAutoOrder.setText(text);
        }

    }

    @Override
    public int getItemCount() {
        if (tag == 0) {
            int counts = 0;
            for (int i = 0; i < datas.size(); i++) {
                counts += datas.get(i).getData().size();
                List<ResponseAutoOrder.DataBeanX.DataBean> data = datas.get(i).getData();
                bean.addAll(data);
            }
            return counts;
        }
        return datas.get(tag - 1).getData().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.image_gridview_auto_order)
        SimpleDraweeView mImageGridviewAutoOrder;
        @BindView(R.id.name_gridview_auto_order)
        TextView mNameGridviewAutoOrder;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
