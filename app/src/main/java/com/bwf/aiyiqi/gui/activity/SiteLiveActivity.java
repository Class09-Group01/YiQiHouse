package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSiteLiveComments;
import com.bwf.aiyiqi.entity.ResponseSiteLiveData;
import com.bwf.aiyiqi.gui.adapter.SiteLiveListViewAdapter;
import com.bwf.aiyiqi.gui.view.MyListView;
import com.bwf.aiyiqi.gui.view.ScrollViewCustom;
import com.bwf.aiyiqi.mvp.presenter.Impl.SiteLivePresenterImpl;
import com.bwf.aiyiqi.mvp.view.SiteLiveView;
import com.cjj.MaterialRefreshLayout;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/29.
 */

public class SiteLiveActivity extends BaseActivity implements SiteLiveView {
    @BindView(R.id.back_activity_decoration_company)
    ImageView backActivityDecorationCompany;
    @BindView(R.id.image_listview_activity_decoration_company)
    SimpleDraweeView imageListviewActivityDecorationCompany;
    @BindView(R.id.site_item_listview_decoration)
    TextView siteItemListviewDecoration;
    @BindView(R.id.composition_item_listview_decoration)
    TextView compositionItemListviewDecoration;
    @BindView(R.id.activity_sitelive_user)
    LinearLayout activitySiteliveUser;
    @BindView(R.id.activity_sitelive_progress)
    LinearLayout activitySiteliveProgress;
    @BindView(R.id.activity_sitelive_recycle)
    MyListView activitySiteliveListview;
    @BindView(R.id.reflush)
    MaterialRefreshLayout reflush;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.activity_sitelive_scrollview)
    ScrollViewCustom activitySiteliveScrollview;
    @BindView(R.id.title)
    TextView mTitle;
    private SiteLivePresenterImpl mPresenter;
    private SiteLiveListViewAdapter mAdapter;
    private String building;
    private int userChildCount ;


    @Override
    protected int getContentViewResId() {
        return R.layout.activity_sitelive;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mTitle.setText("工地直播");
        mAdapter = new SiteLiveListViewAdapter(this, R.layout.acitivity_sitelive_comments_item);
        //给listVIew加一个底部 显示没有更多数据了

        activitySiteliveListview.addFooterView(LayoutInflater.from(this).inflate
                (R.layout.school_recycleview_fooder, activitySiteliveListview, false));
        activitySiteliveListview.setAdapter(mAdapter);

        Intent intent = getIntent();
        String comId = intent.getStringExtra("comId");
        String buidingId = intent.getStringExtra("buidingId");
        if (TextUtils.isEmpty(buidingId)) {
            buidingId = "0";
        }
        building = new String(buidingId);

        mPresenter = new SiteLivePresenterImpl(this);
        if (!TextUtils.isEmpty(building) && !TextUtils.isEmpty(comId)) {
            mPresenter.setId(comId, building);
        }
        mPresenter.loadSiteLivePresenter();
    }

    @Override
    protected void initDatas() {
    }

    //动态添加progress进度的相关信息
    public void addProgress(final ResponseSiteLiveData.DataBean data) {
        imageListviewActivityDecorationCompany.setImageURI(Uri.parse(data.getImageUrl()));
        siteItemListviewDecoration.setText(data.getOrderHouse().getAddress());
        compositionItemListviewDecoration.setText(data.getOrderHouse().getLayout());
        activitySiteliveProgress.removeAllViews();
        userChildCount = activitySiteliveUser.getChildCount();
        int size = Math.max(data.getMembers().size(), data.getProgress().size());
        for (int i = 0; i < size; i++) {
            //成员
            if (i < data.getMembers().size()) {
                activitySiteliveUser.getChildAt(i).setVisibility(View.VISIBLE);
                View view = activitySiteliveUser.getChildAt(i);
                UserViewHolder holder = new UserViewHolder(view);
                if (data.getMembers().get(i).getAvatar() != null) {
                    holder.aspuItemUserimg.setImageURI(Uri.parse(data.getMembers().get(i).getAvatar()));
                }
                holder.aspuItemTextname.setText(data.getMembers().get(i).getRealName());
                holder.aspuItemTextwork.setText(bossIdToJob(data.getMembers().get(i).getBossId()));
            }else if(i>=userChildCount){
            }else {
                activitySiteliveUser.getChildAt(i).setVisibility(View.GONE);
            }
            //工程进度
            if (i < data.getProgress().size()) {
                View view = LayoutInflater.from(this).inflate(R.layout.acitivity_sitelive_progress_progress_item, activitySiteliveProgress, false);
                ProgressViewHolder holder = new ProgressViewHolder(view);
                holder.asppItemText.setText(data.getProgress().get(i).getProgressName());
                setProgress(holder, data.getProgress().get(i).getProgressStatus());
                activitySiteliveProgress.addView(view);
                final int progressId = data.getProgress().get(i).getProgressId();
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.setId(progressId+"", building);
                        mPresenter.loadSiteLivePresenter();
                    }
                });
            }
        }
    }


    private void setProgress(ProgressViewHolder holder, int proStatus) {
        switch (proStatus) {
            //装修状态： 0 --> 未开工  1 -->进行中 2 --> 完成
            case 0:
                holder.asppItemCheckedico.setChecked(false);
                holder.asppItemCheckedpro.setChecked(false);
                holder.asppItemCheckedpro.setText(getString(R.string.nofinish));
                break;
            case 1:
                holder.asppItemCheckedico.setChecked(true);
                holder.asppItemCheckedpro.setChecked(true);
                holder.asppItemCheckedico.setAlpha(0.5f);
                holder.asppItemCheckedpro.setAlpha(0.5f);
                holder.asppItemCheckedpro.setText(getString(R.string.finishing));

                break;
            case 2:
                holder.asppItemCheckedico.setChecked(true);
                holder.asppItemCheckedpro.setChecked(true);
                holder.asppItemCheckedpro.setText(getString(R.string.finish));
                break;
            default:
                break;
        }
    }


    /**
     * user的工作岗位转换
     *
     * @param id
     * @return
     */
    private String bossIdToJob(int id) {
        String workName = "";
        switch (id) {
            case 1701:
                workName = "设计师";
                break;
            case 1703:
                workName = "工长";
                break;
            case 1702:
                workName = "监理";
                break;
            default:
                workName = "材料顾问";
                break;
        }
        return workName;
    }


    //以下是网络数据请求结果回调
    @Override
    public void showSiteProgressDataSuccess(ResponseSiteLiveData data) {
        activitySiteliveScrollview.scrollTo(0, 0);
        addProgress(data.getData());
    }

    @Override
    public void showSiteProgressFail() {
        Toast.makeText(this, "OnEorror", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSiteProgressNoMoreData() {

    }

    @Override
    public void showSiteCommentsDataSuccess(ResponseSiteLiveComments data) {
        activitySiteliveScrollview.scrollTo(0, 0);
        Toast.makeText(this, "data" + data.getData().size(), Toast.LENGTH_SHORT).show();
        mAdapter.clearData();
        mAdapter.addData(data.getData());
    }

    @Override
    public void showSiteCommentsFail() {

    }

    @Override
    public void showSiteCommentsNoMoreData() {
        Toast.makeText(this, "onError", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.back_activity_decoration_company, R.id.reflush})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_activity_decoration_company:
                break;
            case R.id.reflush:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_activity_decoration_company)
    public void onClick() {
        finish();
        return;
    }

    public class UserViewHolder {
        @BindView(R.id.aspu_item_userimg)
        SimpleDraweeView aspuItemUserimg;
        @BindView(R.id.aspu_item_textname)
        TextView aspuItemTextname;
        @BindView(R.id.aspu_item_textwork)
        TextView aspuItemTextwork;

        UserViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public class ProgressViewHolder {
        @BindView(R.id.aspp_item_checkedpro)
        CheckedTextView asppItemCheckedpro;
        @BindView(R.id.aspp_item_checkedico)
        CheckedTextView asppItemCheckedico;
        @BindView(R.id.aspp_item_text)
        TextView asppItemText;

        ProgressViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
