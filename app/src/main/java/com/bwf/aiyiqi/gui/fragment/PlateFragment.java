package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.PlateSay;
import com.bwf.aiyiqi.gui.adapter.ChooseGridViewAdapter;
import com.bwf.aiyiqi.gui.adapter.ForunGridViewAdapter;
import com.bwf.aiyiqi.gui.adapter.HeatedDiscussionAdapter;
import com.bwf.aiyiqi.gui.view.GridViewCustom;
import com.bwf.aiyiqi.mvp.presenter.Impl.PlateSayPresenterImple;
import com.bwf.aiyiqi.mvp.presenter.PlateSayPresenter;
import com.bwf.aiyiqi.mvp.view.PlateSayView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class PlateFragment extends BaseFragment implements PlateSayView {
    @BindView(R.id.plate_fragment_firsttitle)
    TextView mPlateFragmentFirsttitle;
    @BindView(R.id.plate_fragment_firstgridview)
    GridViewCustom mPlateFragmentFirstgridview;
    @BindView(R.id.plate_fragment_secondetitle)
    TextView mPlateFragmentSecondetitle;
    @BindView(R.id.plate_fragment_secondegridview)
    GridViewCustom mPlateFragmentSecondegridview;
    @BindView(R.id.plate_fragment_thirdtitle)
    TextView mPlateFragmentThirdtitle;
    @BindView(R.id.plate_fragment_thirdgridview)
    GridViewCustom mPlateFragmentThirdgridview;
    @BindView(R.id.plate_fragment_linearlayout)
    LinearLayout mPlateFragmentLinearlayout;
    @BindView(R.id.plate_fragment_refresh)
    MaterialRefreshLayout mPlateFragmentRefresh;
    private PlateSayPresenter mPresenter;
    private ForunGridViewAdapter mForunGridViewAdapter;
    private ChooseGridViewAdapter mChooseGridViewAdapter;
    private HeatedDiscussionAdapter mHeatedDiscussionAdapter;
    private String cityName = "成都";
    private int cityId = 2;

    @Override
    protected int getContentViewResId() {
        return R.layout.platefragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        loadData();
    }

    public void init() {
        mPresenter = new PlateSayPresenterImple(this);
        mPlateFragmentFirsttitle.setText(getActivity().getString(R.string.plate_fragment_firsttitle, cityName));
        mForunGridViewAdapter = new ForunGridViewAdapter(getActivity());
        mPlateFragmentFirstgridview.setAdapter(mForunGridViewAdapter);
        mChooseGridViewAdapter = new ChooseGridViewAdapter(getActivity());
        mPlateFragmentSecondegridview.setAdapter(mChooseGridViewAdapter);
        mPlateFragmentRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loadData();
            }
        });
    }

    public void loadData() {
        mPresenter.loadPlateSayPresenter(cityName, cityId);
    }

    @Override
    public void showPlateSayView(List<List<PlateSay.DataBean>> dataBeen) {
        mPlateFragmentRefresh.finishRefresh();
        Toast.makeText(getActivity(), "dataBeen.size():" + dataBeen.size(), Toast.LENGTH_SHORT).show();
        Log.d("PlateFragment", dataBeen.get(0).get(0).getTitle());
        List<PlateSay.DataBean> dataBeen1 = dataBeen.get(0);
        List<PlateSay.DataBean> dataBeen2 = dataBeen.get(1);
        mForunGridViewAdapter.setData(dataBeen1);
        mChooseGridViewAdapter.setData(dataBeen2);
        if (dataBeen.size() < 3) {
            mPlateFragmentLinearlayout.setVisibility(View.GONE);
        } else {
            mHeatedDiscussionAdapter = new HeatedDiscussionAdapter(getActivity());
            mPlateFragmentThirdgridview.setAdapter(mHeatedDiscussionAdapter);
            List<PlateSay.DataBean> dataBeen3 = dataBeen.get(2);
            mHeatedDiscussionAdapter.setData(dataBeen3);
        }
    }

    @Override
    public void showViewFialed() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}
