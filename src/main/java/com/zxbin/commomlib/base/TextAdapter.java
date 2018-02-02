package com.zxbin.commomlib.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxbin.commomlib.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rex.Zhang on 2016/2/20.
 */
public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextHolder> {
    private List<String> datas;
    private Context mContext;
    private LayoutInflater mInflater;

    public TextAdapter(Context context) {
        this.datas = new ArrayList<>();
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public static TextAdapter newInstance(Context context) {
        TextAdapter a = new TextAdapter(context);
        a.datas = new ArrayList<>();
        a.mContext = context;
        a.mInflater = LayoutInflater.from(context);
        return a;
    }

    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_list, null);
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(final TextHolder holder, int position) {
        if (datas.size() == 0) {
            return;
        }

        holder.tv.setText(datas.get(position));

        if (l != null) {
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l.onItemClick(v, holder.getAdapterPosition(), v.getId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public List<String> getDatas() {
        return datas;
    }

    public void addData(String text) {
        datas.add(text);
        this.notifyDataSetChanged();
    }

    public void addDatas(List<String> texts) {
        if (texts == null) {
            return;
        }
        datas.addAll(texts);
        this.notifyDataSetChanged();
    }

    public void notifyRemoved(int pos) {
        if (pos > datas.size()) {
            return;
        }

        datas.remove(pos);
        notifyItemRemoved(pos);
    }

    class TextHolder extends RecyclerView.ViewHolder {
        public View layout;
        public TextView tv;

        public TextHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.msgLayout);
            tv = itemView.findViewById(R.id.msg);
        }
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }


    public void setOnItemClickListener(OnItemClickListener l) {
        this.l = l;
    }

    OnItemClickListener l;

    public interface OnItemClickListener {
        void onItemClick(View view, int position, long id);
    }
}
