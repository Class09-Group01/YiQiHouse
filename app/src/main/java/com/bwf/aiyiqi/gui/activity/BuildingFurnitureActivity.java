package com.bwf.aiyiqi.gui.activity;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResposneBuildingFurnitureData;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.BuildingFurnitureGridAdapter;
import com.bwf.aiyiqi.gui.view.GridViewCustom;
import com.bwf.aiyiqi.mvp.presenter.BuildingFurniturePresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.BuildingFurniturePresenterImpl;
import com.bwf.aiyiqi.mvp.view.BuildingFurnitureView;
import com.cjj.MaterialRefreshLayout;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class BuildingFurnitureActivity extends BaseActivity implements BuildingFurnitureView{
    @BindView(R.id.abf_linearlayout)
    LinearLayout abfLinearlayout;
    @BindView(R.id.abf_scrollview)
    ScrollView abfScrollview;
    @BindView(R.id.reflush)
    MaterialRefreshLayout reflush;
    private BuildingFurniturePresenter mPresenter;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_building_furninture;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mPresenter = new BuildingFurniturePresenterImpl(this);
        mPresenter.loadResponseBfpData();
    }

    @Override
    protected void initDatas() {

    }

    /**
     * 这是动态添加内容，在网络数据请求成功的时候调用
     * @param data
     */
    private int index;
    public void addContentView(ResposneBuildingFurnitureData data) {
        final List<ResposneBuildingFurnitureData.DataBean> datas = data.getData();
        //避免重复添加
        abfLinearlayout.removeAllViews();

        for (int i = 0; i < datas.size(); i++) {
            View sonView = LayoutInflater.from(this).inflate
                    (R.layout.activity_building_furninture_content, abfLinearlayout, false);
            ChildViewHolder mHolder = new ChildViewHolder(sonView);
            mHolder.abfTitle.setText(datas.get(i).getTitle());
            mHolder.abfIcon.setImageURI(Uri.parse(datas.get(i).getIcon()));
            BuildingFurnitureGridAdapter mAdapter =
                    new BuildingFurnitureGridAdapter(this,R.layout.activity_building_furninture_content_item);
            //为每一个gridView 添加adapter 还有他的内容
            mHolder.abfMygridview.setAdapter(mAdapter);
            mAdapter.setData(datas.get(i).getChildren());
            final List<ResposneBuildingFurnitureData.DataBean.ChildrenBean> children
                    = datas.get(i).getChildren();
            //TODO 每一个GridView的监听在这里写
            mHolder.abfMygridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(BuildingFurnitureActivity.this, children.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });

            //添加到容器
            abfLinearlayout.addView(sonView);
        }
    }

    @Override
    public void showResposeSuccess(ResposneBuildingFurnitureData data) {
        Toast.makeText(this, "data:" + data.getData().size(), Toast.LENGTH_SHORT).show();
        addContentView(data);
    }

    @Override
    public void ShowFailed() {
        Toast.makeText(this, "OnEorror", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SHowNoMoreData() {
        Toast.makeText(this, "nodata:", Toast.LENGTH_SHORT).show();

    }


    public class ChildViewHolder {
        @BindView(R.id.abf_title)
        TextView abfTitle;
        @BindView(R.id.abf_mygridview)
        GridViewCustom abfMygridview;
        @BindView(R.id.abf_icon)
        SimpleDraweeView abfIcon;
        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
