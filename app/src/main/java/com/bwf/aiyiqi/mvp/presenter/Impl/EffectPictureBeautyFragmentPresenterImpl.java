package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseEffectctBeautyDatas;
import com.bwf.aiyiqi.mvp.model.EffectPictureBeautyFragmentModel;
import com.bwf.aiyiqi.mvp.model.Impl.EffectPictureBeautyFragmentModelImpl;
import com.bwf.aiyiqi.mvp.presenter.EffectPictureBeautyFragmentPresenter;
import com.bwf.aiyiqi.mvp.view.EffectPictureBeautyFragmentView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/4.
 */

public class EffectPictureBeautyFragmentPresenterImpl implements EffectPictureBeautyFragmentPresenter {
    private EffectPictureBeautyFragmentModelImpl model;
    private EffectPictureBeautyFragmentView view;
    private Map<String, String> map;
    private int page = 1;
    private int tagId = 0;

    public EffectPictureBeautyFragmentPresenterImpl(EffectPictureBeautyFragmentView view) {
        this.view = view;
        this.model = new EffectPictureBeautyFragmentModelImpl();
        map = new HashMap<>();
    }
//
//    public void setMap(){
//        map.clear();
//        map.put("version","1");
//        map.put("page",page+"");
//        map.put("pageSize","10");
//        map.put("action","imageList2");
//        map.put("tagid",tagId+"");
//        map.put("model","android");
//    }

    @Override
    public void loadEffectPictureData() {
//        setMap();
        model.loadDatas(new EffectPictureBeautyFragmentModel.Callback() {
            @Override
            public void loadDataSuccess(ResponseEffectctBeautyDatas datas) {
                view.showEffectDataSuccess(datas);
                page++;
            }
            @Override
            public void loadDataFailed() {
                view.showEffectFail();
            }
            @Override
            public void loadNoMoreData() {
                view.showEffectNoMoreData();
            }
        }, (HashMap<String, String>) map);
    }
}
