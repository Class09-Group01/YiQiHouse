package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.view.View;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSearchDatas;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CommonBaseAdapter;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CommonViewHolder;

/**
 * Created by Administrator on 2016/11/28.
 */

public class SearchAcitvityListviewAdapter extends CommonBaseAdapter
        <ResponseSearchDatas.DataBean> {
    public SearchAcitvityListviewAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void setViewContent(CommonViewHolder holder, ResponseSearchDatas.DataBean dataBean) {
        holder.setTextView(R.id.asli_phonetext,dataBean.getAuthor())
                .setTextView(R.id.asli_contenttext,dataBean.getSubject())
                .setTextView(R.id.asli_fromtext,dataBean.getFname())
                .setTextView(R.id.asli_liketext,dataBean.getZan()+"")
                .setTextView(R.id.asli_chattext,dataBean.getReplies()+"")
                .setSimpleDraweeView(R.id.asli_userimg,dataBean.getAvtUrl())
                .setTextView(R.id.asli_timetext,dataBean.getDateline());
        if (dataBean.getAttachments() == null){
            holder.getView(R.id.asli_contentimg).setVisibility(View.GONE);
        }else{
            holder.getView(R.id.asli_contentimg).setVisibility(View.VISIBLE);
            holder.setSimpleDraweeView(R.id.asli_contentimg,dataBean.getAttachments().get(0));
        }

    }
}
