package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseDecorateSchoolNews;
import com.bwf.aiyiqi.framwork.tool.UnicodeParser;
import com.bwf.aiyiqi.gui.adapter.DecorateSchoolAdapter;
import com.bwf.aiyiqi.gui.view.CustomRefreshLayout;
import com.bwf.aiyiqi.mvp.presenter.DecorateSchoolPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.DecorateSchoolPresenterImplr;
import com.bwf.aiyiqi.mvp.view.DecorateSchoolView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2016/11/24.
 * 功能描述：
 * 作者：
 */

public class DecorateSchoolListFragment extends BaseFragment implements DecorateSchoolView, DecorateSchoolAdapter.GetNewsStage {
    @BindView(R.id.decorateschool_recycleview)
    RecyclerView mDecorateschoolRecycleview;
    @BindView(R.id.decorateschool_refresh)
    CustomRefreshLayout mDecorateschoolRefresh;
    private DecorateSchoolPresenter mPresenter;
    private DecorateSchoolAdapter mAdapter;
    private int tagStage;
    private int newsStage = 1;
    private int lastNewsStage;
    private boolean isNoMoreData;
    private boolean isLoading;
    private LinearLayoutManager mLinearLayoutManager;
    //RecyclerView 滑动的时候当显示到为当前页的某一Item时自动加载下一页
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (isNoMoreData) {
                return;
            }
            if (!isLoading && mLinearLayoutManager.findLastVisibleItemPosition() == mLinearLayoutManager.getItemCount() - 1) {
                loadData();
            }
            if (mLinearLayoutManager.findFirstVisibleItemPosition() == 0) {
                mDecorateschoolRefresh.setCanPull(true);
            } else {
                mDecorateschoolRefresh.setCanPull(false);//设置后不拦截recycleview的滑动
            }
        }
    };

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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        loadData();
    }

    public void init() {
        mPresenter = new DecorateSchoolPresenterImplr(this);
        mAdapter = new DecorateSchoolAdapter(getActivity());
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDecorateschoolRecycleview.setLayoutManager(mLinearLayoutManager);
        mDecorateschoolRecycleview.setAdapter(mAdapter);
        mDecorateschoolRecycleview.addOnScrollListener(mOnScrollListener);
        mAdapter.getGetNewsStage(this);
        mDecorateschoolRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                mPresenter.loadDecorateSchoolTagPresenter(tagStage);
                mPresenter.loadDecorateSchoolNewsPresenter(newsStage, lastNewsStage);
            }
        });
    }

    public void loadData() {
        Bundle bundle = getArguments();
        tagStage = bundle.getInt("tagStage");
        mPresenter.loadDecorateSchoolTagPresenter(tagStage);
        mPresenter.loadDecorateSchoolNewsPresenter(newsStage, lastNewsStage);
        isLoading=true;
    }


    @Override
    public void showDecorateSchoolTagView(String str) {
        mDecorateschoolRefresh.finishRefresh();
        String decodeString = UnicodeParser.decodeUnicode(str);
        String data = decodeString.substring(33);
        String datas = data.replace("{", "");
        String lastDatas = datas.replace("}", "");
        Log.d("DecorateSchoolListFragm", lastDatas);
        List<String> listValue = stringToList(lastDatas);
        Log.d("DecorateSchoolListFragm", "list:" + listValue);
        mAdapter.setDatas(listValue);
        isLoading=false;


    }

    @Override
    public void showDecorateSchoolNewsView(ResponseDecorateSchoolNews decorateSchoolNews) {
        mDecorateschoolRefresh.finishRefresh();
        List<ResponseDecorateSchoolNews.DataBean.ListBean> listBeen = decorateSchoolNews.getData().getList();
        Log.d("DecorateSchoolListFragm", "newsStage:" + newsStage);
        Log.d("DecorateSchoolListFragm", "lastNewsStage:" + lastNewsStage);
        if (newsStage == lastNewsStage) {
            mAdapter.addData(listBeen);
        } else {
            mAdapter.addNewData(listBeen);
            lastNewsStage = newsStage;
        }
//        Toast.makeText(getActivity(), "listBeen:" + listBeen, Toast.LENGTH_SHORT).show();
        isLoading=false;
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

    public List<String> stringToList(String str) {
        List<String> listValue = new ArrayList<>();
        String[] datas = str.split(",");
        for (int i = 0; i < datas.length; i++) {
            listValue.add(datas[i].split(":")[1].replace("\"", ""));
        }
        return listValue;
    }


    @Override
    public void getNewsStage(View v) {
        newsStage = (int) v.getTag();
        if (newsStage == lastNewsStage) {
            return;
        } else {
            lastNewsStage = 0;
            mPresenter.loadDecorateSchoolNewsPresenter(newsStage, lastNewsStage);
        }

    }
}
