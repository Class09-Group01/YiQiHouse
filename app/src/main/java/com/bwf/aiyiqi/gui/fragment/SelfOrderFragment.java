package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSelfOrderDatas;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class SelfOrderFragment extends Fragment implements SelfOrderActivityView{
    private List<Fragment> fragments;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getContentViewResId(),null);

    }

    protected int getContentViewResId() {
        return R.layout.activity_self_order;
    }


    public SelfOrderFragment getFragment(){
        SelfOrderFragment selfOrderFragment=new SelfOrderFragment();
        return selfOrderFragment;
    }


    @Override
    public void loadDatasSuccess(ResponseSelfOrderDatas responseSelfOrderDatas) {
        List<ResponseSelfOrderDatas.DataBeanX> dataBeanXList = responseSelfOrderDatas.getData();
        for (int i = 0; i < dataBeanXList.size(); i++) {

        }
    }

    @Override
    public void loadDatasFeil() {

    }

    @Override
    public void loadNoMoreData() {

    }
}

