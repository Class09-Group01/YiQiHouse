package com.bwf.aiyiqi.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainFragmentRecycleviewData;
import com.bwf.aiyiqi.gui.activity.SearchActivity;
import com.bwf.aiyiqi.gui.adapter.MainFragmentRecycleAdapter;
import com.bwf.aiyiqi.gui.view.PopupWindowCustom;
import com.bwf.aiyiqi.gui.view.ScrollViewCustom;
import com.bwf.aiyiqi.mvp.presenter.Impl.MainFragmentRecyclePresenterImpl;
import com.bwf.aiyiqi.mvp.view.MainFragmentRecycleView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/23.
 */

public class HomeFragment extends BaseFragment implements ScrollViewCustom.OnMyScrollChangedListener, MainFragmentRecycleView {
    @BindView(R.id.fragment_home_title_bar_scan)
    ImageView fragmentHomeTitleBarScan;
    @BindView(R.id.fragment_home_title_bar_search)
    RelativeLayout fragmentHomeTitleBarSearch;
    @BindView(R.id.fragment_home_title_bar_city)
    LinearLayout fragmentHomeTitleBarCity;
    @BindView(R.id.home_fragment_scrollview)
    ScrollViewCustom homeFragmentScrollview;
    @BindView(R.id.activity_home_recycleview)
    RecyclerView activityHomeRecycleview;
    @BindView(R.id.reflush)
    MaterialRefreshLayout reflush;
    private MainFragmentRecyclePresenterImpl mPresenter;
    private MainFragmentRecycleAdapter mAdapter;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = new MainFragmentRecyclePresenterImpl(this);
        mAdapter = new MainFragmentRecycleAdapter(getActivity());

        //设置Recycle的manager为数值方向的
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        activityHomeRecycleview.setLayoutManager(manager);

        activityHomeRecycleview.setAdapter(mAdapter);
        reflush.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                mPresenter.loadRecycleData();
            }
        });

        //弹出城市选择
        fragmentHomeTitleBarCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PopupWindowCustom().initPopupWindow(getActivity(),view);
                // 这里是位置显示方式,在屏幕的左侧
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.fragment_home_title_bar_scan, R.id.fragment_home_title_bar_search, R.id.fragment_home_title_bar_city})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_title_bar_scan:
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 100);
                break;
            case R.id.fragment_home_title_bar_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.fragment_home_title_bar_city:
                break;
        }
    }

    /**
     * 二维码扫描结果
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (data != null) {
                Bundle extras = data.getExtras();
                if (extras == null) return;
                if (extras.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    Toast.makeText(getActivity(), "扫描成功：" + extras.getString(CodeUtils.RESULT_STRING), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "扫描失败：", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    /**
     * 自定义scrollview 滑动改变监听
     *
     * @param x
     * @param y
     * @param oldX
     * @param oldY
     */
    @Override
    public void onMyScrollChanged(int x, int y, int oldX, int oldY) {

    }

    @Override
    public void showRecycleSuccess(ResponseMainFragmentRecycleviewData data) {
        Toast.makeText(getActivity(), "data.getData().size():" + data.getData().size(), Toast.LENGTH_SHORT).show();
        mAdapter.addData(data.getData());
        reflush.finishRefresh();
    }

    @Override
    public void showRecycleFail() {
        Toast.makeText(getActivity(), "OnError", Toast.LENGTH_SHORT).show();
        reflush.finishRefresh();
    }

    @Override
    public void showRecycleNoMoreData() {
        Toast.makeText(getActivity(), "nodate", Toast.LENGTH_SHORT).show();
        reflush.finishRefresh();
    }
}
