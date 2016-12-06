package com.bwf.aiyiqi.gui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;

/**
 * Created by Administrator on 2016/11/24.
 */

public class SmsLoginActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_smslogin;
    }

    @Override
    protected void initViews() {
        ImageView smslogin_balck;
        Button smslogin_code,smslogin_next;
        smslogin_balck = (ImageView) findViewById(R.id.activity_smslogin_image_black);
        smslogin_code = (Button)findViewById(R.id.activity_smslogin_bt_code);
        smslogin_next = (Button) findViewById(R.id.activity_smslogin_bt_next);

        smslogin_balck.setOnClickListener(this);
        smslogin_code.setOnClickListener(this);
        smslogin_next.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_smslogin_image_black:
                finish();
                break;
            case R.id.activity_smslogin_bt_code:
                Toast.makeText(this,"功能未开放",Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_smslogin_bt_next:
                Toast.makeText(this,"功能未开放",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
