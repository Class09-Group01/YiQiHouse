package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.PlateSay;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/30.
 * 功能描述：
 * 作者：
 */
public class ForunGridViewAdapter extends BaseAdapter {
    private List<PlateSay.DataBean> dataBeen1;
    private LayoutInflater mInflater;
    private Context mContext;

    public ForunGridViewAdapter(Context context) {
        mContext = context;
        dataBeen1 = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<PlateSay.DataBean> dataBeen1) {
        this.dataBeen1.clear();
        this.dataBeen1.addAll(dataBeen1);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataBeen1.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeen1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridViewViewHolder mHolder=null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.gridview_item, parent, false);
            mHolder=new GridViewViewHolder(convertView);
            convertView.setTag(mHolder);
        }
        else{
            mHolder= (GridViewViewHolder) convertView.getTag();
        }
        PlateSay.DataBean dataBean= dataBeen1.get(position);
        mHolder.mGridviewItemImage.setImageURI(Uri.parse(dataBean.getIcon()));
        mHolder.mGridviewItemTitle.setText(dataBean.getTitle());
        mHolder.mGridviewItemThreadsnum.setText(mContext.getString(R.string.gridview_item_threadsnum,dataBean.getThreadsnum()));
        if(position%2==1){
            mHolder.mGridviewItemVerticalxian.setVisibility(View.GONE);
        }
        if(position>=dataBeen1.size()-2){
           mHolder.mGridviewItemXian.setVisibility(View.GONE);
        }
        return convertView;
    }

    static class GridViewViewHolder {
        @BindView(R.id.gridview_item_image)
        SimpleDraweeView mGridviewItemImage;
        @BindView(R.id.gridview_item_title)
        TextView mGridviewItemTitle;
        @BindView(R.id.gridview_item_threadsnum)
        TextView mGridviewItemThreadsnum;
        @BindView(R.id.gridview_item_verticalxian)
        View mGridviewItemVerticalxian;
        @BindView(R.id.gridview_item_xian)
        View mGridviewItemXian;

        GridViewViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
