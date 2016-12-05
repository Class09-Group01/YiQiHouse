package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import com.bwf.aiyiqi.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/3 0003.
 */
public class PerGridviewAdapter extends BaseAdapter {
    private List<String> listPer;
    private Context mContext;
    private LayoutInflater mInflater;

    public void setCheckedPositon(int checkedPositon) {
        this.checkedPositon = checkedPositon;
        notifyDataSetChanged();
    }

    //设置选中的位置
    private int checkedPositon = -1;


    public PerGridviewAdapter(Context context) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        listPer = new ArrayList<>();

    }
    public  void setData(String [] str){
        listPer.clear();
        for (int i = 0; i < str.length; i++) {
            listPer.add(str[i]);
        }
        notifyDataSetChanged();
    }




    @Override
    public int getCount() {
        return listPer.size();
    }

    @Override
    public Object getItem(int position) {
        return listPer.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.all_tag_classify_item, parent, false);
        ItemViewHolder mHolder=new ItemViewHolder(convertView);
        mHolder.mAllTagClassifyItemText.setText(listPer.get(position));
        if(position == checkedPositon){
            mHolder.mAllTagClassifyItemText.setChecked(true);
        }else{
            mHolder.mAllTagClassifyItemText.setChecked(false);
        }
        return convertView;
    }

     class ItemViewHolder {
        @BindView(R.id.all_tag_classify_item_text)
        CheckedTextView mAllTagClassifyItemText;
        ItemViewHolder(View view) {
            ButterKnife.bind(this, view);

        }
    }
}
