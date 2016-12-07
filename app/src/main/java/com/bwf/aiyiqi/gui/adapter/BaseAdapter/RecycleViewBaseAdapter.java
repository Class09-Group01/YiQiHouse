package com.bwf.aiyiqi.gui.adapter.BaseAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bwf.aiyiqi.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bobo on 2016/11/23.
 */

public abstract class RecycleViewBaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final int TYPE_CONTENT = 0;
    public final int TYPE_HEADER = 10;
    public final int TYPE_FOOTER = 20;


    public final int FOOTER_FAIL = -1;
    public final int FOORET_LOADING = 0;
    public final int FOORET_NOMOREDATA = 1;


    public List<T> data;
    public LayoutInflater inflater;

    private int footer_type;
    public Context mContext;

    public RecycleViewBaseAdapter(Context context) {
        this.data = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.mContext=context;
    }

    public abstract int getHeaderCount();

    public abstract int getFooterCount();

    //设置当前的底部加载类型
    public void setFooter_type(int footer_type) {
        this.footer_type = footer_type;
    }

    public void setData(List<T> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void addData(List<T> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
        Log.d("msg", "addData:" + data.size());
    }

    public void clearData() {
        this.data.clear();
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        if (position < getHeaderCount()) {
            return TYPE_HEADER;
        } else if (position == getItemCount() - getFooterCount()) {
            return TYPE_FOOTER;
        } else {
            //如果子类有不同的内容类型则复写该方法
            if (getContentType(position) != -1) {
                return getContentType(position);
            }
            return TYPE_CONTENT;
        }
    }

    //子类去复写 不同内容的type  当前位置的type
    public int getContentType(int position) {
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View view = inflater.inflate(R.layout.recycleview_footer, parent, false);
            return new FootViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_FOOTER){
            FootViewHolder mFootHolder = (FootViewHolder) holder;
            footerStatue(mFootHolder,footer_type);
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + getHeaderCount() + getFooterCount();
    }

    public int getContentItemCount(int position){
        if(position >= data.size()){
            return -1;
        }else{
            return position;
        }

    }


    /***
     * 设置底部状态的方法
     * @param mFootHolder
     * @param footer_type
     */
    public void footerStatue(FootViewHolder mFootHolder,int footer_type){
        switch (footer_type){
            case FOORET_LOADING:
                mFootHolder.recycleFootFail.setVisibility(View.GONE);
                mFootHolder.recycleFooNoMoreData.setVisibility(View.GONE);
                mFootHolder.recycleFootLoadMore.setVisibility(View.VISIBLE);
                break;
            case FOOTER_FAIL:
                mFootHolder.recycleFootFail.setVisibility(View.VISIBLE);
                mFootHolder.recycleFooNoMoreData.setVisibility(View.GONE);
                mFootHolder.recycleFootLoadMore.setVisibility(View.GONE);
                break;
            case FOORET_NOMOREDATA:
                mFootHolder.recycleFootFail.setVisibility(View.GONE);
                mFootHolder.recycleFooNoMoreData.setVisibility(View.VISIBLE);
                mFootHolder.recycleFootLoadMore.setVisibility(View.GONE);
                break;
        }
    }

    public class FootViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.recycle_foot_nomoredata)
        TextView recycleFooNoMoreData;
        @BindView(R.id.recycle_foot_fail)
        TextView recycleFootFail;
        @BindView(R.id.recycle_foot_progressBar)
        ProgressBar recycleFootProgressBar;
        @BindView(R.id.recycle_foot_loadmore)
        TextView recycleFootLoadMore;
        FootViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
