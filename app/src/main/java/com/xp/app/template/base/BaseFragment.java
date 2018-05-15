package com.xp.app.template.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * describe
 * date 2018/5/15
 * author xugaopan
 */

public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getResourceId(), container, false);
        initView();
        initData();
        return root;
    }

    protected abstract int getResourceId();

    protected abstract void initView();

    protected abstract void initData();
}
