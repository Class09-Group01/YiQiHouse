package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseEffectPictrueSubjectDatas;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CommonBaseAdapter;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CommonViewHolder;

/**
 * Created by Administrator on 2016/11/27.
 */

public class FragmentEffectPictureSubjectAdapter
        extends CommonBaseAdapter<ResponseEffectPictrueSubjectDatas.DataBean.ListBean> {
    public FragmentEffectPictureSubjectAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void setViewContent(CommonViewHolder holder,
                               ResponseEffectPictrueSubjectDatas.DataBean.ListBean listBean) {
            holder.setTextView(R.id.feps_item_des,listBean.getDesc())
            .setTextView(R.id.feps_item_textcontent,listBean.getTitle())
            .setTextView(R.id.feps_item_like,listBean.getLike_num()+"")
            .setTextView(R.id.feps_item_look,listBean.getCollected())
            .setSimpleDraweeView(R.id.feps_item_imgcontent,listBean.getUrl());
    }

}
