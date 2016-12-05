package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseDecorateSchoolNews;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bwf.aiyiqi.R.layout.school_recycleview_fooder;

/**
 * Created by Administrator on 2016/11/24.
 * 功能描述：
 * 作者：
 */
public class DecorateSchoolAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_CONTEXT = 0;
    private static final int TYPE_FOODER = 1;
    private static final int TYPE_HEADER = 2;
    List<ResponseDecorateSchoolNews.DataBean.ListBean> listBeen;
    List<String> list;
    private LayoutInflater mInflater;
    private Context mContext;
    private int lastIndex;


    public DecorateSchoolAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        listBeen = new ArrayList<>();
        list = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        if (position == getItemCount() - 1) {
            return TYPE_FOODER;
        }
        return TYPE_CONTEXT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = mInflater.inflate(R.layout.school_recycleview_header, parent, false);
            return new HeaderViewHolder(view);
        }
        if (viewType == TYPE_CONTEXT) {
            View view = mInflater.inflate(R.layout.school_recycleview_context, parent, false);
            return new ContextViewHolder(view);
        }
        return new FooderViewHolder(mInflater.inflate(school_recycleview_fooder, parent, false));
    }

    public void setDatas(List<String> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyItemChanged(0);
    }

    public void addData(List<ResponseDecorateSchoolNews.DataBean.ListBean> listBeen) {
        this.listBeen.addAll(listBeen);
        notifyDataSetChanged();
    }
    public void addNewData(List<ResponseDecorateSchoolNews.DataBean.ListBean> listBeen){
        this.listBeen.clear();
        this.listBeen.addAll(listBeen);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            if (headerViewHolder.mLlItemSchoolEnter.getChildCount() == 0) {
                for (int i = 0; i < list.size() + 1; i++) {
                    final RadioButton radioButton = (RadioButton) mInflater.inflate(R.layout.school_recycleview_header_tag_item, null);
                    radioButton.setTag(i+1);
                    radioButton.setId(i+1);
                    RadioGroup.LayoutParams lp = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(15,0,0,0);//设置边距
                    if(i==0){
                        radioButton.setChecked(true);
                    }
                    headerViewHolder.mLlItemSchoolEnter.addView(radioButton,lp);
                }
            }
            for (int i = 0; i < headerViewHolder.mLlItemSchoolEnter.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) headerViewHolder.mLlItemSchoolEnter.getChildAt(i).findViewById(i+1);
                if (i == 0) {
                    radioButton.setText("全部");
                } else {
                    radioButton.setText(list.get(i - 1));
                }

               radioButton.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       mGetNewsStage.getNewsStage(v);
                   }
               });
            }
            return;
        }
        if (position == getItemCount() - 1) {
            //TODO
            return;
        } else {
            ContextViewHolder mContextViewHolder = (ContextViewHolder) holder;
            ResponseDecorateSchoolNews.DataBean.ListBean bean = listBeen.get(position - 1);
            if(bean == null)return;
            mContextViewHolder.mDecorateschoolRecycleviewContextImage.setImageURI(Uri.parse(bean.getImage()));
            mContextViewHolder.mDecorateschoolRecycleviewContextTextview.setText(bean.getTitle());
            mContextViewHolder.mMfRecycleviewSchoolConcern.setText(bean.getViewCount() + "");
            mContextViewHolder.mSchoolRecycleContextItemCollection.setText(bean.getIsJump() + "");
            mContextViewHolder.mMfRecycleviewArticleComments.setText(bean.getReplies());
        }
    }

    @Override
    public int getItemCount() {
        return listBeen.size() + 2;
    }


    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_item_school_enter)
        RadioGroup mLlItemSchoolEnter;

        HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ContextViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.decorateschool_recycleview_context_image)
        SimpleDraweeView mDecorateschoolRecycleviewContextImage;
        @BindView(R.id.decorateschool_recycleview_context_textview)
        TextView mDecorateschoolRecycleviewContextTextview;
        @BindView(R.id.mf_recycleview_school_concern)
        TextView mMfRecycleviewSchoolConcern;
        @BindView(R.id.school_recycle_context_item_collection)
        TextView mSchoolRecycleContextItemCollection;
        @BindView(R.id.mf_recycleview_article_comments)
        TextView mMfRecycleviewArticleComments;

        ContextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class FooderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.school_recycle_fooder_text_nomoredata)
        TextView mSchoolRecycleFooderTextNomoredata;

        FooderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    private GetNewsStage mGetNewsStage;
    public interface GetNewsStage{
         void getNewsStage(View v);
    }
    public void getGetNewsStage(GetNewsStage mGetNewsStage){
        this.mGetNewsStage=mGetNewsStage;
    }


}
