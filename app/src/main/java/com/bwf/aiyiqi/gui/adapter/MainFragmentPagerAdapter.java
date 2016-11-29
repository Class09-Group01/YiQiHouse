package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainFragmentViewPagerDatas;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.BasePagerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MainFragmentPagerAdapter<T> extends BasePagerAdapter implements View.OnClickListener {
    private List<ResponseMainFragmentViewPagerDatas.DataBean> datas;

    public MainFragmentPagerAdapter(Context context, List<ResponseMainFragmentViewPagerDatas.DataBean> datas) {
        super(context,datas);
        if(datas == null || datas.size() == 0){
            this.datas = new ArrayList<>();
        }else{
            this.datas = datas;
        }
        for (int i = 0; i < datas.size(); i++) {
            View view = mLayoutInflater.inflate(R.layout.viewpager_slide_image,null);
            view.setTag(view.findViewById(R.id.image_main_fragment_viewpager));
            mViews.add(view);
            view.findViewById(R.id.image_main_fragment_viewpager).setTag(i);
            view.setOnClickListener(this);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View  view = (View) mViews.get(position % datas.size());
        container.addView(view);
        SimpleDraweeView imageView = (SimpleDraweeView) view.getTag();
        imageView.setImageURI(Uri.parse(datas.get(position%mViews.size()).getImagesrc()));
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
