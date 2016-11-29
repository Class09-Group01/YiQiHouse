package com.bwf.aiyiqi.mvp.presenter.Impl;

import android.util.Log;

import com.bwf.aiyiqi.entity.ResponseMainFragmentRecycleviewData;
import com.bwf.aiyiqi.mvp.model.Impl.MainFragmentRecycleModel;
import com.bwf.aiyiqi.mvp.model.MainFragmentRecycleModelImpl;
import com.bwf.aiyiqi.mvp.presenter.MainFragmentRecyclePresenter;
import com.bwf.aiyiqi.mvp.view.MainFragmentRecycleView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainFragmentRecyclePresenterImpl implements MainFragmentRecyclePresenter {
    private MainFragmentRecycleModel model;
    private MainFragmentRecycleView view;
    private Map<String,String> map;

    private int page = 1;
    private int lastType;
    private String lastId;

    public MainFragmentRecyclePresenterImpl(MainFragmentRecycleView view) {
        this.model = new MainFragmentRecycleModel();
        this.view = view;
        map = new HashMap<>();
        map.put("page",page+"");
    }

    public void setMap(int lastType,String lastId){
        map.clear();
        map.put("page",page+"");
        if(page > 1){
            map.put("type",lastType+"");
            map.put("id",lastId);
            Log.d("MainFragmentRecyclePres", "lastId:"+lastId+"  lastType:"+lastType +"page:"+page);
        }
    }

    public void loadReflresh(){
        page = 1;
        loadRecycleData();
    }


    @Override
    public void loadRecycleData() {
        model.loadDatas(new MainFragmentRecycleModelImpl.Callback() {
            @Override
            public void loadDataSuccess(ResponseMainFragmentRecycleviewData datas) {
                view.showRecycleSuccess(datas);
                //最后一条的type 和 id
                //如果size 的大小为0 则说明没有数据了
                if(datas != null){
                    if(datas.getData().size() > 0){
                        lastType = datas.getData().get(datas.getData().size()-1).getType();
                        lastId = datas.getData().get(datas.getData().size()-1).getId();
                        setMap(lastType,lastId);
                    }else{
                        view.showRecycleNoMoreData();
                    }
                }
                page++;
            }

            @Override
            public void loadDataFailed() {
                view.showRecycleFail();
            }
        }, (HashMap<String, String>) map);
    }
}
