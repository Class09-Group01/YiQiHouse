package com.bwf.aiyiqi.gui.adapter.BaseAdapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjb-bo on 2015/11/21.
 * listView 和 GridView 的万能适配器
 */

public abstract class CommonBaseAdapter<T> extends BaseAdapter{
    private List<T> data;
    private Context context;
    private int layoutId;

    public CommonBaseAdapter(Context context,int layoutId) {
        this.context = context;
        this.data = new ArrayList<>();
        this.layoutId = layoutId;
    }
    /***
     * 为子类提供清除数据源的功能
     */
    public void clearData(){
        this.data.clear();
        notifyDataSetChanged();
    }
    /**
     * 添加数据 多次添加，分页加载使用
     * @param data
     */
    public void addData(List<T> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 设置数据，只设置一次，只显示当前页的数据
     * @param data
     */
    public void setData(List<T> data){
        this.data.clear();
        addData(data);
    }

    @Override
    public int getCount() {
        Log.d("MyBaseAdapter", "3 "+data.size());
        return data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("CommonBaseAdapter", "getview"+data.get(position).toString());

        //这里调用了封装后的viewholder
        CommonViewHolder holder =
                CommonViewHolder.getHolder(context, convertView, layoutId, parent, position);

        //这里提供一个抽象方法，供子类去实现这个方法，每一个子类显示的内容是不同的
        setViewContent(holder,data.get(position));

            Log.d("CommonBaseAdapter", "getview"+data.get(position).toString());

        return holder.getConvertView();
    }

    /***
     * 每一个子类需要去实现，显示内容的方法
     * @param holder 子类绑定的控件的holder
     * @param t 每一个Item对应的显示实体类的数据
     */
    public abstract void setViewContent(CommonViewHolder holder,T t);


}
