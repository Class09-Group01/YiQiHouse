package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.bwf.aiyiqi.R;

/**
 * Created by Administrator on 2016/11/28.
 */

public class SelfOrderFragment extends Fragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getContentViewResId(),null);

    }

    protected int getContentViewResId() {
        return R.layout.fragment_self_order;
    }
    public SelfOrderFragment getFragment(){
        SelfOrderFragment selfOrderFragment=new SelfOrderFragment();
        return selfOrderFragment;
    }


}

