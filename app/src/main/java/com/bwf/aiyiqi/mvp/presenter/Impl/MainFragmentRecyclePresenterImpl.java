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
    private Map<String,String> myMap;

    private int page = 1;
    private int lastType;
    private String lastId;

    public MainFragmentRecyclePresenterImpl(MainFragmentRecycleView view) {
        this.model = new MainFragmentRecycleModel();
        this.view = view;
        map = new HashMap<>();
        myMap = new HashMap<>();
        myMap.put("a","appindex");
        myMap.put("c","index");
        myMap.put("uuid","86305803367590");
        myMap.put("uid","1633055");
        myMap.put("m","misc");
        myMap.put("haspermission","yes");
        myMap.put("model","android");
        myMap.put("sessionToken","6U49kCYKE260RqvPqEdFsBGskNQStKhm");
        myMap.put("app_version","android_com.aiyiqi.galaxy_1.1");

        //加载第一页时候的配置
        setMap(-1,"");
    }

    public void setMap(int lastType,String lastId){
        map.clear();
        map.putAll(myMap);
        map.put("page",page+"");
        if(page > 1){
            map.put("type",lastType+"");
            map.put("id",lastId);
            Log.d("MainFragmentRecyclePres", "lastId:"+lastId+"  lastType:"+lastType +"page:"+page);
        }else{
            map.put("type","3");
            map.put("id","1218226");
        }
    }

    public void loadReflresh(){
        page = 1;
        loadRecycleData();
    }


    @Override
    public void loadRecycleData() {
        Log.d("MainFragmentRecyclePres", "page:" + page);
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
