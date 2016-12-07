package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseAutoOrder;
import com.bwf.aiyiqi.gui.adapter.AutoOrderRecycleViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/12/5.
 */

public class AutoOrderFragment extends BaseFragment {
    @BindView(R.id.gridview_auto_order)
    RecyclerView mGridviewAutoOrder;
    private static ResponseAutoOrder datas;
    private int tag;
    private AutoOrderRecycleViewAdapter mRecycleViewAdapter;

    public static AutoOrderFragment newInstant(int tag, ResponseAutoOrder data) {
        AutoOrderFragment fragment = new AutoOrderFragment();
        datas = data;
        Bundle bundle = new Bundle();
        bundle.putInt("tag", tag);
        fragment.setArguments(bundle);
        return fragment;
    }



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
        mRecycleViewAdapter = new AutoOrderRecycleViewAdapter(getContext(), tag);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        mGridviewAutoOrder.setLayoutManager(gridLayoutManager);
        mRecycleViewAdapter.setDatas(datas.getData());
        mGridviewAutoOrder.setAdapter(mRecycleViewAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
