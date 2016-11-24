package com.bwf.aiyiqi;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/11/24.
 */

public class SmsLoginActivity extends ActivityBase {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getContentViewResId();
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_smslogin;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
