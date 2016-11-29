package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseSelfOrderDatas;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface SelfOrderActivityView {
    void loadDatasSuccess(ResponseSelfOrderDatas responseSelfOrderDatas);
    void loadDatasFeil();
    void loadNoMoreData();

}
