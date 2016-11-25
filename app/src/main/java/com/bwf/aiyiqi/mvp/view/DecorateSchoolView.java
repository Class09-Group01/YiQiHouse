package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseDecorateSchoolNews;

/**
 * Created by Administrator on 2016/11/24.
 * 功能描述：
 * 作者：
 */

public interface DecorateSchoolView {
    void showDecorateSchoolTagView(String str);
    void showDecorateSchoolNewsView(ResponseDecorateSchoolNews decorateSchoolNews);
    void showDataFailed();
}
