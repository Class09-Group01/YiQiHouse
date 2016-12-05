package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseEffectPictrueSubjectDatas;
import com.bwf.aiyiqi.gui.adapter.FragmentEffectPictureSubjectAdapter;
import com.bwf.aiyiqi.mvp.presenter.Impl.EffectPictureSubjectPresenterImpl;
import com.bwf.aiyiqi.mvp.view.EffectPictureSubjectView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class EffectPictureSubjectFragment extends BaseFragment implements EffectPictureSubjectView{
    @BindView(R.id.feps_listview)
    ListView fepsListview;
    @BindView(R.id.reflush)
    MaterialRefreshLayout reflush;
    private EffectPictureSubjectPresenterImpl mPresenter;
    private FragmentEffectPictureSubjectAdapter mAdapter;
    private FooterViewHolder mFootViewHolder;

    private boolean isLoading = true;
    private boolean noMoreData;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_effect_picture_subject;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = new EffectPictureSubjectPresenterImpl(this);
        mPresenter.loadEffectPictureSubjectData();
        mAdapter = new FragmentEffectPictureSubjectAdapter
                (getActivity(), R.layout.fragment_effect_picture_subject_item);
        //给listView增加一个脚部，显示当前刷新状态
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.recycleview_footer, fepsListview, false);
//        fepsListview.addFooterView(view);
        //绑定footViewholder
//        mFootViewHolder = new FooterViewHolder(view);

        fepsListview.setAdapter(mAdapter);
        //下拉刷新
        reflush.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                mAdapter.clearData();
                mPresenter.loadReflsuh();
                noMoreData = false;
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                mPresenter.loadEffectPictureSubjectData();
                isLoading = true;
            }
        });
        //上拉加载下一页
        reflush.setLoadMore(true);


//        fepsListview.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//            }
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                if (totalItemCount - 2 <= firstVisibleItem + visibleItemCount) {
//                    if (noMoreData) return;
//                    if (!isLoading) {
//
//                        //底部显示正在加载
//                        footerStatue(mFootViewHolder,Contact.FOOTER_STATUE_LOADING);
//                    }
//                }
//            }
//        });

    }

    @Override
    public void showEffectPictureSubjectDataSuccess(ResponseEffectPictrueSubjectDatas datas) {
        mAdapter.addData(datas.getData().getList());
        reflush.finishRefresh();
        reflush.finishRefreshLoadMore();
        isLoading = false;

    }

    @Override
    public void showEffectPictureSubjectDataFail() {
        Toast.makeText(getActivity(), "服务器飞太空了，亲~", Toast.LENGTH_SHORT).show();
        reflush.finishRefresh();
        reflush.finishRefreshLoadMore();
        isLoading = false;

        //底部显示 加载失败
//        footerStatue(mFootViewHolder,Contact.FOOTER_STATUE_FAIL);
    }

    @Override
    public void showNoMoreData() {
        reflush.finishRefresh();
        reflush.finishRefreshLoadMore();
        noMoreData = true;
        isLoading = false;

        //底部显示没有更多数据了
//        footerStatue(mFootViewHolder,Contact.FOOTER_STATUE_NOMOREDATA);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    public class FooterViewHolder {
        @BindView(R.id.recycle_foot_nomoredata)
        TextView recycleFootNoMoreData;
        @BindView(R.id.recycle_foot_fail)
        TextView recycleFootFail;
        @BindView(R.id.recycle_foot_progressBar)
        ProgressBar recycleFootProgressBar;

        FooterViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    /***
     * 设置底部状态的方法
     * @param mFootHolder
     * @param footer_type
     */
//    public void footerStatue(FooterViewHolder mFootHolder, int footer_type){
//        switch (footer_type){
//            case Contact.FOOTER_STATUE_LOADING:
//                mFootHolder.recycleFootFail.setVisibility(View.GONE);
//                mFootHolder.recycleFootNoMoreData.setVisibility(View.GONE);
//                mFootHolder.recycleFootProgressBar.setVisibility(View.VISIBLE);
//                break;
//            case Contact.FOOTER_STATUE_FAIL:
//                mFootHolder.recycleFootFail.setVisibility(View.VISIBLE);
//                mFootHolder.recycleFootNoMoreData.setVisibility(View.GONE);
//                mFootHolder.recycleFootProgressBar.setVisibility(View.GONE);
//                break;
//            case Contact.FOOTER_STATUE_NOMOREDATA:
//                mFootHolder.recycleFootFail.setVisibility(View.GONE);
//                mFootHolder.recycleFootNoMoreData.setVisibility(View.VISIBLE);
//                mFootHolder.recycleFootProgressBar.setVisibility(View.GONE);
//                break;
//        }
//    }
}
