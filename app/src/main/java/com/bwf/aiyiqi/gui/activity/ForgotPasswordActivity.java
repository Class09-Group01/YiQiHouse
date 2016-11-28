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

public class ForgotPasswordActivity extends BaseActivity implements View.OnClickListener{

    ImageView forgotpass_black;
    Button forgotpass_code,forgotpass_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_forgotpassword;
    }

    @Override
    protected void initViews() {
        forgotpass_black = (ImageView) findViewById(R.id.activity_forgotpass_black);
        forgotpass_code = (Button) findViewById(R.id.activity_forgotpass_code);
        forgotpass_next = (Button) findViewById(R.id.activity_forgotpass_next);

        forgotpass_black.setOnClickListener(this);
        forgotpass_code.setOnClickListener(this);
        forgotpass_next.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_forgotpass_black:
                finish();
                break;
            case R.id.activity_forgotpass_code:
                Toast.makeText(this,"此功能暂未开放",Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_forgotpass_next:
                Toast.makeText(this,"此功能暂未开放",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
