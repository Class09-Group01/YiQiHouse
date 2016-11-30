package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.DecorateBudgetAdaper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class DecorateBudgetActivity extends BaseActivity {

    @BindView(R.id.decoratebudget_backimage)
    ImageView mDecoratebudgetBackimage;
    @BindView(R.id.decoratebudget_tablayout)
    TabLayout mDecoratebudgetTablayout;
    @BindView(R.id.decoratebudget_viewpager)
    ViewPager mDecoratebudgetViewpager;
    private DecorateBudgetAdaper mAdaper;

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mDecoratebudgetTablayout.setupWithViewPager(mDecoratebudgetViewpager);
        mAdaper = new DecorateBudgetAdaper(getSupportFragmentManager());
        mDecoratebudgetViewpager.setAdapter(mAdaper);
        mDecoratebudgetBackimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.decorates_budget;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

}
