package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseMainFragmentRecycleviewData;

/**
 * Created by Administrator on 2016/11/24.
 */

public interface MainFragmentRecycleView {
    void showRecycleSuccess(ResponseMainFragmentRecycleviewData data);
    void showRecycleFail();
    void showRecycleNoMoreData();
}
