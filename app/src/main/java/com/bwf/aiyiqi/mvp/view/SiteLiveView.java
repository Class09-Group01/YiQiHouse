package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseSiteLiveComments;
import com.bwf.aiyiqi.entity.ResponseSiteLiveData;

/**
 * Created by Administrator on 2016/12/1.
 */

public interface SiteLiveView {
    void showSiteProgressDataSuccess(ResponseSiteLiveData data);
    void showSiteProgressFail();
    void showSiteProgressNoMoreData();

    void showSiteCommentsDataSuccess(ResponseSiteLiveComments data);
    void showSiteCommentsFail();
    void showSiteCommentsNoMoreData();

}
