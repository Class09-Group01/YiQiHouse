package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;

import com.bwf.aiyiqi.entity.ResponseMainFragmentViewPagerDatas;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.BasePagerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

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
        for (int i = 0; i < datas.size(); i++) {
            SimpleDraweeView image = new SimpleDraweeView(context);
            image.setImageURI(Uri.parse(datas.get(i).getImagesrc()));
            images.add(image);
        }


    }



}
