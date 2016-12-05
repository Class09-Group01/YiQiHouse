package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.PerGridviewAdapter;
import com.bwf.aiyiqi.gui.view.GridViewCustom;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/2.
 * 功能描述：
 * 作者：
 */
public class AllTagClassify extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.all_tag_classify_text)
    TextView mAllTagClassifyText;
    @BindView(R.id.all_tag_classify_finish)
    ImageView mAllTagClassifyFinish;
    @BindView(R.id.all_tag_classify_gridview1)
    GridViewCustom mAllTagClassifyGridview1;
    @BindView(R.id.all_tag_classify_gridview2)
    GridViewCustom mAllTagClassifyGridview2;
    @BindView(R.id.all_tag_classify_gridview3)
    GridViewCustom mAllTagClassifyGridview3;
    private PerGridviewAdapter mPerGridviewAdapter1, mPerGridviewAdapter2, mPerGridviewAdapter3;
    private int itemPosition;
    private int resultCode = 12;
    private CheckedTextView mCheckedTextView;
    private Intent mIntent = new Intent();
    private String[] ing = {"主体拆迁", "水电改造", "防水处理", "木土工程", "瓦工工程", "油工工程"};
    private String[] finish = {"主材安装", "竣工验收", "软装配饰", "居家生活"};
    private String[] per = {"验房收房", "装修公司", "量房设计", "辅材选购", "主材选购", "家居选购", "装修合同"};


    @Override
    protected void initDatas() {
        //得到上一个页面跳转过来的传的参，并给adapter进行页面的改变
        itemPosition = getIntent().getIntExtra("pagerPosition", 10);
        Log.d("AllTagClassify", "itemPosition:" + itemPosition);
        if (itemPosition < 7) {
            mPerGridviewAdapter1.setCheckedPositon(itemPosition);
        }
        if (itemPosition >= 7 && itemPosition < 13) {
            mPerGridviewAdapter2.setCheckedPositon(itemPosition - 7);
        }
        if (itemPosition >= 13) {
            mPerGridviewAdapter3.setCheckedPositon(itemPosition - 13);
        }
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mCheckedTextView = new CheckedTextView(this);
        mPerGridviewAdapter1 = new PerGridviewAdapter(this);
        mAllTagClassifyGridview1.setAdapter(mPerGridviewAdapter1);
        mPerGridviewAdapter1.setData(per);
        mAllTagClassifyGridview1.setOnItemClickListener(this);
        mPerGridviewAdapter2 = new PerGridviewAdapter(this);
        mAllTagClassifyGridview2.setAdapter(mPerGridviewAdapter2);
        mPerGridviewAdapter2.setData(ing);
        mAllTagClassifyGridview2.setOnItemClickListener(this);
        mPerGridviewAdapter3 = new PerGridviewAdapter(this);
        mAllTagClassifyGridview3.setAdapter(mPerGridviewAdapter3);
        mPerGridviewAdapter3.setData(finish);
        mAllTagClassifyGridview3.setOnItemClickListener(this);

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.all_tag_classify;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }
//带参返回上一个页面
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int count = parent.getCount();
        if(count == 7){
            int perPosition= position;
//            Toast.makeText(this, "perPosition:" + perPosition, Toast.LENGTH_SHORT).show();
            mIntent.putExtra("tagPosition",perPosition);
            this.setResult(resultCode, mIntent);
            finish();
            this.overridePendingTransition(R.anim.lift_out,R.anim.decorate_school_animal_out);
        }else if(count == 6){
            int ingPosition=position+7;
//            Toast.makeText(this, "ingPosition:" + ingPosition, Toast.LENGTH_SHORT).show();
            mIntent.putExtra("tagPosition",ingPosition);
            this.setResult(resultCode, mIntent);
            finish();
            this.overridePendingTransition(R.anim.lift_out,R.anim.decorate_school_animal_out);
        }else if(count == 4){
            int finishPosition=position+13;
//            Toast.makeText(this, "finishPosition:" + finishPosition, Toast.LENGTH_SHORT).show();
            mIntent.putExtra("tagPosition",finishPosition);
            this.setResult(resultCode, mIntent);
            finish();
            this.overridePendingTransition(R.anim.lift_out,R.anim.decorate_school_animal_out);
        }
    }
    @OnClick(R.id.all_tag_classify_finish)
    public void onClick() {
        mIntent.putExtra("tagPosition",itemPosition);
        this.setResult(resultCode, mIntent);
        finish();
        this.overridePendingTransition(R.anim.lift_out,R.anim.decorate_school_animal_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onPause();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
