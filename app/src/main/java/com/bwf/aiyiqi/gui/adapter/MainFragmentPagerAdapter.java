package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainFragmentViewPagerDatas;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MainFragmentPagerAdapter extends PagerAdapter implements View.OnClickListener {
    private Context mContext;
    private List<ResponseMainFragmentViewPagerDatas.DataBean> datas;
    private List<SimpleDraweeView> images ;
    private LayoutInflater mLayoutInflater;
    private List<View> views;

    public MainFragmentPagerAdapter(Context context, List<ResponseMainFragmentViewPagerDatas.DataBean> datas) {
//        images = new ArrayList<>();
        views = new ArrayList<>();
        this.datas = datas;
        mLayoutInflater = LayoutInflater.from(context);
        for (int i = 0; i < datas.size(); i++) {
            SimpleDraweeView image = new SimpleDraweeView(context);
            View view =  mLayoutInflater.inflate(R.layout.viewpager,null);
            view.setTag(view.findViewById(R.id.image_main_fragment_viewpager));
            views.add(view);
            Log.d("MainFragmentPagerAdapte", "view:" + view);
            Log.d("MainFragmentPagerAdapte", "view.findViewById:" + view.findViewById(R.id.image_main_fragment_viewpager));
            view.findViewById(R.id.image_main_fragment_viewpager).setTag(i);
            view.setOnClickListener(this);
//            image.setImageURI(Uri.parse(datas.get(i).getImagesrc()));
//            images.add(image);
        }


    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position%views.size());
        container.addView(view);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.getTag();
        simpleDraweeView.setImageURI(datas.get(position).getImagesrc());
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = views.get(position%views.size());
        container.removeView(view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public void onClick(View v) {

    }
}
