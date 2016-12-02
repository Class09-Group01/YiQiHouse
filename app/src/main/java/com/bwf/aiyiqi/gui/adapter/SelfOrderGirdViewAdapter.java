package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bwf.aiyiqi.entity.ResponseSelfOrderDatas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/1.
 */

public class SelfOrderGirdViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<ResponseSelfOrderDatas.DataBeanX.DataBean> listbean;
    private LayoutInflater mInflater;

    public SelfOrderGirdViewAdapter(Context context){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        listbean = new ArrayList<>();

    }


    @Override
    public int getCount() {
        return listbean.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

}

