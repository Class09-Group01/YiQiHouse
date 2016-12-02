package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.SiteLiveViewPagerActivity;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.BasePagerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */

public class SiteLiveViewpagerAdapter extends BasePagerAdapter<String> {

    public SiteLiveViewpagerAdapter(final Context context, List<String> datas) {
        super(context, datas);
        for (int i = 0; i < datas.size(); i++) {
            SimpleDraweeView view = (SimpleDraweeView)
                    mLayoutInflater.inflate(R.layout.activity_sitelive_viewpager_item,null);
            view.setImageURI(Uri.parse(datas.get(i)));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SiteLiveViewPagerActivity activity = (SiteLiveViewPagerActivity) context;
                    activity.finish();
                }
            });
            mViews.add(view);
        }
    }
}
