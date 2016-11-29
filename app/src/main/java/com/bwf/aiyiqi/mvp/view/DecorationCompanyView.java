package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityListView;
import com.bwf.aiyiqi.entity.ResponseDecorationCompanyActivityViewPager;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public interface DecorationCompanyView {
    void showViewPager(ResponseDecorationCompanyActivityViewPager datas);
    void showListView(ResponseDecorationCompanyActivityListView datas);
    void showViewPagerFailed();
    void showListViewFailed();
}
