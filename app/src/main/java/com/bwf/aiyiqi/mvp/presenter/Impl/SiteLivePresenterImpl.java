package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseSiteLiveComments;
import com.bwf.aiyiqi.entity.ResponseSiteLiveData;
import com.bwf.aiyiqi.mvp.model.Impl.SiteLiveModelImpl;
import com.bwf.aiyiqi.mvp.model.SiteLiveModel;
import com.bwf.aiyiqi.mvp.presenter.SiteLivePresenter;
import com.bwf.aiyiqi.mvp.view.SiteLiveView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/1.
 */

public class SiteLivePresenterImpl implements SiteLivePresenter{
    private SiteLiveView view;
    private SiteLiveModel model;
    private Map<String,String> mapPro;
    private Map<String,String> mapCom;
    private String comId = "1";
    private String proBuildingId = "0";
    private int page  = 1;

    public SiteLivePresenterImpl(SiteLiveView view) {
        this.model = new SiteLiveModelImpl();
        this.view = view;
        mapCom = new HashMap<>();
        mapPro = new HashMap<>();
    }

    /**
     * 默认的加载 第一页
     */
    private void setKeyValue(){
        mapCom.clear();
        mapPro.clear();
        //装修评论url的keyValue配置
        mapCom.put("progressId",comId);
        mapCom.put("app_version","android_com.aiyiqi.galaxy_1.1");
        mapCom.put("buildingId",proBuildingId);
        mapCom.put("page",page+"");
        mapCom.put("pageSize","10");

        //装修进度rl的keyValue配置
        mapPro.put("token","DAB088BA50C9405E84C789055D657614");
        mapPro.put("app_version","android_com.aiyiqi.galaxy_1.1");
        mapPro.put("buildingId",proBuildingId);
    }

    public void setId(String comId,String proBuildingId){
        this.comId = comId;
        this.proBuildingId = proBuildingId;
    }


    @Override
    public void loadSiteLivePresenter() {
        setKeyValue();

        model.loadData(mapPro, mapCom, new SiteLiveModel.Callback() {
            @Override
            public void progressDataFail() {
                view.showSiteProgressFail();
            }

            @Override
            public void progressDataSuccess(ResponseSiteLiveData data) {
                view.showSiteProgressDataSuccess(data);
            }

            @Override
            public void progressNoMoreData() {
                view.showSiteProgressNoMoreData();
            }

            @Override
            public void commentsDataFail() {
                view.showSiteCommentsFail();
            }

            @Override
            public void commentsDataSuccess(ResponseSiteLiveComments comments) {
                view.showSiteCommentsDataSuccess(comments);
                page++;
            }

            @Override
            public void commentsNoMoreData() {
                view.showSiteCommentsNoMoreData();
            }
        });
    }
}
