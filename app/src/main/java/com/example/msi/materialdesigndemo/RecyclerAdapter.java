package com.example.msi.materialdesigndemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by MSI on 2017/7/12.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<String> list_str;
    OnItemClickListener onItemClickListener;

    public RecyclerAdapter(Context context, List<String> list_str) {
        this.context = context;
        this.list_str = list_str;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.item_text, null);
        return new ViewHolder(inflate);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(list_str.get(position));

//        Random random = new Random();
//        int[] ranColor = {0xffFFFFF0, 0xffF5FFFA, 0xffFFE7B,
//                0xffF0F8FF, 0xffEECFA1, 0xffF5FFFA, 0xffFFF0F5, 0xffEEE9E9}; //0xff000000 | random.nextInt(0x00ffffff);
//        int randomcolor = random.nextInt(ranColor.length);
//        holder.layout.setBackgroundColor(ranColor[randomcolor]);
//        // 随机高度, 模拟瀑布效果.
//        final int high = (int) (100 + Math.random() * 300);
//        final ViewGroup.LayoutParams layoutParams = holder.text.getLayoutParams();
//        layoutParams.height = high;
//        holder.text.setLayoutParams(layoutParams);
    }


    @Override
    public int getItemCount() {
        return list_str.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView text;
        LinearLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            text.setOnClickListener(this);
            layout = (LinearLayout) itemView.findViewById(R.id.layout);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null) {
                onItemClickListener.OnItemClick(view, getPosition());
            }
        }
    }

    public interface OnItemClickListener {
        public void OnItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
