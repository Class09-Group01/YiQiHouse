package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseAutoOrder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/12/5.
 */

public class AutoOrderGridviewAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private int tag;
    private List<ResponseAutoOrder.DataBeanX> datas;
    List<ResponseAutoOrder.DataBeanX.DataBean> bean;

    public AutoOrderGridviewAdapter(Context context, int tag) {
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
    public int getCount() {
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

    @Override
    public Object getItem(int position) {
        if (tag == 0) {
            return bean.get(position);
        }
        return datas.get(tag - 1).getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_gridview_auto_order, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (tag == 0) {
            Log.d("AutoOrderGridviewAdapte", "tag:" + tag);
            String url = bean.get(position).getLogo();
            String text = bean.get(position).getBusiness_name();
            holder.mImageGridviewAutoOrder.setImageURI(Uri.parse(url));
            holder.mNameGridviewAutoOrder.setText(text);
        } else {
            Log.d("AutoOrderGridviewAdapte", "tag:" + tag);
            String url = datas.get(tag - 1).getData().get(position).getLogo();
            Log.d("AutoOrderGridviewAdapte", url);
            String text = datas.get(tag - 1).getData().get(position).getBusiness_name();
            holder.mImageGridviewAutoOrder.setImageURI(Uri.parse(url));
            holder.mNameGridviewAutoOrder.setText(text);
        }
        return convertView;
    }

    public class ViewHolder {
        @BindView(R.id.image_gridview_auto_order)
        SimpleDraweeView mImageGridviewAutoOrder;
        @BindView(R.id.name_gridview_auto_order)
        TextView mNameGridviewAutoOrder;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
