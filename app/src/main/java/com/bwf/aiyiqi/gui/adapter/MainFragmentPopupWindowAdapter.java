package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CommonBaseAdapter;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CommonViewHolder;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainFragmentPopupWindowAdapter extends CommonBaseAdapter<String>{
    public MainFragmentPopupWindowAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void setViewContent(CommonViewHolder holder, String s) {
        holder.setTextView(R.id.fragment_home_pouwindow_city_title,s);
    }
}
