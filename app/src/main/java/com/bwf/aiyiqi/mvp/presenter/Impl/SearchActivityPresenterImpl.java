package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseSearchDatas;
import com.bwf.aiyiqi.mvp.model.Impl.SearchActivityModelIml;
import com.bwf.aiyiqi.mvp.model.SearchActivityModel;
import com.bwf.aiyiqi.mvp.presenter.SearchActivityPresenter;
import com.bwf.aiyiqi.mvp.view.SearchActivityView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */

public class SearchActivityPresenterImpl implements SearchActivityPresenter {
    //1- 将model 获取到的数据 --对象  通知给 view
        // model  view

    private SearchActivityModel model;
    private SearchActivityView view;
    private Map<String,String> map;
    private HashMap<String,String> myMap;
    private int page = 1;

    public SearchActivityPresenterImpl(SearchActivityView view) {
        this.view = view;
        model = new SearchActivityModelIml();
        map = new HashMap<>();
        myMap = new HashMap<>();
        map.put("a","searchForum");
        map.put("c","search");
        map.put("m","search");
        map.put("uuid","86305803367590");
        map.put("model","android");
        map.put("sessionToken","");
        map.put("app_version","android_com.aiyiqi.galaxy_1.1");
        map.put("haspermission","yes");
        map.put("pageSize","10");
    }

    private void setaMap(String searchText){
        myMap.clear();
        myMap.putAll(map);
        myMap.put("page",page+"");
        myMap.put("kw",searchText);
    }

    @Override
    public void loadSearchData(String searchText) {
        setaMap(searchText);
        model.loadData(myMap, new SearchActivityModel.Callback() {
            @Override
            public void loadDataSuccess(ResponseSearchDatas datas) {
                view.showSearchDataSuccess(datas);
            }

            @Override
            public void loadFail() {
                view.showSearchFail();
            }

            @Override
            public void loadNoMoreData() {
                view.showNoMoreData();
            }
        });
    }



}
