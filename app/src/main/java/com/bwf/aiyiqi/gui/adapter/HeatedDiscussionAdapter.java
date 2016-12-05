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
 * Created by Administrator on 2016/12/1.
 * 功能描述：
 * 作者：
 */
public class HeatedDiscussionAdapter extends BaseAdapter{
    private List<PlateSay.DataBean> dataBeen3;
    private LayoutInflater mInflater;
    private Context mContext;

    public HeatedDiscussionAdapter(Context context) {
        mContext = context;
        dataBeen3 = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<PlateSay.DataBean> dataBeen3) {
        this.dataBeen3.clear();
        this.dataBeen3.addAll(dataBeen3);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataBeen3.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeen3.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       HeateViewHolder mHolder=null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.gridview_item, parent, false);
            mHolder=new HeateViewHolder(convertView);
            convertView.setTag(mHolder);
        }
        else{
            mHolder= (HeateViewHolder) convertView.getTag();
        }
        PlateSay.DataBean dataBean= dataBeen3.get(position);
        mHolder.mGridviewItemImage.setImageURI(Uri.parse(dataBean.getIcon()));
        mHolder.mGridviewItemTitle.setText(dataBean.getTitle());
        mHolder.mGridviewItemThreadsnum.setText(mContext.getString(R.string.gridview_item_threadsnum,dataBean.getThreadsnum()));
        mHolder.mGridviewItemVerticalxian.setVisibility(View.GONE);
        if(position>=dataBeen3.size()-2){
            mHolder.mGridviewItemXian.setVisibility(View.GONE);
        }
        return convertView;
    }

    static class HeateViewHolder {
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

        HeateViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
