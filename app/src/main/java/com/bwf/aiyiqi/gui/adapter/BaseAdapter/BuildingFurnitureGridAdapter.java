package com.bwf.aiyiqi.gui.adapter.BaseAdapter;

import android.content.Context;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResposneBuildingFurnitureData;

/**
 * Created by Administrator on 2016/11/25.
 */

public class BuildingFurnitureGridAdapter extends CommonBaseAdapter
        <ResposneBuildingFurnitureData.DataBean.ChildrenBean>{

    public BuildingFurnitureGridAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void setViewContent(CommonViewHolder holder, ResposneBuildingFurnitureData.DataBean.ChildrenBean childrenBean) {
        holder.setTextView(R.id.abf_item_textview,childrenBean.getTitle());
    }
}
