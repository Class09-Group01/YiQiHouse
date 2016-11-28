package com.bwf.aiyiqi.gui.adapter.BaseAdapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public abstract class BasePagerAdapter<T> extends PagerAdapter {
    public Context mContext;
    public List<T> datas;
    public List<View> mViews;
    public LayoutInflater mLayoutInflater;

    public BasePagerAdapter(Context context, List<T> datas) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        mViews = new ArrayList<>();
        this.datas = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViews.get(position));
        return mViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position%mViews.size()));
    }

}
