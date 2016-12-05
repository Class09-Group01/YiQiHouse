package com.bwf.aiyiqi.gui.adapter.BaseAdapter;

import android.content.Context;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseEffectctBeautyDatas;

/**
 * Created by Administrator on 2016/12/4.
 */

public class EffectPictureBeautyGridAdapter extends CommonBaseAdapter<ResponseEffectctBeautyDatas.DataBean.ListBean> {
    public EffectPictureBeautyGridAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void setViewContent(CommonViewHolder holder, ResponseEffectctBeautyDatas.DataBean.ListBean listBean) {
        holder.setSimpleDraweeView(R.id.fepb_item_img,listBean.getUrl())
                .setTextView(R.id.fepb_text_look,listBean.getLike_num())
                .setTextView(R.id.fepb_text_like,listBean.getLike_num());
    }
}
