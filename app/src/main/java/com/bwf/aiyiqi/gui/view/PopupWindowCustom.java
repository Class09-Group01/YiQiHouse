package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.MainFragmentPopupWindowAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class PopupWindowCustom {
    private PopupWindow window;
    public void initPopupWindow(Context context,View v) {
        List<String> data = new ArrayList<>();
        data.add("北京");
        data.add("上海");
        data.add("天津");
        data.add("石家庄");
        data.add("西安");
        data.add("武汉");
        data.add("成都");
        data.add("哈尔滨");
        data.add("大连");
        data.add("济南");

        final View popView = View.inflate(context,R.layout.fragment_home_pouwindow_city,null);
        MainFragmentPopupWindowAdapter adapter = new MainFragmentPopupWindowAdapter
                (context, R.layout.fragment_home_pouwindow_city_item);
        ListView popwindowCity = (ListView) popView.findViewById(R.id.fragment_home_popwindow_city);
        popwindowCity.setAdapter(adapter);
        adapter.setData(data);
        //设置popupwindow 宽铺满，高填充
        window = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //设置触摸其他地方可以关闭 window
        window.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (window != null && window.isShowing()) {
                    window.dismiss();
                    window = null;
                }
                return false;
            }
        });
        window.showAtLocation(v, Gravity.TOP,0,0);
    }
}
