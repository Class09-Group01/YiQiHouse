package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.EssenceSay;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public interface EssenceSayView {
    void showEssenceSayView(List<EssenceSay.DataBean> dataBeen);
    void showViewFialed();
}
