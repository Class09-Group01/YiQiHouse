package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.EssenceSay;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.RecycleViewBaseAdapter;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class EssenceFragmentAdapter extends RecycleViewBaseAdapter<EssenceSay.DataBean> {
    public EssenceFragmentAdapter(Context context) {
        super(context);
    }

    @Override
    public int getHeaderCount() {
        return 0;
    }

    @Override
    public int getFooterCount() {
        return 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        super.onBindViewHolder(holder, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.essencesay_contentitem,parent,false);
        return super.onCreateViewHolder(parent, viewType);
    }
}
