package com.bwf.aiyiqi.gui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSelfOrderDatas;
import com.bwf.aiyiqi.gui.adapter.SelfOrderPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class SelfOrderActivity extends BaseActivity implements SelfOrderActivityView, View.OnClickListener {
    private TabLayout selfOder_TabLayout;
    private ViewPager selfOrder_ViewPager;
    private List<String> selfOrder_list;
    private SelfOrderPagerAdapter selfOrderPagerAdapter;
    private RelativeLayout selfOrder_ensure;
    private ImageView selforder_black;



    @Override
    protected void initDatas() {
        SelfOrderActivityPresenterImpl presenter = new SelfOrderActivityPresenterImpl(this);
        selfOrderPagerAdapter = new SelfOrderPagerAdapter(getSupportFragmentManager());
        selfOrder_list = new ArrayList<>();
        presenter.loadSelfOrderDatas();

    }

    @Override
    protected void initViews() {
        selfOrder_ensure = (RelativeLayout) findViewById(R.id.activity_selforder_ensure);
        selforder_black = (ImageView) findViewById(R.id.activity_selforder_black);
        selfOder_TabLayout = (TabLayout) findViewById(R.id.activity_selforder_tablayout);
        selfOrder_ViewPager = (ViewPager) findViewById(R.id.activity_selforder_viewpager);

        selfOder_TabLayout.setupWithViewPager(selfOrder_ViewPager);
        selfOrder_ViewPager.setAdapter(selfOrderPagerAdapter);

        selfOrder_ensure.setOnClickListener(this);
        selforder_black.setOnClickListener(this);


    }
    @Override
    protected int getContentViewResId() {
        return R.layout.activity_self_order;
    }


    @Override
    public void loadDatasSuccess(ResponseSelfOrderDatas responseSelfOrderDatas) {
        List<ResponseSelfOrderDatas.DataBeanX> data = responseSelfOrderDatas.getData();
        for (int i = 0; i < data.size(); i++) {
            selfOrder_list.add(data.get(i).getName());

        }
        selfOrderPagerAdapter.addTab(selfOrder_list);
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
//          case R.;
//              break;
        }
    }
}
