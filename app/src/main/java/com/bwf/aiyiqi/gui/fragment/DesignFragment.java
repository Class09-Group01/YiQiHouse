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
 * Created by lingchen52 on 2016/12/5.
 */

public class DesignFragment extends BaseFragment {

    @BindView(R.id.webview_design)
    WebView mWebviewDesign;
    private int tag;
    public static DesignFragment newInstant(int tag) {
        DesignFragment fragment = new DesignFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tag", tag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.layout_design_html;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initData() {
        Bundle bundle = getArguments();
        tag = bundle.getInt("tag");
        if(tag == 1){
            mWebviewDesign.loadUrl(APIs.API_FREE_DESIGN);
        }else if(tag == 2){
            mWebviewDesign.loadUrl(APIs.API_FREE_SIZE);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
