package com.bwf.aiyiqi.gui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.EffectPictureFragmentPagerAdapter;
import com.bwf.aiyiqi.gui.fragment.EffectPictureBeautyFragment;
import com.bwf.aiyiqi.gui.fragment.EffectPictureSubjectFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class EffectPictureActivity extends BaseActivity {
    @BindView(R.id.activity_effect_picture_back)
    ImageView activityEffectPictureBack;
    @BindView(R.id.activity_effect_picture_tablayout)
    TabLayout activityEffectPictureTablayout;
    @BindView(R.id.activity_effect_picture_viewpager)
    ViewPager activityEffectPictureViewpager;
    private List<Fragment> fragments;
    private EffectPictureFragmentPagerAdapter mAdapter;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_effect_picture;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initDatas() {
        //获得要显示的fragment集合
        fragments = getFragments();
        //设置viewPager
        mAdapter = new EffectPictureFragmentPagerAdapter(getSupportFragmentManager());
        activityEffectPictureViewpager.setAdapter(mAdapter);
        mAdapter.setData(fragments);
        //将viewpager 和 tabLayout 绑定滑动
        activityEffectPictureTablayout.setupWithViewPager(activityEffectPictureViewpager);

    }


    public List<Fragment> getFragments(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new EffectPictureSubjectFragment());
        fragments.add(new EffectPictureBeautyFragment());
        return fragments;
    }

}
