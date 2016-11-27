package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;

import com.bwf.aiyiqi.entity.ResponseMainFragmentViewPagerDatas;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.BasePagerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MainFragmentPagerAdapter<T> extends BasePagerAdapter {
    private Context mContext;
    private List<ResponseMainFragmentViewPagerDatas.DataBean> datas;
    private List<SimpleDraweeView> images ;

    public MainFragmentPagerAdapter(Context context, List<ResponseMainFragmentViewPagerDatas.DataBean> datas) {
        super(context,datas);
        this.mContext = context;
        if(datas == null || datas.size() == 0){
            this.datas = new ArrayList<>();
        }else{
            this.datas = datas;
        }
        images = new ArrayList<SimpleDraweeView>();
        for (int i = 0; i < datas.size(); i++) {
            SimpleDraweeView image = new SimpleDraweeView(context);
            images.add(image);
        }
    }



}
