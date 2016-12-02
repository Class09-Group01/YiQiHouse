package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.GridView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSiteLiveComments;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CommonBaseAdapter;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CommonViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/1.
 */

public class SiteLiveListViewAdapter extends CommonBaseAdapter<ResponseSiteLiveComments.DataBean> {
    private Context context;
    private List<String> urls;
    public SiteLiveListViewAdapter(Context context, int layoutId) {
        super(context, layoutId);
        this.context = context;
        urls = new ArrayList<>();
    }

    @Override
    public void setViewContent(CommonViewHolder holder, ResponseSiteLiveComments.DataBean comments) {
        if(!TextUtils.isEmpty(comments.getAvatar())){
            holder.setSimpleDraweeView(R.id.asci_item,comments.getAvatar());
        }
        holder.setTextView(R.id.asci_item_name,comments.getCreatorName()+"("+comments.getCreatorRole()+")");
        holder.setTextView(R.id.asci_item_time,timeSwitch(comments.getCreateTime()));
        holder.setTextView(R.id.asci_item_textcontent,comments.getMessage());
        if(!TextUtils.isEmpty(comments.getImgSrc())){
            GridView gridView = holder.getView(R.id.asci_item_gridview);
            CommonBaseAdapter adapter = new CommonBaseAdapter<String>(context,R.layout.activity_sitelive_comments_grid_item) {
            @Override
            public void setViewContent(CommonViewHolder holder, String url) {
                holder.setSimpleDraweeView(R.id.ascg_item_img,url);
            }
        };
            gridView.setAdapter(adapter);
            adapter.setData(addUrls(comments.getImgSrc()));
        }

    }

    private String timeSwitch(long time){
        String date = "";
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        date = format.format(time);
        return date;
    }

    private List<String> addUrls(String url){
        List<String> urls = new ArrayList<>();
        String[] uu = url.split(",");
        for (int i = 0; i < uu.length; i++) {
            urls.add(uu[i]);
        }
        return urls;
    }
}
