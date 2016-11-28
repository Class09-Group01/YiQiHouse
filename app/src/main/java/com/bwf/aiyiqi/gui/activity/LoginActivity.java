package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bwf.aiyiqi.R;

/**
 * Created by Administrator on 2016/11/24.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    Button login_bt_black,login_bt_sms,login_bt_forgotPass,login_bt_loginOrRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getContentViewResId();

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        login_bt_black = (Button) findViewById(R.id.activity_login_button_black);
        login_bt_sms = (Button) findViewById(R.id.activity_login_button_sms);
        login_bt_forgotPass = (Button) findViewById(R.id.activity_login_button_ForgotPassword);
        login_bt_loginOrRegister = (Button) findViewById(R.id.activity_login_button_loginOrRegister);

        login_bt_black.setOnClickListener(this);
        login_bt_sms.setOnClickListener(this);
        login_bt_forgotPass.setOnClickListener(this);
        login_bt_loginOrRegister.setOnClickListener(this);


    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_login_button_black:
                finish();
                break;
            case R.id.activity_login_button_sms:
                startActivity(new Intent(LoginActivity.this,SmsLoginActivity.class));
                break;
            case R.id.activity_login_button_ForgotPassword:
                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
                break;
            case R.id.activity_login_button_loginOrRegister:
//                Toast.makeText(this,"此功能暂未开放",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,ZiZhuXiaDanActivity.class));
                break;

        }
    }
}
