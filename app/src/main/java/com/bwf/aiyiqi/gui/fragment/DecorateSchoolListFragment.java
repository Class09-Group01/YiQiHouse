package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseDecorateSchoolNews;
import com.bwf.aiyiqi.framwork.tool.UnicodeParser;
import com.bwf.aiyiqi.gui.adapter.DecorateSchoolAdapter;
import com.bwf.aiyiqi.mvp.presenter.DecorateSchoolPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.DecorateSchoolPresenterImplr;
import com.bwf.aiyiqi.mvp.view.DecorateSchoolView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2016/11/24.
 * 功能描述：
 * 作者：
 */

public class DecorateSchoolListFragment extends BaseFragment implements DecorateSchoolView,DecorateSchoolAdapter.GetNewsStage{
    @BindView(R.id.decorateschool_recycleview)
    RecyclerView mDecorateschoolRecycleview;
    private DecorateSchoolPresenter mPresenter;
    private DecorateSchoolAdapter mAdapter;
    private int tagStage;
    private int newsStage=1;
    private int lastNewsStage;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected int getContentViewResId() {
        return R.layout.decorateschool_listfragment;
    }

    public static DecorateSchoolListFragment newInstance(int tagStage) {
        DecorateSchoolListFragment fragment = new DecorateSchoolListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tagStage", tagStage);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        loadData();
    }
    public void init() {
        mPresenter = new DecorateSchoolPresenterImplr(this);
        mAdapter=new DecorateSchoolAdapter(getActivity());
        mLinearLayoutManager=new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDecorateschoolRecycleview.setLayoutManager(mLinearLayoutManager);
        mDecorateschoolRecycleview.setAdapter(mAdapter);
        mAdapter.getGetNewsStage(this);
    }

    public void loadData() {
        Bundle bundle = getArguments();
        tagStage = bundle.getInt("tagStage");
        mPresenter.loadDecorateSchoolTagPresenter(tagStage);
        mPresenter.loadDecorateSchoolNewsPresenter(newsStage,lastNewsStage);
    }

    @Override
    public void showDecorateSchoolTagView(String str) {

        String decodeString =UnicodeParser.decodeUnicode(str);
        String data=decodeString.substring(33);
        String datas=data.replace("{","");
        String lastDatas=datas.replace("}","");
        List<String> list=stringToList(lastDatas);
        Log.d("DecorateSchoolListFragm", "list:" + list);
        mAdapter.setDatas(list);


    }

    @Override
    public void showDecorateSchoolNewsView(ResponseDecorateSchoolNews decorateSchoolNews) {
        List<ResponseDecorateSchoolNews.DataBean.ListBean> listBeen = decorateSchoolNews.getData().getList();
        if(lastNewsStage==newsStage){
            mAdapter.addData(listBeen);
        }else{
            mAdapter.addNewData(listBeen);
            lastNewsStage=newsStage;
        }
        Log.d("DecorateSchoolListFragm", "newsStage:" + newsStage);
        Log.d("DecorateSchoolListFragm", "lastNewsStage:" + lastNewsStage);
        Toast.makeText(getActivity(), "listBeen:" + listBeen, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showDataFailed() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    public List<String> stringToList(String str){
        List<String> listValue = new ArrayList<>();
        String[] datas = str.split(",");
        for (int i = 0; i < datas.length; i++) {
            listValue.add(datas[i].split(":")[1]);
        }
        return listValue;
    }
    public List<String> stringToKeyList(String str){
        List<String> listKey = new ArrayList<>();
        String[] datas = str.split(",");
        for (int i = 0; i < datas.length; i++) {
            listKey.add(datas[i].split(":")[0]);
        }
        return listKey;
    }


    @Override
    public void getNewsStage(View v) {
        newsStage= (int) v.getTag();
        mPresenter.loadDecorateSchoolNewsPresenter(newsStage,lastNewsStage);
    }
}
