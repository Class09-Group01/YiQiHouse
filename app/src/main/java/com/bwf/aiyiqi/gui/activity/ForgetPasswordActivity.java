package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
public class ForgetPasswordActivity extends BaseActivity {
    @BindView(R.id.login_register_back)
    ImageView mLoginRegisterBack;
    @BindView(R.id.forget_password_identity)
    EditText mForgetPasswordIdentity;
    @BindView(R.id.forgetpassword_get_identifyingcode)
    EditText mForgetpasswordGetIdentifyingcode;
    @BindView(R.id.forget_password_identifyingcode_textview)
    TextView mForgetPasswordIdentifyingcodeTextview;
    @BindView(R.id.forgetpassword_agin_password)
    EditText mForgetpasswordAginPassword;
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
        return R.layout.forgetpassword;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_register_back, R.id.forget_password_identity, R.id.forgetpassword_get_identifyingcode, R.id.forget_password_identifyingcode_textview, R.id.forgetpassword_agin_password, R.id.login_register_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_register_back:
                finish();
                break;
            case R.id.forget_password_identity:
                break;
            case R.id.forgetpassword_get_identifyingcode:
                break;
            case R.id.forget_password_identifyingcode_textview:
                break;
            case R.id.forgetpassword_agin_password:
                break;
            case R.id.login_register_button:
                break;
        }
    }
}
