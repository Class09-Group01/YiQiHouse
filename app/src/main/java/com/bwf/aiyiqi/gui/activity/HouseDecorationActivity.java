package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.framwork.tool.APIs;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public class HouseDecorationActivity extends BaseActivity {

    @BindView(R.id.back_activity_decoration_company)
    ImageView mBackActivityDecorationCompany;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.webview)
    WebView mWebview;

    private TextView mTextView;
    private WebSettings

            mWebSettings;

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.d("HouseDecorationActivity", url);
        mWebSettings = mWebview.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        if(url.equals(APIs.API_NEW_HOUSE_DECORATION)){
            mTitle.setText("新房整装");
        }else{
            mTitle.setText("老房整装");
        }
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWebview.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        mWebview.loadUrl(url);
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
//        mTextView = (TextView) findViewById(R.id.text_new);
//        mTextView.setText(R.string.new_house_decoration);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_house_decoration;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation


    }

    @OnClick(R.id.back_activity_decoration_company)
    public void onClick() {
        finish();
        return;
    }
}
