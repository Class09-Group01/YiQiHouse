package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.framwork.tool.APIs;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class DecorateBudgetFragmentOffer extends BaseFragment {
    @BindView(R.id.decoratebudget_fragment_webview)
    WebView mDecoratebudgetFragmentWebview;

    @Override
    protected int getContentViewResId() {
        return R.layout.decorates_budget_fragment;
    }

    public static DecorateBudgetFragmentOffer newInstance() {
        DecorateBudgetFragmentOffer budgetFragment = new DecorateBudgetFragmentOffer();
        return budgetFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDecoratebudgetFragmentWebview.getSettings().setJavaScriptEnabled(true);
        mDecoratebudgetFragmentWebview.loadUrl(APIs.DECORATEBUDGET_OFFER_URL);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
