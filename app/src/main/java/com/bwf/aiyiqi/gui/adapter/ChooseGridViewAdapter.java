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
public class ChooseGridViewAdapter extends BaseAdapter{
    private List<PlateSay.DataBean> dataBeen2;
    private LayoutInflater mInflater;
    private Context mContext;

    public ChooseGridViewAdapter(Context context) {
        mContext = context;
        dataBeen2 = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<PlateSay.DataBean> dataBeen2) {
        this.dataBeen2.clear();
        this.dataBeen2.addAll(dataBeen2);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataBeen2.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeen2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ChooseViewHolder mHolder=null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.gridview_item, parent, false);
            mHolder=new ChooseViewHolder(convertView);
            convertView.setTag(mHolder);
        }
        else{
            mHolder= (ChooseViewHolder)convertView.getTag();
        }
        PlateSay.DataBean dataBean= dataBeen2.get(position);
        mHolder.mGridviewItemImage.setImageURI(Uri.parse(dataBean.getIcon()));
        mHolder.mGridviewItemTitle.setText(dataBean.getTitle());
        mHolder.mGridviewItemThreadsnum.setText(mContext.getString(R.string.gridview_item_threadsnum,dataBean.getThreadsnum()));
        mHolder.mGridviewItemVerticalxian.setVisibility(View.GONE);
        if(position>=dataBeen2.size()-2){
            mHolder.mGridviewItemXian.setVisibility(View.GONE);
        }
        return convertView;
    }

    static class ChooseViewHolder {
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

        ChooseViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
