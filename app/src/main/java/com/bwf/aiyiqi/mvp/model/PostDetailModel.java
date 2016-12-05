package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponsePostCommunite;
import com.bwf.aiyiqi.entity.ResponsePostDetail;
import com.bwf.aiyiqi.entity.ResponsePostZan;

/**
 * Created by lingchen52 on 2016/11/30.
 */

public interface PostDetailModel {
    void loadPostDetailDatas(String tid,Callback callback);
    void loadPostZanDatas(String tid,Callback callback);
    void loadPostCommuniteDatas(String tid,int page,Callback callback);
    public interface Callback{
        void loadPostDetailDatasSuccess(ResponsePostDetail responsePostDetail);
        void loadPostZanDatasSuccess(ResponsePostZan responsePostZan);
        void loadPostCommuniteDatasSuccess(ResponsePostCommunite responsePostCommunite);
        void loadPostDetailDatasFailed();
        void loadPostZanDatasFailed();
        void loadPostCommuniteDatasFailed();
    }
}
