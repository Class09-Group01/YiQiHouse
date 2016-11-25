package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseCityActiveDatas;
import com.bwf.aiyiqi.gui.view.MyListView;
import com.bwf.aiyiqi.mvp.presenter.CityActivePresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.CityActivePresenterImpl;
import com.bwf.aiyiqi.mvp.view.CityActiveView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public class CityActiveActivity extends BaseActivity implements CityActiveView{
    @BindView(R.id.listview_city_active)
    MyListView mListviewCityActive;

    private CityActivePresenter mPresenter;

    @Override
    protected void initDatas() {
        mPresenter = new CityActivePresenterImpl(this);
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_city_active;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showListView(ResponseCityActiveDatas datas) {


    }

    @Override
    public void showLoadFailed() {

    }
}
