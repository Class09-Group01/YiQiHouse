package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSelfOrderDatas;
import com.bwf.aiyiqi.mvp.presenter.Impl.SelfOrderActivityPresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.SelfOrderActivityPresenter;
import com.bwf.aiyiqi.mvp.view.SelfOrderActivityView;

/**
 * Created by Administrator on 2016/11/25.
 */

public class SelfOrderActivity extends BaseActivity implements SelfOrderActivityView, View.OnClickListener {
    private TabLayout selfOder_TabLayout;
    private ViewPager selfOrder_ViewPager;
    private String[] selfOrder_titles;

    private RelativeLayout selfOrder_ensure;
    private ImageView selforder_black;

    @Override
    protected void initDatas() {
        SelfOrderActivityPresenter presenter = new SelfOrderActivityPresenterImpl(this);

    }

    @Override
    protected void initViews() {

        selfOder_TabLayout = (TabLayout) findViewById(R.id.activity_selforder_tablayout);
        for (int i = 0; i < selfOrder_titles.length; i++) {
            selfOder_TabLayout.addTab(selfOder_TabLayout.newTab()
                    .setText(selfOrder_titles[i]));
        }
        selfOrder_ensure = (RelativeLayout) findViewById(R.id.activity_selforder_ensure);
        selforder_black = (ImageView) findViewById(R.id.activity_selforder_black);

        selfOrder_ensure.setOnClickListener(this);
        selforder_black.setOnClickListener(this);


    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_self_order;
    }


    @Override
    public void loadDatasSuccess(ResponseSelfOrderDatas responseSelfOrderDatas) {

    }

    @Override
    public void loadDatasFeil() {

    }

    @Override
    public void loadNoMoreData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_selforder_black :
                finish();
                break;
//           case R.;
//                break;
        }
    }
}
