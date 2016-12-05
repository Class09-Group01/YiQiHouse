package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseEffectctBeautyDatas;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/4.
 */

public interface EffectPictureBeautyFragmentModel {
    void loadDatas(Callback callback, HashMap<String,String> map);
    public interface Callback{
        void loadDataSuccess(ResponseEffectctBeautyDatas datas);
        void loadDataFailed();
        void loadNoMoreData();
    }
}
