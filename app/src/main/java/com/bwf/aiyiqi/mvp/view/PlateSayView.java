package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.PlateSay;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public interface PlateSayView {
    void showPlateSayView(List<List<PlateSay.DataBean>> dataBeen);
    void showViewFialed();
}
