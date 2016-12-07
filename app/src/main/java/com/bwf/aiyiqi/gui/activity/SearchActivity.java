package com.bwf.aiyiqi.gui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
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
import com.bwf.aiyiqi.mvp.view.SearchActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bobo on 2016/11/23.
 */
public class SearchActivity extends BaseActivity implements SearchActivityView, AdapterView.OnItemClickListener {
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
    private SearchActivityPresenterImpl mPresenter;
    private boolean isLoading;
    private boolean isNoMoreData;
    private SearchAcitvityListviewAdapter mAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void initDatas() {
        mAdapter = new SearchAcitvityListviewAdapter(this, R.layout.activity_search_listview_item);
        activitySearchListview.addFooterView(LayoutInflater.from(this).inflate(R.layout.school_recycleview_fooder,activitySearchListview,false));
        activitySearchListview.setAdapter(mAdapter);
        progressDialog = new ProgressDialog(this);
        activitySearchListview.setOnItemClickListener(this);
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

            }

            private int fistItem;
            @Override
            public void afterTextChanged(final Editable s) {
                if (!TextUtils.isEmpty(s.toString().trim()) && !isLoading) {
                    mAdapter.setSearch(s.toString());
                    //清除数据
                    mAdapter.clearData();
                    mPresenter.loadSearchDataFirst(s.toString());
                    progressDialog.show();
                    activitySearchEditCancle.setVisibility(View.VISIBLE);
                    activitySearchListview.setOnScrollListener(new AbsListView.OnScrollListener() {
                        @Override
                        public void onScrollStateChanged(AbsListView view, int scrollState) {
                        }
                        @Override
                        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                            if(firstVisibleItem - fistItem > 0){
                                if(firstVisibleItem + visibleItemCount == totalItemCount){
                                    mPresenter.loadSearchDataMore(s.toString());
                                    progressDialog.show();
                                    isLoading = true;
                                }
                            }
                            fistItem = firstVisibleItem;
                        }
                    });
                    isLoading = true;
                } else {
                    activitySearchEditCancle.setVisibility(View.GONE);
                }
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
        mAdapter.addData(datas.getData());
        isLoading = false;

        progressDialog.cancel();
    }

    @Override
    public void showSearchFail() {
        Toast.makeText(this, "OnEorror", Toast.LENGTH_SHORT).show();
        isLoading = false;
        progressDialog.cancel();


    }

    @Override
    public void showNoMoreData() {
        progressDialog.cancel();
        Toast.makeText(this, "该词条没有更多数据了", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void showNoSearchData() {
        Toast.makeText(this, "没有查找到的数据", Toast.LENGTH_SHORT).show();
        activitySearchContent.setVisibility(View.GONE);
        activitySearchNosearch.setVisibility(View.VISIBLE);
        isLoading = false;
        isNoMoreData = true;
        progressDialog.cancel();
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ResponseSearchDatas.DataBean item = mAdapter.getItem(position);
//        if(item.getTid())
        //全部都跳转到帖子详情
        Intent intent = new Intent(this,PostDetailActivity.class);
        intent.putExtra("tid",item.getTid());
        startActivity(intent);
    }
}
