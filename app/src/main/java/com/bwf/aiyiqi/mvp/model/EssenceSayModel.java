package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.EssenceSay;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public interface EssenceSayModel {
    void loadEssenceSay(String url,CallBack callBack);
    public interface CallBack{
        void loadEssenceSaySuccess(List<EssenceSay.DataBean> dataBeen);
        void loadEssenceSayFailed();
    }
}
