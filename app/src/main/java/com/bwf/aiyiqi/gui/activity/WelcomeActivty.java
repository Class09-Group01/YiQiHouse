package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.framwork.tool.SharedPrefenceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/24.
 */

public class WelcomeActivty extends BaseActivity {
    @BindView(R.id.plan)
    RadioButton plan;
    @BindView(R.id.this_year)
    TextView thisYear;
    @BindView(R.id.ming_year)
    TextView mingYear;
    @BindView(R.id.hou_year)
    TextView houYear;

    @Override
    protected int getContentViewResId() {
        if(SharedPrefenceUtils.getBoolean(this,"agin")){
            startActivity(new Intent(this,MainActivity.class));
        }
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initDatas() {

    }

    @OnClick({R.id.cancel, R.id.welcome_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                SharedPrefenceUtils.setBoolean(this,"agin",true);
                break;
            case R.id.welcome_btn:
                SharedPrefenceUtils.setBoolean(this,"agin",false);
                break;
        }
        startActivity(new Intent(this,MainActivity.class));
    }


}
