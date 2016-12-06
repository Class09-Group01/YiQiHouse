package com.bwf.aiyiqi.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.LoginActivity;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MessageFragment extends BaseFragment implements View.OnClickListener{

    private RelativeLayout relativeLayout_new_comment,relativeLayout_new_zan,relativeLayout_call_me,relativeLayout_System_notification;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_message;
    }
    public void init(){
        relativeLayout_new_comment = (RelativeLayout) getView().findViewById(R.id.relative_msg_mew_comment);
        relativeLayout_new_zan = (RelativeLayout) getView().findViewById(R.id.relative_msg_mew_zan);
        relativeLayout_call_me = (RelativeLayout) getView().findViewById(R.id.relative_msg_call_me);
        relativeLayout_System_notification = (RelativeLayout) getView().findViewById(R.id.relative_msg_system_notification);


        relativeLayout_new_comment.setOnClickListener(this);
        relativeLayout_new_zan.setOnClickListener(this);
        relativeLayout_call_me.setOnClickListener(this);
        relativeLayout_System_notification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//
//        switch (v.getId()){
//            case R.id.relative_msg_mew_comment :
//                break;
//        }
//        switch (v.getId()){
//            case R.id.relative_msg_mew_zan :
//                startActivity(new Intent(getActivity(),LoginActivity.class));
//                break;
//        }
//        switch (v.getId()){
//            case R.id.relative_msg_call_me :
//                startActivity(new Intent(getActivity(),LoginActivity.class));
//                break;
//        }
//        switch (v.getId()){
//            case R.id.relative_msg_system_notification :
//                startActivity(new Intent(getActivity(),LoginActivity.class));
//                break;
//        }
        startActivity(new Intent(getActivity(),LoginActivity.class));
    }
}
