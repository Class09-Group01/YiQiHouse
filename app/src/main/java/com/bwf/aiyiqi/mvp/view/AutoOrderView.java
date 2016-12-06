package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseAutoOrder;

/**
 * Created by lingchen52 on 2016/12/5.
 */

public interface AutoOrderView {
    void showGridview(ResponseAutoOrder datas);
    void showLoadFailed();
}
