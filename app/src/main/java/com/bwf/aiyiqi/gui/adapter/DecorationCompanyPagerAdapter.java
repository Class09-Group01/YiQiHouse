package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityViewPager;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.BasePagerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingchen52 on 2016/11/28.
 */

public class DecorationCompanyPagerAdapter extends BasePagerAdapter {
    private List<ResponseDecorationCompanyActivityViewPager.DataBean> datas;

    public DecorationCompanyPagerAdapter(Context context, List<ResponseDecorationCompanyActivityViewPager.DataBean> datas) {
        super(context, datas);
        if (this.datas == null) {
            this.datas = new ArrayList<>();
        }
        if (datas.size() <= 2) {
            this.datas.addAll(datas);
            this.datas.addAll(datas);
        }
        this.datas.addAll(datas);
        for (int i = 0; i < this.datas.size(); i++) {
            View view = mLayoutInflater.inflate(R.layout.viewpager_slide_image, null);
            view.setTag(view.findViewById(R.id.image_main_fragment_viewpager));
            mViews.add(view);
            view.findViewById(R.id.image_main_fragment_viewpager).setTag(i);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = (View) mViews.get(position % datas.size());
        container.addView(view);
        SimpleDraweeView imageView = (SimpleDraweeView) view.getTag();
        imageView.setImageURI(Uri.parse(datas.get(position % mViews.size()).getImagesrc()));
        return view;
    }
}
