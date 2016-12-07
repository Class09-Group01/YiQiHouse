package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;

import com.bwf.aiyiqi.R;

/**
 * Created by lingchen52 on 2016/12/7.
 */

public class LuncherActivity extends BaseActivity {
    @Override
    protected void initDatas() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(LuncherActivity.this,WelcomeActivty.class));
                finish();
            }
        }).start();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_luncher;
    }
}
