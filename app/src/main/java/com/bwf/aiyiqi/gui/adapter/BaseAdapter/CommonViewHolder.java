package com.bwf.aiyiqi.gui.adapter.BaseAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2016/11/21.
 */

public class CommonViewHolder {

    private SparseArray<View> mViews;
    private View convertView;
    private int mPositon;


    /**
     * 将初始化传入的covertView 提供传出的出口方法
     * @return
     */
    public View getConvertView() {
        return convertView;
    }


    /**
     * viewholder的构造方法
     * 这里相当于实例化一个holder所需要做的工作
     * 绑定tag
     * 绑定item里面的控件
     * @param context
     * @param parent
     * @param layoutId
     * @param position
     */
    public CommonViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.convertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        mViews = new SparseArray();
        this.mPositon = position;
        convertView.setTag(this);
    }

    /**
     * 复用item所需要做的工作,外部只需要调用这个方法即可
     * @param context
     * @param convertView
     * @param layoutId
     * @param parent
     * @param position
     * @return
     */
    public static CommonViewHolder getHolder(Context context, View convertView, int layoutId, ViewGroup parent, int position){
        if(convertView == null){
            return new CommonViewHolder(context,parent,layoutId,position);
        }else {
            CommonViewHolder holder = (CommonViewHolder) convertView.getTag();
            holder.mPositon = position;
           return holder;
        }
    }

    /**
     * 通过控件的ID找到相应的View
     * @param viewId
     * @param <T>
     * @return
     */
    public < T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view == null){
            view = convertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    /**
     * 设置TextView类型的Id，并且设置内容
     * @param textViewId TextView的id
     * @param textValue TextView的内容设置值
     * @return 当前的holder
     */
    public CommonViewHolder setTextView(int textViewId, String textValue){
        TextView textView = getView(textViewId);
        textView.setText(textValue);
        return this;
    }

    /**
     * 设置image的图片，
     * @param viewId ImageView的控件的id
     * @param resId 图片资源文件id
     * @return 当前的holder
     */
    public CommonViewHolder setImageResource(int viewId, int resId)
    {
        ImageView view=getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    /**
     * 设置image的图片，
     * @param viewId SimpleDraweeView的控件的id
     * @param url 图片资源文件url
     * @return 当前的holder
     */

    public CommonViewHolder setSimpleDraweeView(int viewId, String url)
    {
        SimpleDraweeView view=getView(viewId);
        view.setImageURI(Uri.parse(url));
        return this;
    }

    /**
     * 设置图片，BitMap格式
     * @param viewId ImageView的控件的id
     * @param bitmap
     * @return 当前的holder
     */
    public CommonViewHolder setImageBitmap(int viewId, Bitmap bitmap)
    {
        ImageView view=getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }


}
