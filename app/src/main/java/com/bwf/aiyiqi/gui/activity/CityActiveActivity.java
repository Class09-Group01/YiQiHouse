package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseCityActiveDatas;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CityActiveListViewAdapter;
import com.bwf.aiyiqi.mvp.presenter.CityActivePresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.CityActivePresenterImpl;
import com.bwf.aiyiqi.mvp.view.CityActiveView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public class CityActiveActivity extends BaseActivity implements CityActiveView {
    @BindView(R.id.listview_city_active)
    ListView mListviewCityActive;
    @BindView(R.id.back_activity_decoration_company)
    ImageView mBackActivityDecorationCompany;
    @BindView(R.id.title)
    TextView mTitle;

    private CityActivePresenter mPresenter;
    private CityActiveListViewAdapter mViewAdapter;

    @Override
    protected void initDatas() {
        mPresenter = new CityActivePresenterImpl(this);
        mPresenter.load();
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mTitle.setText("同城活动");
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
    public void showListView(final ResponseCityActiveDatas datas) {
        mViewAdapter = new CityActiveListViewAdapter(this, datas);
        mListviewCityActive.setAdapter(mViewAdapter);
        mListviewCityActive.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = datas.getData().getForumlist().get(position).getUrls();
                if (url.equals("")) {
                    //跳转到团购会Activity
                    url = datas.getData().getForumlist().get(position).getGroupon_urls();
                    Intent intent = new Intent(CityActiveActivity.this, ActivityHtmlCityActive.class);
                    intent.putExtra("url", url);
                    startActivity(intent);

                } else {
                    //跳转到H5页面，并传入url
                    Intent intent = new Intent(CityActiveActivity.this, ActivityHtmlCityActive.class);
                    intent.putExtra("url", url);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void showLoadFailed() {

    }

    @OnClick(R.id.back_activity_decoration_company)
    public void onClick() {
        finish();
        return;
    }
}
