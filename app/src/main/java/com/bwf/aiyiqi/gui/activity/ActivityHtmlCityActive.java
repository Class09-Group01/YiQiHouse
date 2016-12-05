package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwf.aiyiqi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/12/2.
 */

public class ActivityHtmlCityActive extends BaseActivity {
    @BindView(R.id.webview_city_active)
    WebView mWebviewCityActive;
    private WebSettings mWebSettings;
    @Override
    protected void initDatas() {
        String url = getIntent().getStringExtra("url");
        mWebSettings = mWebviewCityActive.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebviewCityActive.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWebviewCityActive.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        mWebviewCityActive.loadUrl(url);
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_html_city_active;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }
}
