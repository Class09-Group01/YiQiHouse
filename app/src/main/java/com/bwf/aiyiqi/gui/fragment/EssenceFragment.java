package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.EssenceSay;
import com.bwf.aiyiqi.gui.adapter.EssenceFragmentAdapter;
import com.bwf.aiyiqi.mvp.presenter.EssenceSayPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.EssenceSayPresenterImple;
import com.bwf.aiyiqi.mvp.view.EssenceSayView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class EssenceFragment extends BaseFragment implements EssenceSayView{
    @BindView(R.id.essence_fragmenat_recycleview)
    RecyclerView mEssenceFragmenatRecycleview;
    private LinearLayoutManager mLayoutManager;
    private EssenceFragmentAdapter mAdapter;
    private EssenceSayPresenter mPresenter;

    @Override
    protected int getContentViewResId() {
        return R.layout.essencefragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        loadData();
    }
    public void init(){
        mPresenter=new EssenceSayPresenterImple(this);
        mLayoutManager=new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mEssenceFragmenatRecycleview.setLayoutManager(mLayoutManager);
        mAdapter=new EssenceFragmentAdapter(getActivity());
        mEssenceFragmenatRecycleview.setAdapter(mAdapter);
    }
    public void loadData(){
        mPresenter.loadEssenceSayPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showEssenceSayView(List<EssenceSay.DataBean> dataBeen) {
        Toast.makeText(getActivity(), dataBeen.get(0).getSubject(), Toast.LENGTH_SHORT).show();
        mAdapter.addData(dataBeen);

    }

    @Override
    public void showViewFialed() {

    }
}
