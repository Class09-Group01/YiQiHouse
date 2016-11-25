package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseDecorateSchoolNews;

/**
 * Created by Administrator on 2016/11/24.
 * 功能描述：
 * 作者：
 */

public interface DecorateSchoolModel {
    void loadTagDatas(int stage, TagCallBack mCallBack);
    void loadNewsDatas(int stage, int page, int pageSize, NewsCallBack mCallBack);
    public interface TagCallBack{
        void loadTagDatasSuccess(String str);
        void loadTagFailed();
    }
    public interface NewsCallBack{
        void loadNewsDatasSuccess(ResponseDecorateSchoolNews decorateSchoolNews);
        void loadNewsFailed();
    }
}
