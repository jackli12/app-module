package com.xp.template.framework.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * describe
 * date 2018/6/13
 * author xugaopan
 */

public class XRecycler<T> extends RecyclerView.Adapter {

    //如何做一个通用的适配器
    /*
      1.数据泛型
      2.layoutId传参
     */

    private List<T> list;

    protected XRecycler() {
        list = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
