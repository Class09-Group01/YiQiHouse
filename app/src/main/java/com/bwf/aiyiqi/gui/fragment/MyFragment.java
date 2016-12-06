package com.bwf.aiyiqi.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.IntegralRulesActivity;
import com.bwf.aiyiqi.gui.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.fragment_my_jifen)
    LinearLayout fragmentMyJifen;
    @BindView(R.id.fragment_my_dianji)
    RelativeLayout fragmentMyDianji;
    @BindView(R.id.fragment_my_new)
    LinearLayout fragmentMyNew;
    @BindView(R.id.fragment_my_attention)
    LinearLayout fragmentMyAttention;
    @BindView(R.id.fragment_my_fan)
    LinearLayout fragmentMyFan;
    @BindView(R.id.fragment_my_collect)
    RelativeLayout fragmentMyCollect;
    @BindView(R.id.fragment_my_like)
    RelativeLayout fragmentMyLike;
    @BindView(R.id.fragment_my_setting)
    RelativeLayout fragmentMySetting;
    @BindView(R.id.fragment_my_feedback)
    RelativeLayout fragmentMyFeedback;
    @BindView(R.id.fragment_my_order)
    LinearLayout fragmentMyOrder;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_my;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.fragment_my_jifen, R.id.fragment_my_dianji, R.id.fragment_my_new, R.id.fragment_my_attention, R.id.fragment_my_fan, R.id.fragment_my_collect, R.id.fragment_my_like, R.id.fragment_my_setting, R.id.fragment_my_feedback, R.id.fragment_my_order})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_my_jifen:
                startActivity(new Intent(getActivity(), IntegralRulesActivity.class));
                break;
            case R.id.fragment_my_dianji:
            case R.id.fragment_my_new:
            case R.id.fragment_my_attention:
            case R.id.fragment_my_fan:
            case R.id.fragment_my_collect:
            case R.id.fragment_my_like:
            case R.id.fragment_my_setting:
            case R.id.fragment_my_feedback:
            case R.id.fragment_my_order:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }
}
