package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSearchDatas;
import com.bwf.aiyiqi.gui.adapter.SearchAcitvityListviewAdapter;
import com.bwf.aiyiqi.mvp.presenter.Impl.SearchActivityPresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.SearchActivityPresenter;
import com.bwf.aiyiqi.mvp.view.SearchActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bobo on 2016/11/23.
 */
public class SearchActivity extends BaseActivity implements SearchActivityView {
    @BindView(R.id.activity_search_edit)
    EditText activitySearchEdit;
    @BindView(R.id.activity_search_edit_cancle)
    ImageView activitySearchEditCancle;
    @BindView(R.id.activity_search_cancle)
    TextView activitySearchCancle;
    @BindView(R.id.activity_search_title)
    LinearLayout activitySearchTitle;
    @BindView(R.id.activity_search_content)
    RelativeLayout activitySearchContent;
    @BindView(R.id.activity_search_listview)
    ListView activitySearchListview;
    @BindView(R.id.activity_search_nosearch)
    RelativeLayout activitySearchNosearch;
    private SearchActivityPresenter mPresenter;
    private boolean isLoading;
    private boolean isNoMoreData;
    private SearchAcitvityListviewAdapter mAdapter;

    @Override
    protected void initDatas() {
        mAdapter = new SearchAcitvityListviewAdapter(this, R.layout.activity_search_listview_item);
        activitySearchListview.setAdapter(mAdapter);
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);

        mPresenter = new SearchActivityPresenterImpl(this);
        activitySearchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(isNoMoreData)return;
                if (!TextUtils.isEmpty(s.toString().trim()) && !isLoading) {
                    mAdapter.setSearch(s.toString());
                    mPresenter.loadSearchData(s.toString());
                    activitySearchEditCancle.setVisibility(View.VISIBLE);
                    isLoading = true;
                } else {
                    activitySearchEditCancle.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_search;
    }

    @Override
    public void showSearchDataSuccess(ResponseSearchDatas datas) {
        Toast.makeText(this, "datas" + datas.getData().size(), Toast.LENGTH_SHORT).show();

        activitySearchContent.setVisibility(View.GONE);
        activitySearchNosearch.setVisibility(View.GONE);
        mAdapter.clearData();

        mAdapter.addData(datas.getData());
        isLoading = false;
    }

    @Override
    public void showSearchFail() {
        Toast.makeText(this, "OnEorror", Toast.LENGTH_SHORT).show();
        isLoading = false;

    }

    @Override
    public void showNoMoreData() {
        activitySearchContent.setVisibility(View.GONE);
        activitySearchNosearch.setVisibility(View.VISIBLE);

        Toast.makeText(this, "没有查找到的数据", Toast.LENGTH_SHORT).show();
        isLoading = false;
        isNoMoreData = true;
    }


    @OnClick({R.id.activity_search_edit_cancle, R.id.activity_search_cancle})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_search_edit_cancle:
                activitySearchEdit.getText().clear();
                isNoMoreData = false;
                activitySearchContent.setVisibility(View.VISIBLE);

                //TODO 显示页面。。。
                break;
            case R.id.activity_search_cancle:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
