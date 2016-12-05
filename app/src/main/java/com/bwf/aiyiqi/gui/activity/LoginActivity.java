package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bwf.aiyiqi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/5.
 * 功能描述：
 * 作者：
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.login_register_cancle)
    TextView mLoginRegisterCancle;
    @BindView(R.id.login_register_identity)
    EditText mLoginRegisterIdentity;
    @BindView(R.id.login_register_password)
    EditText mLoginRegisterPassword;
    @BindView(R.id.login_register_forget_password)
    TextView mLoginRegisterForgetPassword;
    @BindView(R.id.login_register_button)
    Button mLoginRegisterButton;

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.login_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_register_cancle, R.id.login_register_identity, R.id.login_register_password, R.id.login_register_forget_password, R.id.login_register_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_register_cancle:
                finish();
                break;
            case R.id.login_register_identity:
                break;
            case R.id.login_register_password:
                break;
            case R.id.login_register_forget_password:
                startActivity(new Intent(this,ForgetPasswordActivity.class));
                break;
            case R.id.login_register_button:
                break;
        }
    }
}
