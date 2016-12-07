package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.EssenceSay;
import com.bwf.aiyiqi.framwork.tool.Contact;
import com.bwf.aiyiqi.gui.activity.PostDetailActivity;
import com.bwf.aiyiqi.gui.adapter.BaseAdapter.RecycleViewBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 * 功能描述：
 * 作者：
 */

public class EssenceFragmentAdapter extends RecycleViewBaseAdapter<EssenceSay.DataBean> {
    public EssenceFragmentAdapter(Context context) {
        super(context);
    }

    @Override
    public int getHeaderCount() {
        return 0;
    }

    @Override
    public int getFooterCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if(position<getItemCount()-1) {
            ContentViewHolder mContentViewHolder = (ContentViewHolder) holder;
            EssenceSay.DataBean dataBean = data.get(position);
            mContentViewHolder.mEssencesayContentitemTitleSimple.setImageURI(Uri.parse(dataBean.getAvtUrl()));
            mContentViewHolder.mEssencesayContentitemName.setText(dataBean.getAuthor());
            if (dataBean.getHouseInfo()!=null) {
                mContentViewHolder.mEssencesayContentitemDetails.setVisibility(View.VISIBLE);
                String community;
                if (dataBean.getHouseInfo().getCommunity() .equals("")) {
                    community = "简约";
                } else {
                    community = dataBean.getHouseInfo().getCommunity();
                }
                int stage = dataBean.getHouseInfo().getStage();
                String strStage = Contact.tab[stage - 1];
                String[] styleArr = {"一", "二", "三", "四", "五","六","七","八"};
                int layout = dataBean.getHouseInfo().getLayout();
                String layoutA = styleArr[layout - 1];
                int styles = dataBean.getHouseInfo().getStyle();
                String stylesA = styleArr[styles - 1];
                mContentViewHolder.mEssencesayContentitemDetails.setText(layoutA + "室" + stylesA + "厅" + "、" + mContext.getString(R.string.area, dataBean.getHouseInfo().getArea()) + "、" + mContext.getString(R.string.budget, (dataBean.getHouseInfo().getBudget())) + "、" + community + "、" + strStage);
            }
            mContentViewHolder.mEssencesayContentitemTagsLinearlayout.removeAllViews();
            if (dataBean.getTags().size()==0) {
                mContentViewHolder.mEssencesayContentitemTagsLinearlayout.setVisibility(View.GONE);
            }
            else {
                int tags;
                if (dataBean.getTags().size() > 3) {
                    tags = 3;
                } else {
                    tags = dataBean.getTags().size();
                }
                for (int i = 0; i < tags; i++) {
                    View view = inflater.inflate(R.layout.tags_linearlayout_item, mContentViewHolder.mEssencesayContentitemTagsLinearlayout,false);
                    TextView tv = (TextView) view.findViewById(R.id.tags_item_textview);
                    tv.setText(dataBean.getTags().get(i).getTagname());
                    mContentViewHolder.mEssencesayContentitemTagsLinearlayout.addView(view);
                }
            }
            mContentViewHolder.mEssencesayContentitemTextview.setText(dataBean.getSubject());
            if(dataBean.getAttachments() == null){
                mContentViewHolder.mEssencesayContentitemSimple.setVisibility(View.GONE);
            }else {
                mContentViewHolder.mEssencesayContentitemSimple.setImageURI(Uri.parse(dataBean.getAttachments().get(0)));
            }
            mContentViewHolder.mEssencesayContentitemComefromTextview.setText(mContext.getString(R.string.comefrom_textview, dataBean.getFname()));
            mContentViewHolder.mEssencesayContentitemComefrom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO跳转
                }
            });
            mContentViewHolder.mEssencesayContentitemTime.setText(dataBean.getDateline());
            mContentViewHolder.mEssencesayContentitemReplies.setText(dataBean.getReplies());
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_CONTENT){
            View view = inflater.inflate(R.layout.essencesay_contentitem, parent, false);
            return new ContentViewHolder(view);
        }
        return super.onCreateViewHolder(parent, viewType);
    }


     class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.essencesay_contentitem_title_simple)
        SimpleDraweeView mEssencesayContentitemTitleSimple;
        @BindView(R.id.essencesay_contentitem_name)
        TextView mEssencesayContentitemName;
        @BindView(R.id.essencesay_contentitem_details)
        TextView mEssencesayContentitemDetails;
        @BindView(R.id.essencesay_contentitem_textview)
        TextView mEssencesayContentitemTextview;
        @BindView(R.id.essencesay_contentitem_simple)
        SimpleDraweeView mEssencesayContentitemSimple;
        @BindView(R.id.essencesay_contentitem_comefrom_textview)
        TextView mEssencesayContentitemComefromTextview;
        @BindView(R.id.essencesay_contentitem_comefrom)
        LinearLayout mEssencesayContentitemComefrom;
        @BindView(R.id.essencesay_contentitem_time)
        TextView mEssencesayContentitemTime;
        @BindView(R.id.essencesay_contentitem_shear)
        ImageView mEssencesayContentitemShear;
        @BindView(R.id.essencesay_contentitem_replies)
        TextView mEssencesayContentitemReplies;
        @BindView(R.id.essencesay_contentitem_comment_image)
        ImageView mEssencesayContentitemCommentImage;
        @BindView(R.id.essencesay_contentitem_tags_linearlayout)
        LinearLayout mEssencesayContentitemTagsLinearlayout;

        ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition=getAdapterPosition();
                    Intent intent=new Intent(mContext, PostDetailActivity.class);
                    intent.putExtra("tid",data.get(itemPosition).getTid());
                    mContext.startActivity(intent);
                }
            });
        }
    }

}
