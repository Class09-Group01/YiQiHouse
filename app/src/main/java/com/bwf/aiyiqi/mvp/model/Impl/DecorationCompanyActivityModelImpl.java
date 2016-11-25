package com.bwf.aiyiqi.mvp.model.Impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityListView;
import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityViewPager;
import com.bwf.aiyiqi.framwork.tool.APIs;
import com.bwf.aiyiqi.mvp.model.DecorationCompanyActivityModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * 装修公司Activity的ViewPager和ListView的数据获取
 * Created by lingchen52 on 2016/11/25.
 */

public class DecorationCompanyActivityModelImpl implements DecorationCompanyActivityModel {
    @Override
    public void loadDatas(Callback callback) {
        loadViewPagerDatas(callback);
        loadListViewDatas(callback);
    }

    @Override
    public void loadViewPagerDatas(final Callback callback) {
        OkHttpUtils.get()
                .url(APIs.API_DECORATION_COMPANY_ACTIVITY_VIEWPAGER)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadViewPagerDatasFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("DecorationCompanyActivi", "loadViewPagerDatas"+response);
                        ResponseDecorationCompanyActivityViewPager companyActivityViewPager =
                                JSON.parseObject(response,ResponseDecorationCompanyActivityViewPager.class);
                        if(companyActivityViewPager.getError() == 0){
                            callback.loadViewPagerDatasSuccess(companyActivityViewPager);
                        }
                    }
                });
    }

    @Override
    public void loadListViewDatas(final Callback callback) {
        OkHttpUtils.get()
                .url(APIs.API_DECORATION_COMPANY_ACTIVITY_LISTVIEW)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadListViewDatasFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("DecorationCompanyActivi", "loadListViewDatas"+response);
                        ResponseDecorationCompanyActivityListView decorationCompanyActivityListView =
                                JSON.parseObject(response,ResponseDecorationCompanyActivityListView.class);
                        if (decorationCompanyActivityListView.getBaseOutput().getCode() == 0){
                            callback.loadListViewDatasSuccess(decorationCompanyActivityListView);
                        }

                    }
                });
    }
}
