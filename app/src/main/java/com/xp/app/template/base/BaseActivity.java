package com.xp.app.template.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * describe
 * date 2018/5/15
 * author xugaopan
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
    }


    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();


}
