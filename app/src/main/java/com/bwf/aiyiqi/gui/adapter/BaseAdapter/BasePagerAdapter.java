package com.bwf.aiyiqi.gui.adapter.BaseAdapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public abstract class BasePagerAdapter<T> extends PagerAdapter {
    private Context mContext;
    private List<T> datas;
    private List<SimpleDraweeView> images ;
    private LayoutInflater mLayoutInflater;

    public BasePagerAdapter(Context context, List<T> datas) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        if(datas == null || datas.size() == 0){
            this.datas = new ArrayList<>();
        }else{
            this.datas = datas;
        }
        images = new ArrayList<SimpleDraweeView>();

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }

}
