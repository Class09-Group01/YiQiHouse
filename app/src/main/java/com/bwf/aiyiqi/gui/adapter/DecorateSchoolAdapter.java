package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        this.list = list;
        Log.d("DecorateSchoolAdapter", "list:" + list);
        Log.d("DecorateSchoolAdapter", list.get(0));
        notifyItemChanged(0);
    }

    public void addData(List<ResponseDecorateSchoolNews.DataBean.ListBean> listBeen) {
        this.listBeen = listBeen;
        notifyDataSetChanged();
        Toast.makeText(mContext, listBeen.get(0).getTitle(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(mContext, "listBeen.size():" + listBeen.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Toast.makeText(mContext, "songping", Toast.LENGTH_SHORT).show();
        if (position == 0) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            if (headerViewHolder.mLlItemSchoolEnter.getChildCount() == 0) {
                for (int i = 0; i < list.size() + 1; i++) {
                    final int x = i;
                    View view = mInflater.inflate(R.layout.school_recycleview_header_tag_item, null);
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getIdex(x + 1);
                        }
                    });
                    headerViewHolder.mLlItemSchoolEnter.addView(view);
                }
            }
            for (int i = 0; i < headerViewHolder.mLlItemSchoolEnter.getChildCount(); i++) {
                TextView textView = (TextView) headerViewHolder.mLlItemSchoolEnter.getChildAt(i).findViewById(R.id.school_recycle_header_textview);
                if (i == 0) {
                    textView.setText("全部");
                }else{
                    textView.setText(list.get(i));
                }
            }
            return;
        }
        if (position >= getItemCount() - 1) {
            //TODO
            return;
        }
        ContextViewHolder mContextViewHolder = (ContextViewHolder) holder;
        ResponseDecorateSchoolNews.DataBean.ListBean bean = listBeen.get(position - 1);
        mContextViewHolder.mDecorateschoolRecycleviewContextImage.setImageURI(Uri.parse(bean.getImage()));
        mContextViewHolder.mDecorateschoolRecycleviewContextTextview.setText(bean.getTitle());
        mContextViewHolder.mMfRecycleviewSchoolConcern.setText(bean.getViewCount()+"");
        mContextViewHolder.mSchoolRecycleContextItemCollection.setText(bean.getIsJump()+"");
        mContextViewHolder.mMfRecycleviewArticleComments.setText(bean.getReplies());

    }

    @Override
    public int getItemCount() {
        return listBeen.size() + 2;
    }


    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_item_school_enter)
        LinearLayout mLlItemSchoolEnter;

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

    public int index;

    public void getIdex(int index) {
        this.index = index;
    }

    //等着fragment调用
    public int toFragment() {
        return index;
    }


}
