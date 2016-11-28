package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseEffectPictrueSubjectDatas;

/**
 * Created by Administrator on 2016/11/27.
 */

public interface EffectPictureSubjectView {
    void showEffectPictureSubjectDataSuccess(ResponseEffectPictrueSubjectDatas datas);
    void showEffectPictureSubjectDataFail();
    void showNoMoreData();
}
