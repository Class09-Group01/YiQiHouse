package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseYiQiGroup;

/**
 * Created by lingchen52 on 2016/11/28.
 */

public interface YiQiGroupView {
    void showGridView(ResponseYiQiGroup datas);
    void showLoadFailed();
}
