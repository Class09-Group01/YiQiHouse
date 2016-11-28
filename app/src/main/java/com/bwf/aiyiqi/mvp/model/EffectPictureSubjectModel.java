package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseEffectPictrueSubjectDatas;

/**
 * Created by Administrator on 2016/11/27.
 */

public interface EffectPictureSubjectModel {
    void loadDatas(String url,Callback callback);
    public interface Callback{
        void loadDataSuccess(ResponseEffectPictrueSubjectDatas datas);
        void loadDataFailed();
    }
}
