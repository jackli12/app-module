package com.xp.app.template.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xp.app.template.R;
import com.xp.app.template.bean.Water;
import com.xp.template.framework.ui.adapter.XAdapter;
import com.xp.template.framework.ui.adapter.XHolder;

/**
 * describe
 * date 2018/6/13
 * author xugaopan
 */

public class CityAdapter extends XAdapter<CityAdapter.WaterHolder, Water> {


    @Override
    public int getLayoutId() {
        return R.layout.adapter_test;
    }

    @Override
    public WaterHolder createHolder(View itemView) {
        return new WaterHolder(itemView);
    }


    class WaterHolder extends XHolder {

        public WaterHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bindData(int position) {

        }
    }
}
