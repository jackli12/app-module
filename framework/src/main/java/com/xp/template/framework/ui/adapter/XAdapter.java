package com.xp.template.framework.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public abstract class XAdapter<HOLDER extends XHolder, ITEM> extends RecyclerView.Adapter<HOLDER> {

    private final ArrayList<ITEM> mItemList = new ArrayList<>();

    /**
     * item的xml
     */
    public abstract int getLayoutId();

    public abstract HOLDER createHolder(View itemView);

    @Override
    public HOLDER onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        HOLDER holder = createHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(HOLDER holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}