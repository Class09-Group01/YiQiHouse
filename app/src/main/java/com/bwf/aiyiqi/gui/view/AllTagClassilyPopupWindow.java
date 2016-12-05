package com.bwf.aiyiqi.gui.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwf.aiyiqi.R;

/**
 * Created by Administrator on 2016/12/2.
 * 功能描述：
 * 作者：
 */

public class AllTagClassilyPopupWindow {
    private TextView mAllTagClassifyText;
    private GridViewCustom mAllTagClassifyGridview1;
    private GridViewCustom mAllTagClassifyGridview2;
    private GridViewCustom mAllTagClassifyGridview3;
    private PopupWindow mPopupWindow;
    private Screen mScreen;
    private Context mContext;
    private View mView;

    public AllTagClassilyPopupWindow(Context context) {
        mContext = context;
    }

    public void showTagPopupWindow(Activity context, View v) {
        mScreen = new Screen(context);
        mView = LayoutInflater.from(mContext).inflate(R.layout.all_tag_classify, null);
        int width=mScreen.getWidth();
        int height=mScreen.getHeight() - getStatusBarHeight();
        init();
    }
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    public void init(){
        mAllTagClassifyText= (TextView) mView.findViewById(R.id.all_tag_classify_text);
        mAllTagClassifyGridview1= (GridViewCustom) mView.findViewById(R.id.all_tag_classify_gridview1);
        mAllTagClassifyGridview2= (GridViewCustom) mView.findViewById(R.id.all_tag_classify_gridview2);
        mAllTagClassifyGridview3= (GridViewCustom) mView.findViewById(R.id.all_tag_classify_gridview3);
    }
    public void setItem(){
        View view =LayoutInflater.from(mContext).inflate(R.layout.all_tag_classify_item,null);
    }
}
