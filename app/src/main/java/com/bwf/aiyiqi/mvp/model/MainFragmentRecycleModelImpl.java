package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseMainFragmentRecycleviewData;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/11/24.
 */

public interface MainFragmentRecycleModelImpl {
    void loadDatas(Callback callback, HashMap<String,String> map);
    public interface Callback{
        void loadDataSuccess(ResponseMainFragmentRecycleviewData datas);
        void loadDataFailed();
    }
}
