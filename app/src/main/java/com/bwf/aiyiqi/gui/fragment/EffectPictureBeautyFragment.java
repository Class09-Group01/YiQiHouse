package com.bwf.aiyiqi.gui.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseEffectctBeautyDatas;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.EffectPictureBeautyGridAdapter;
import com.bwf.aiyiqi.mvp.presenter.Impl.EffectPictureBeautyFragmentPresenterImpl;
import com.bwf.aiyiqi.mvp.view.EffectPictureBeautyFragmentView;
import com.cjj.MaterialRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/25.
 */

public class EffectPictureBeautyFragment extends BaseFragment implements EffectPictureBeautyFragmentView {
    @BindView(R.id.fepb_space)
    CheckedTextView fepbSpace;
    @BindView(R.id.fepb_style)
    CheckedTextView fepbStyle;
    @BindView(R.id.fepb_local)
    CheckedTextView fepbLocal;
    @BindView(R.id.fepb_color)
    CheckedTextView fepbColor;
    @BindView(R.id.fepb_gridview)
    GridView fepbGridview;
    @BindView(R.id.reflush)
    MaterialRefreshLayout reflush;
    private EffectPictureBeautyFragmentPresenterImpl mPresent;
    private EffectPictureBeautyGridAdapter mAdapter;
    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_effect_picture_beauty;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresent = new EffectPictureBeautyFragmentPresenterImpl(this);
        mAdapter = new EffectPictureBeautyGridAdapter(getActivity(),R.layout.fepb_popwindow_view_itme);
        mPresent.loadEffectPictureData();

        fepbGridview.setAdapter(mAdapter);
    }

    private CheckedTextView currentView;
    @OnClick({R.id.fepb_space, R.id.fepb_style, R.id.fepb_local, R.id.fepb_color})
    public void onClick(View view) {
        if(currentView != null){
            currentView.setChecked(false);
        }
        switch (view.getId()) {
            case R.id.fepb_space:
                break;
            case R.id.fepb_style:
                break;
            case R.id.fepb_local:
                break;
            case R.id.fepb_color:
                break;
        }
        currentView = (CheckedTextView) view;
        currentView.setChecked(true);
        setPupwindow(view);
    }

    public void setPupwindow(final View view){
        final CheckedTextView textView = (CheckedTextView) view;
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fepb_popwindow_view, null);
        final PopupWindow popupWindow = new PopupWindow();
        //设置popwindow的内容点击监听
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
            }
        });
        //对popwindow 的消失进行监听，如果消失，则设置当前的checktextview 也不选中
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                textView.setChecked(false);
            }
        });
        //获取屏幕的高宽
        DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
        float screenWidth = displayMetrics.widthPixels;
        float screenHeight = displayMetrics.heightPixels;

        //获得父view的坐标
        int[] location = new int[2];
        view.getLocationOnScreen(location);

        popupWindow.setContentView(inflate);
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight((int) (screenHeight-location[1]-view.getHeight()));
        //这是popWindow的触摸消失的配置，必须设置
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置popwindow的位置
        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY,0,location[1]+view.getHeight());
    }

    //以下是网络请求回调方法
    @Override
    public void showEffectDataSuccess(ResponseEffectctBeautyDatas data) {
        mAdapter.addData(data.getData().getList());
    }

    @Override
    public void showEffectFail() {
        Toast.makeText(getActivity(), "onEorror", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showEffectNoMoreData() {

    }
}
