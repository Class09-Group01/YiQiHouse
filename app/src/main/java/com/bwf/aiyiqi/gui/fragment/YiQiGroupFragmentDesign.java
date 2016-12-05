package com.bwf.aiyiqi.gui.fragment;

import android.widget.AbsListView;

import com.bwf.aiyiqi.mvp.presenter.Impl.YiQiGroupPresenterImpl;

/**
 * Created by lingchen52 on 2016/11/30.
 */

public class YiQiGroupFragmentDesign extends YiQiGroupFragment {
    @Override
    public void initDatas() {
        mPresenter = new YiQiGroupPresenterImpl("1701",this);
        loadNextPage();
    }

    @Override
    public void loadNextPage() {
        isLoading = true;
        mPresenter.loadNextPage("1701");
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if(!isLoading && firstVisibleItem + visibleItemCount == totalItemCount - 1){
            isLoading = true;
            mPresenter.loadNextPage("1701");
        }
    }
}
