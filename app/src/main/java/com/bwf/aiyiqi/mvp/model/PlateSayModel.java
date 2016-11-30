package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.PlateSay;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public interface PlateSayModel {
    void loadPlateSay(String url, String cityName, int cityId, CallBack callBack);
    public interface CallBack{
        void loadPlateSaySuccess( List<List<PlateSay.DataBean>> dataBeen);
        void loadPlateSayFailed();
    }
}
