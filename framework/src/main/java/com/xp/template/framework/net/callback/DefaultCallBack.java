package com.xp.template.framework.net.callback;

import com.alibaba.fastjson.JSON;
import com.xp.template.framework.utils.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;

/**
 * describe 对象通用解析
 * date 2018/5/17
 * author xugaopan
 */

public abstract class DefaultCallBack<T> extends CallBack {
    private Class<T> entityClass;


    public DefaultCallBack() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }


    public abstract void onSuccess(T data);

    public abstract void onFailed(int errorCode, String errorMsg);

    public void success(T data) {
        onSuccess(data);
    }

    /**
     * @param errorCode 错误码
     * @param errorMsg  错误信息
     */
    public void failed(int errorCode, String errorMsg) {
        onFailed(errorCode, errorMsg);
    }

    /**
     * 结果解析：需要后端固定对应的接口格式
     */
    @Override
    public void parseNetworkResponse(Response response) throws Exception {
        String json = response.body().string();
        Logger.d("json:" + json);
        if (null != json) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                String result = jsonObject.getString(data);
                int code = jsonObject.getInt("error_code");
                String msg = jsonObject.getString("reason");
                if (code == 0) {
                    success(JSON.parseObject(result, entityClass));
                } else {
                    failed(code, msg);
                }
//                return JSON.parseObject(result, entityClass);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(Call call, Exception e) {
        failed(404, e.toString());
    }

}
