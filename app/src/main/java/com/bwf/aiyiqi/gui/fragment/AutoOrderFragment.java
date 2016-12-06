package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseAutoOrder;
import com.bwf.aiyiqi.gui.adapter.AutoOrderGridviewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/12/5.
 */

public class AutoOrderFragment extends BaseFragment {
    private  ResponseAutoOrder datas ;
    private int tag;
    private AutoOrderGridviewAdapter adapter;
    public  AutoOrderFragment(int tag, ResponseAutoOrder data){
        this.datas = data;
        Bundle bundle = new Bundle();
        bundle.putInt("tag",tag);
        this.setArguments(bundle);
    }

    @BindView(R.id.gridview_auto_order)
    GridView mGridviewAutoOrder;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_auto_order;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
    }

    private void initDatas() {
        Bundle bundle = getArguments();
        tag = bundle.getInt("tag");
        adapter = new AutoOrderGridviewAdapter(getContext(),tag);
        adapter.setDatas(datas.getData());
        mGridviewAutoOrder.setAdapter(adapter);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
