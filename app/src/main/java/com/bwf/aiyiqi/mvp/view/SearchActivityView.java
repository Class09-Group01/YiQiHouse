package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseSearchDatas;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface SearchActivityView {
    void showSearchDataSuccess(ResponseSearchDatas datas);
    void showSearchFail();
    void showNoMoreData();
}
