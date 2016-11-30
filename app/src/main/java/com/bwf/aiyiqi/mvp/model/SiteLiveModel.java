package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseSiteLiveComments;
import com.bwf.aiyiqi.entity.ResponseSiteLiveData;

import java.util.Map;

/**
 * Created by Administrator on 2016/11/29.
 */

public interface SiteLiveModel {
    void loadData(Map<String,String> mapPro,Map<String,String> mapCom, Callback callback);
    void loadProgressData(Map<String, String> mapPro);
    void loadComentsData(Map<String, String> mapCom);
    public interface Callback{
        void progressDataFail();
        void progressDataSuccess(ResponseSiteLiveData data);
        void progressNoMoreData();

        void commentsDataFail();
        void commentsDataSuccess(ResponseSiteLiveComments comments);
        void commentsNoMoreData();
    }
}
