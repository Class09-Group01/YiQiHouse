package com.bwf.aiyiqi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/11/24.
 */

public class LoginActivity extends ActivityBase{


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
        Button login_bt_sms,login_bt_forgotPass,login_bt_loginOrRegister;
        login_bt_sms = (Button) findViewById(R.id.login_button_sms);
        login_bt_forgotPass = (Button) findViewById(R.id.login_button_ForgotPassword);
        login_bt_loginOrRegister = (Button) findViewById(R.id.login_button_loginOrRegister);

        login_bt_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SmsLoginActivity.class));
            }
        });

        login_bt_forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
            }
        });

        login_bt_loginOrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                return;
            }
        });


    }

    @Override
    protected void initDatas() {

    }
}
