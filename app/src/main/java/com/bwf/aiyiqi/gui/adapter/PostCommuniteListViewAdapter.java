package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponsePostCommunite;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.ListViewBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lingchen52 on 2016/11/30.
 */

public class PostCommuniteListViewAdapter extends ListViewBaseAdapter {

    private List<ResponsePostCommunite.DataBean> mCommunite;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public PostCommuniteListViewAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
        mCommunite = new ArrayList<>();
        this.mContext = context;
    }

    public void addDatas(List<ResponsePostCommunite.DataBean> dataBeen) {
        mCommunite.addAll(dataBeen);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mCommunite.size();
    }

    @Override
    public Object getItem(int position) {
        return mCommunite.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            Log.d("PostCommuniteListViewAd", "parent:" + parent);
            Log.d("PostCommuniteListViewAd", "mLayoutInflater:" + mLayoutInflater);
            convertView = mLayoutInflater.inflate(R.layout.item_listview_post_review, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mUserimgItemListviewPostReview.setImageURI(Uri.parse(mCommunite.get(position).getAvtUrl()));
        holder.mUsernameItemListviewPostReview.setText(mCommunite.get(position).getAuthor());
        List<ResponsePostCommunite.DataBean.MessageBean> message = mCommunite.get(position).getMessage();
        if (message != null) {
            for (int i = 0; i < message.size(); i++) {
                if (message.get(i).getImgType() == 0) {
                    //文字
                    holder.mReviewItemListviewPostReview.setVisibility(View.VISIBLE);
                    holder.mReviewItemListviewPostReview.setText(message.get(i).getMsg());
                } else if (message.get(i).getMsgType() == 1) {
                    //图片
                    holder.mLlItemListviewPostReview.setVisibility(View.VISIBLE);
                    holder.mImagePostCommuniteReview.setImageURI(Uri.parse(message.get(i).getMsg()));
                }
                if (mCommunite.get(i).getBlock() == null) {
                    Log.d("PostCommuniteListViewAd", "holder.mLlReviwPostReview:");
                    holder.mLlReviwPostReview.setVisibility(View.GONE);

                } else {
                    String review = (String) mCommunite.get(i).getBlock();
                    String[] reviews = review.split(" ");
//                    holder.mLlReviwPostReview.setVisibility(View.VISIBLE);
                    if (reviews.length >= 5) {
                        holder.mNameTimeReview.setText(reviews[1] + " " + reviews[2] + " " + reviews[3] + " " + reviews[4]);
                        holder.mNameReview.setText(reviews[5]);
                    } else if (reviews.length == 4) {
                        holder.mNameTimeReview.setText(reviews[0] + " " + reviews[1] + " " + reviews[2] + " " + reviews[3]);
                    }

                }
            }
        }
        holder.mTimeItemListviewPostReview.setText(mCommunite.get(position).getDateline());
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.userimg_item_listview_post_review)
        SimpleDraweeView mUserimgItemListviewPostReview;
        @BindView(R.id.username_item_listview_post_review)
        TextView mUsernameItemListviewPostReview;
        @BindView(R.id.review_item_listview_post_review)
        TextView mReviewItemListviewPostReview;
        @BindView(R.id.ll_item_listview_post_review)
        LinearLayout mLlItemListviewPostReview;
        @BindView(R.id.time_item_listview_post_review)
        TextView mTimeItemListviewPostReview;
        @BindView(R.id.name_time_review)
        TextView mNameTimeReview;
        @BindView(R.id.ll_reviw_post_review)
        LinearLayout mLlReviwPostReview;
        @BindView(R.id.name_review)
        TextView mNameReview;
        @BindView(R.id.image_post_communite_review)
        SimpleDraweeView mImagePostCommuniteReview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
