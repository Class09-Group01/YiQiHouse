package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityListView;
import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityViewPager;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public interface DecorationCompanyActivityModel {
    void loadDatas(Callback callback);
    void loadViewPagerDatas(Callback callback);
    void loadListViewDatas(Callback callback);
    public interface Callback{
        void loadViewPagerDatasSuccess(ResponseDecorationCompanyActivityViewPager datas);
        void loadListViewDatasSuccess(ResponseDecorationCompanyActivityListView datas);
        void loadViewPagerDatasFailed();
        void loadListViewDatasFailed();
    }
}
