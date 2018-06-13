package com.xp.template.framework.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * describe
 * date 2018/6/13
 * author xugaopan
 */

public abstract class XHolder extends RecyclerView.ViewHolder {



    public XHolder(View itemView) {
        super(itemView);
    }

    protected abstract void bindData(int position);


}
