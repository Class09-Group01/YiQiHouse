package com.bwf.aiyiqi.gui.fragment;

import com.bwf.aiyiqi.R;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */
public class DecorateMyBudgetFragment extends BaseFragment{
    @Override
    protected int getContentViewResId() {
        return R.layout.decorates_mybudget;
    }
    public static DecorateMyBudgetFragment newInstance(){
        DecorateMyBudgetFragment myBudgetFragment=new DecorateMyBudgetFragment();
        return myBudgetFragment;
    }
}
