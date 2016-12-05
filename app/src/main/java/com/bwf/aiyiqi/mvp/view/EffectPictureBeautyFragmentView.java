package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseEffectctBeautyDatas;

/**
 * Created by Administrator on 2016/12/4.
 */

public interface EffectPictureBeautyFragmentView {
    void showEffectDataSuccess(ResponseEffectctBeautyDatas data);
    void showEffectFail();
    void showEffectNoMoreData();
}
