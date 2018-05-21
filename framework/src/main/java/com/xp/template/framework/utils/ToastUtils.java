package com.xp.template.framework.utils;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xp.template.framework.R;
import com.xp.template.framework.config.XPConfig;

/**
 * describe
 * date 2018/5/15
 * author xugaopan
 */

public class ToastUtils {

    public static void show(String msg){
        Toast toast=makeToast();
        TextView tvMsg = (TextView) toast.getView().getTag(R.id.toast_content);
        tvMsg.setText(msg);
        toast.show();
    }


    private static Toast makeToast() {
        Toast toast = new Toast(XPConfig.getAppCtx());
        View view = LayoutInflater.from(XPConfig.getAppCtx()).inflate(R.layout.lib_utils_view_toast, null);
        TextView tvMsg = view.findViewById(R.id.toast_content);
        view.setTag(R.id.toast_content, tvMsg);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER, 0, 0);
        return toast;
    }

}
