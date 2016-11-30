package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.RecenterSay;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public interface RecenterSayModel {
    void loadRecenterSay(String url, CallBack callBack);
    public interface CallBack{
        void loadRecenterSaySuccess(List<RecenterSay.DataBean> dataBeen);
        void loadRecenterSayFailed();
    }
}
