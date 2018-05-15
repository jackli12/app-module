package com.xp.app.template.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xp.app.template.R;

/**
 * describe
 * date 2018/5/15
 * author xugaopan
 */

public abstract class BaseDialog extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setStyle(STYLE_NO_FRAME, R.style.BaseDialog_Style);
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(getLayoutId(), container, false);

        return contentView;
    }

    public abstract int getLayoutId();


    public void showDialog(Context context, String tag) {
        if (context instanceof FragmentActivity && !((FragmentActivity) context).isFinishing()
                ) {
            FragmentActivity activity = (FragmentActivity) context;
            try {
                if (!isAdded()) {
                    show(activity.getSupportFragmentManager(), tag);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dimissDialog() {
        try {
            if (getFragmentManager() != null) {
                dismissAllowingStateLoss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}