package com.bwf.aiyiqi.gui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.LoginActivity;

/**
 * Created by Administrator on 2016/12/1.
 * 功能描述：
 * 作者：
 */

public class PopupWindowSay {
    private PopupWindow mPopupWindow;
    private Screen mScreen;
    private Context mContext;
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private LinearLayout linearLayout4;
    private RelativeLayout.LayoutParams layoutParams1,layoutParams2,layoutParams3,layoutParams4;



    private View view;
    private ImageButton mImageButton1,mImageButton2,mImageButton3,mImageButton4;

    public PopupWindowSay(Context context) {
        this.mContext = context;
    }

    public void showPopupWindow(Activity context, View v) {
        mScreen = new Screen(context);
        view = LayoutInflater.from(context).inflate(R.layout.popupwindow, null);
        init();
        int width=mScreen.getWidth();
        int height=mScreen.getHeight() - getStatusBarHeight();
        layoutParams1= (RelativeLayout.LayoutParams) linearLayout1.getLayoutParams();
        layoutParams1.setMargins(width/5,height/6,0,0);
        layoutParams2= (RelativeLayout.LayoutParams) linearLayout2.getLayoutParams();
        layoutParams2.setMargins(0,height/6,width/5,0);
        layoutParams3= (RelativeLayout.LayoutParams) linearLayout3.getLayoutParams();
        layoutParams3.setMargins(width/5,height/6*3,0,0);
        layoutParams4= (RelativeLayout.LayoutParams) linearLayout4.getLayoutParams();
        layoutParams4.setMargins(0,height/6*3,width/5,0);
        mPopupWindow = new PopupWindow(view, width,height , true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());//必须要有，如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        mPopupWindow.setTouchable(true);
        mPopupWindow.showAtLocation(v, Gravity.NO_GRAVITY, 0, getStatusBarHeight());
        inTo();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outTo();
            }
        });
        mImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                outTo();
                mHandler.sendEmptyMessageDelayed(0,700);
            }
        });
        mImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                outTo();
                mHandler.sendEmptyMessageDelayed(0,700);
            }
        });
        mImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                outTo();
                mHandler.sendEmptyMessageDelayed(0,700);
            }
        });
        mImageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                outTo();
                mHandler.sendEmptyMessageDelayed(0,600);
            }
        });

    }
    //获取状态栏的高度
    public int getStatusBarHeight() {
        int result = 0;
        //获取状态栏的ID
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //通过ID获取状态栏的高度
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void init() {
        linearLayout1 = (LinearLayout) view.findViewById(R.id.popupwindow_linearlayout1);
        linearLayout2 = (LinearLayout) view.findViewById(R.id.popupwindow_linearlayout2);
        linearLayout3 = (LinearLayout) view.findViewById(R.id.popupwindow_linearlayout3);
        linearLayout4 = (LinearLayout) view.findViewById(R.id.popupwindow_linearlayout4);
        mImageButton1 = (ImageButton) view.findViewById(R.id.create_feed_normal);
        mImageButton2 = (ImageButton) view.findViewById(R.id.show_order_normal);
        mImageButton3 = (ImageButton) view.findViewById(R.id.create_note_normal);
        mImageButton4 = (ImageButton) view.findViewById(R.id.create_complain_normal);
    }
    private void inTo() {
        AnimationSet animationSet1 = (AnimationSet) AnimationUtils.loadAnimation(mContext, R.anim.anim_1);
        linearLayout1.startAnimation(animationSet1);
        AnimationSet animationSet2 = (AnimationSet) AnimationUtils.loadAnimation(mContext, R.anim.anim_2);
        linearLayout2.startAnimation(animationSet2);
        AnimationSet animationSet3 = (AnimationSet) AnimationUtils.loadAnimation(mContext, R.anim.anim_3);
        linearLayout3.startAnimation(animationSet3);
        AnimationSet animationSet4 = (AnimationSet) AnimationUtils.loadAnimation(mContext, R.anim.anim_4);
        linearLayout4.startAnimation(animationSet4);
    }

    private void outTo() {
        Animation animationOut1 = (AnimationSet) AnimationUtils.loadAnimation(mContext, R.anim.outanim_1);
        linearLayout1.clearAnimation();
        linearLayout1.startAnimation(animationOut1);
        Animation animationOut2 = (AnimationSet) AnimationUtils.loadAnimation(mContext, R.anim.outanim_2);
        linearLayout2.clearAnimation();
        linearLayout2.startAnimation(animationOut2);
        Animation animationOut3 = (AnimationSet) AnimationUtils.loadAnimation(mContext, R.anim.outanim_3);
        linearLayout3.clearAnimation();
        linearLayout3.startAnimation(animationOut3);
        Animation animationOut4 = (AnimationSet) AnimationUtils.loadAnimation(mContext, R.anim.outanim_4);
        linearLayout4.clearAnimation();
        linearLayout4.startAnimation(animationOut4);

        animationOut2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mPopupWindow.setAnimationStyle(R.style.popwin_anim_style);
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                mPopupWindow.dismiss();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mContext.startActivity(new Intent(mContext, LoginActivity.class));
        }
    };

}
