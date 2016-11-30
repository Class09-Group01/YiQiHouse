package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponsePostCommunite;
import com.bwf.aiyiqi.entity.ResponsePostDetail;
import com.bwf.aiyiqi.entity.ResponsePostZan;

/**
 * Created by lingchen52 on 2016/11/30.
 */

public interface PostView {
    void showPostDetail(ResponsePostDetail postDetail);
    void showPostZan(ResponsePostZan postZan);
    void showPostCommunite(ResponsePostCommunite postCommunite);
    void showPostDetailFailed();
    void showPostZanFailed();
    void showPostCommuniteFailed();
}
