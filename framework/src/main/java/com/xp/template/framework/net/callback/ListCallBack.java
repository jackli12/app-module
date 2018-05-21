package com.xp.template.framework.net.callback;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * describe 数组对象通用解析
 * date 2018/5/21
 * author xugaopan
 */

public abstract class ListCallBack<T> extends CallBack {
    private Class<T> entityClass;

    public ListCallBack() {
        Type type = getClass().getGenericSuperclass();
        Type[] clz = ((ParameterizedType) type).getActualTypeArguments();
        entityClass = (Class<T>) clz[0];
    }


    protected abstract void onSuccess(List<T> data);

    protected abstract void onFailed(int errorCode, String msg);

    public void failed(int errorCode, String msg) {
        onFailed(errorCode, msg);
    }

    private void success(List<T> data) {
        onSuccess(data);
    }

    @Override
    public void parseNetworkResponse(Response response) throws Exception {
        if (response != null) {
            String jsonStr = response.body().string();
            try {
                //错误码字段和后台返回信息需跟后台规定协议，然后修改
                JSONObject arr = new JSONObject(jsonStr);
                int code = arr.getInt("error_code");
                String msg = arr.getString("reason");
                if (code == 0) {
                    List<T> result = JSON.parseArray(arr.getString(data), entityClass);
                    success(result);
                } else {
                    failed(code, msg);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(Call call, Exception e) {
        failed(505, e.toString());
    }


}
