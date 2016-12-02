package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSiteLiveComments;
import com.bwf.aiyiqi.framwork.tool.SpanableStringTool;
import com.bwf.aiyiqi.gui.activity.SiteLiveViewPagerActivity;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CommonBaseAdapter;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.CommonViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/1.
 */

public class SiteLiveListViewAdapter extends CommonBaseAdapter<ResponseSiteLiveComments.DataBean> {
    private Context context;
    private List<String> urls;
    public SiteLiveListViewAdapter(Context context, int layoutId) {
        super(context, layoutId);
        this.context = context;
        urls = new ArrayList<>();
    }

    @Override
    public void setViewContent(CommonViewHolder holder, final ResponseSiteLiveComments.DataBean comments) {
        if(!TextUtils.isEmpty(comments.getAvatar())){
            holder.setSimpleDraweeView(R.id.asci_item,comments.getAvatar());
        }
        holder.setTextView(R.id.asci_item_name,comments.getCreatorName()+"("+comments.getCreatorRole()+")");
        holder.setTextView(R.id.asci_item_time,timeSwitch(comments.getCreateTime()));

        //设置@的字体变颜色
        List<ResponseSiteLiveComments.DataAt> dataAts =
                JSON.parseArray(comments.getAtList(),ResponseSiteLiveComments.DataAt.class);
        int size1 = dataAts.size();
        int length = 0;
        if(size1 > 0){
            for (int i = 0; i < size1; i++) {
                length += dataAts.get(i).getName().length()+2;
            }
        }
        TextView tv = holder.getView(R.id.asci_item_textcontent);
        String message = comments.getMessage();
        int index = message.indexOf("@");
        if(index == -1){
            index = 0;
        }
        tv.setText(SpanableStringTool.spanToString(comments.getMessage(),index,length+index));


        //这是回复部分
        int size = comments.getReplyList().size();
        if(size > 0){
            holder.getView(R.id.asci_comment_textnum).setVisibility(View.VISIBLE);
            holder.getView(R.id.asci_comment).setVisibility(View.VISIBLE);
            LinearLayout linearLayout = holder.getView(R.id.asci_comment);
            holder.setTextView(R.id.asci_comment_textnum,"评论("+size+")");
            linearLayout.removeAllViews();
            for (int i = 0; i < size; i++) {
                ResponseSiteLiveComments.DataBean.Reply reply = comments.getReplyList().get(i);
                TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.textview,linearLayout,false);
                String s = reply.getName() + "(" + reply.getRoleName() + "):";
                //设置不同颜色的Textview 文本
                SpannableString spannableString = SpanableStringTool.spanToString(s + reply.getMessage(),0, s.length());
                textView.setText(spannableString);
                linearLayout.addView(textView);
            }
        }else{
            holder.getView(R.id.asci_comment_textnum).setVisibility(View.GONE);
            holder.getView(R.id.asci_comment).setVisibility(View.GONE);
        }

        //这是图片显示部分
        if(!TextUtils.isEmpty(comments.getImgSrc())){
            GridView gridView = holder.getView(R.id.asci_item_gridview);
            CommonBaseAdapter adapter = new CommonBaseAdapter<String>(context,R.layout.activity_sitelive_comments_grid_item) {
            @Override
            public void setViewContent(CommonViewHolder holder, String url) {
                holder.setSimpleDraweeView(R.id.ascg_item_img,url);
            }
        };
            gridView.setAdapter(adapter);
            adapter.setData(addUrls(comments.getImgSrc()));
            //图片的监听，点击跳转到大图预览
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(context, SiteLiveViewPagerActivity.class);
                    intent.putExtra("position",position);
                    intent.putExtra("urls",comments.getImgSrc());
                    context.startActivity(intent);
                }
            });
        }
    }
    private String timeSwitch(long time){
        String date = "";
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        date = format.format(time);
        return date;
    }
    public static List<String> addUrls(String url){
        List<String> urls = new ArrayList<>();
        String[] uu = url.split(",");
        for (int i = 0; i < uu.length; i++) {
            urls.add(uu[i]);
        }
        return urls;
    }

}
