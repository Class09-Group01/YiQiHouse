package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.SiteLiveListViewAdapter;
import com.bwf.aiyiqi.gui.adapter.SiteLiveViewpagerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/2.
 */
public class SiteLiveViewPagerActivity extends BaseActivity {

    @BindView(R.id.asv_viewpager)
    ViewPager asvViewpager;
    @BindView(R.id.asv_textpage)
    TextView asvTextpage;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_sitlive_viewpager;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        String urls = intent.getStringExtra("urls");

        if(TextUtils.isEmpty(urls)){
            Toast.makeText(this, "获取图片错误", Toast.LENGTH_SHORT).show();
            return;
        }
        final List<String> url = SiteLiveListViewAdapter.addUrls(urls);
        asvTextpage.setText((position+1)+"/"+url.size());

        SiteLiveViewpagerAdapter adapter = new SiteLiveViewpagerAdapter(this,url);
        asvViewpager.setAdapter(adapter);
        asvViewpager.setCurrentItem(position);
        //监听页面变化
        asvViewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                asvTextpage.setText((position+1)+"/"+url.size());
            }
        });
    }

    @Override
    protected void initDatas() {

    }

}
