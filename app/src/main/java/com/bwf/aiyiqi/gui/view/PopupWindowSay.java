package com.bwf.aiyiqi.gui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bwf.aiyiqi.R;

/**
 * Created by Administrator on 2016/12/1.
 * 功能描述：
 * 作者：
 */

public class PopupWindowSay {
    private PopupWindow mPopupWindow;
    private Screen mScreen;
    private Context mContext;
    private  LinearLayout linearLayout1;
    private  LinearLayout linearLayout2;
    private  LinearLayout linearLayout3;
    private  LinearLayout linearLayout4;
    private View view;
    private ImageButton mImageButton;
    private ImageView mView;

    public PopupWindowSay(Context context) {
        this.mContext = context;
    }
    public void showPopupWindow(Activity context, View v) {
        mScreen = new Screen(context);
        view = LayoutInflater.from(context).inflate(R.layout.popupwindow, null);
        init();
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "你好", Toast.LENGTH_SHORT).show();
            }
        });
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "hhhhafdf", Toast.LENGTH_SHORT).show();
            }
        });
        mPopupWindow = new PopupWindow(view, mScreen.getWidth(), mScreen.getHeight() - getStatusBarHeight(), true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());//必须要有，如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
       mPopupWindow.setTouchable(true);
        mPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (mPopupWindow != null && mPopupWindow.isShowing()) {
//                    outTo();
//                    mPopupWindow.dismiss();
//
//                    mPopupWindow = null;
//                }
                return false;
            }
        });
        mPopupWindow.showAtLocation(v, Gravity.NO_GRAVITY, 0, getStatusBarHeight());
        inTo();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    private void init(){
        linearLayout1= (LinearLayout) view.findViewById(R.id.popupwindow_linearlayout1);
        linearLayout2= (LinearLayout) view.findViewById(R.id.popupwindow_linearlayout2);
        linearLayout3= (LinearLayout) view.findViewById(R.id.popupwindow_linearlayout3);
        linearLayout4= (LinearLayout) view.findViewById(R.id.popupwindow_linearlayout4);
        mImageButton= (ImageButton) view.findViewById(R.id.create_feed_normal);
        mView= (ImageView) view.findViewById(R.id.show_order_normal);


    }
    private void inTo(){
        AnimationSet animationSet1= (AnimationSet) AnimationUtils.loadAnimation(mContext,R.anim.anim_1);
        linearLayout1.startAnimation(animationSet1);
        AnimationSet animationSet2= (AnimationSet) AnimationUtils.loadAnimation(mContext,R.anim.anim_2);
        linearLayout2.startAnimation(animationSet2);
        AnimationSet animationSet3= (AnimationSet) AnimationUtils.loadAnimation(mContext,R.anim.anim_3);
        linearLayout3.startAnimation(animationSet3);
        AnimationSet animationSet4= (AnimationSet) AnimationUtils.loadAnimation(mContext,R.anim.anim_4);
        linearLayout4.startAnimation(animationSet4);
    }
    private void outTo(){
        AnimationSet animationSet1= (AnimationSet) AnimationUtils.loadAnimation(mContext,R.anim.outanim_1);
        linearLayout1.startAnimation(animationSet1);
        AnimationSet animationSet2= (AnimationSet) AnimationUtils.loadAnimation(mContext,R.anim.outanim_2);
        linearLayout2.startAnimation(animationSet2);
        AnimationSet animationSet3= (AnimationSet) AnimationUtils.loadAnimation(mContext,R.anim.outanim_3);
        linearLayout3.startAnimation(animationSet3);
        AnimationSet animationSet4= (AnimationSet) AnimationUtils.loadAnimation(mContext,R.anim.outanim_4);
        linearLayout4.startAnimation(animationSet4);
    }
}
