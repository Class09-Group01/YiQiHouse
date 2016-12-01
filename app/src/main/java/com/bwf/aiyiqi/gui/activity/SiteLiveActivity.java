package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
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
    private SiteLivePresenterImpl mPresenter;
    private SiteLiveListViewAdapter mAdapter;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_sitelive;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mAdapter = new SiteLiveListViewAdapter(this,R.layout.acitivity_sitelive_comments_item);
        activitySiteliveListview.setAdapter(mAdapter);

        Intent intent = getIntent();
        String building = intent.getStringExtra("buidingId");
        String comId = intent.getStringExtra("comId");

        mPresenter = new SiteLivePresenterImpl(this);
        if(!TextUtils.isEmpty(building) && !TextUtils.isEmpty(comId)){
            mPresenter.setId(comId,building);
        }

        mPresenter.loadSiteLivePresenter();
    }

    @Override
    protected void initDatas() {

    }

    //动态添加progress进度的相关信息
    public void addProgress(ResponseSiteLiveData.DataBean data) {
        imageListviewActivityDecorationCompany.setImageURI(Uri.parse(data.getImageUrl()));
        siteItemListviewDecoration.setText(data.getOrderHouse().getAddress());
        compositionItemListviewDecoration.setText(data.getOrderHouse().getLayout());
        activitySiteliveUser.removeAllViews();
        activitySiteliveProgress.removeAllViews();
        int size = Math.max(data.getMembers().size(), data.getProgress().size());
        for (int i = 0; i < size; i++) {
            //成员
            if (i < data.getMembers().size()) {
                View view = LayoutInflater.from(this).inflate(R.layout.acitivity_sitelive_progress_user_item, activitySiteliveUser, false);
                UserViewHolder holder = new UserViewHolder(view);
                if (data.getMembers().get(i).getAvatar() != null) {
                    holder.aspuItemUserimg.setImageURI(Uri.parse(data.getMembers().get(i).getAvatar()));
                }
                holder.aspuItemTextname.setText(data.getMembers().get(i).getRealName());
                holder.aspuItemTextwork.setText(bossIdToJob(data.getMembers().get(i).getBossId()));
                activitySiteliveUser.addView(view);
            }
            //工程进度
            if (i < data.getProgress().size()) {
                View view = LayoutInflater.from(this).inflate(R.layout.acitivity_sitelive_progress_progress_item, activitySiteliveProgress, false);
                ProgressViewHolder holder = new ProgressViewHolder(view);
                holder.asppItemText.setText(data.getProgress().get(i).getProgressName());
                setProgress(holder,data.getProgress().get(i).getProgressStatus());
                activitySiteliveProgress.addView(view);
            }
        }
    }


    private void setProgress(ProgressViewHolder holder,int proStatus){
        switch (proStatus){
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
        Toast.makeText(this, "progress" + data.getData().getProgress().size(), Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, "data" + data.getData().size(), Toast.LENGTH_SHORT).show();
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
