package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    @BindView(R.id.radio_group_sex)
    RadioGroup radioGroupSex;
    @BindView(R.id.radio_group_dec)
    RadioGroup radioGroupDec;
    @BindView(R.id.radio_group_year)
    RadioGroup radioGroupYear;
    @BindView(R.id.welcome_btn)
    Button welcomeBtn;

    @Override
    protected int getContentViewResId() {
        if (SharedPrefenceUtils.getBoolean(this, "agin") == false) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
    }

    private int yearCheck = -1;
    private boolean sexChecked;
    private boolean decChecked;

    @Override
    protected void initDatas() {
        radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setSexEnable(checkedId);
            }
        });

        radioGroupDec.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setDecEnable(checkedId);

                if (checkedId == R.id.plan) {
                    if(yearCheck == -1){
                        yearCheck = R.id.this_year;
                    }
                    radioGroupYear.check(yearCheck);
                    return;
                }
                radioGroupYear.clearCheck();
                yearCheck = -1;
            }
        });
        radioGroupYear.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && checkedId != yearCheck) {
                    yearCheck = checkedId;
                    plan.setChecked(true);
                }
            }
        });
    }

    @OnClick({R.id.cancel, R.id.welcome_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                SharedPrefenceUtils.setBoolean(this, "agin", true);
                finish();
                break;
            case R.id.welcome_btn:
                SharedPrefenceUtils.setBoolean(this, "agin", false);
                finish();
                break;
        }
        startActivity(new Intent(this, MainActivity.class));
    }

    public void setDecEnable(int checkedId){
        if (checkedId != -1) {
            decChecked = true;
            if (sexChecked) {
                welcomeBtn.setEnabled(true);
            }
        } else {
            decChecked = false;
            welcomeBtn.setEnabled(true);
            welcomeBtn.setAlpha(1);
        }
    }

    public void setSexEnable(int checkedId){
        if (checkedId != -1) {
            sexChecked = true;
            if (decChecked) {
                welcomeBtn.setEnabled(true);
            }
        } else {
            sexChecked = false;
            welcomeBtn.setEnabled(true);
            welcomeBtn.setAlpha(1);
        }
    }
}
