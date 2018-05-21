package com.xp.template.framework.net;

import com.xp.template.framework.net.callback.CallBack;
import com.xp.template.framework.net.callback.DefaultCallBack;
import com.xp.template.framework.utils.Logger;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * describe
 * date 2018/5/17
 * author xugaopan
 */

public class OkHttpUtils {

    private static OkHttpUtils instance;
    private OkHttpClient client;

    public static OkHttpUtils getInstance() {
        if (instance == null) {
            synchronized (OkHttpUtils.class) {
                if (instance == null) {
                    instance = new OkHttpUtils();
                }
            }
        }
        return instance;
    }

    private OkHttpUtils() {
        //初始化okhttp
        client = new OkHttpClient();

    }


    //构建get请求
    public void buildGet(String url, DefaultCallBack callBack) {
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).get().build();
        generate(request, callBack);
    }

    //带参数get请求
    public void buildGetWithParam(String url, List<Parameter> parameters, CallBack callBack) {
        Request.Builder builder = new Request.Builder();
        StringBuffer ps = new StringBuffer();
        if (parameters != null && parameters.size() > 0) {
            ps.append("?");
            for (Parameter param : parameters) {
                ps.append(param.key);
                ps.append("=");
                ps.append(param.value);
            }
        }
        url = url + ps.toString();
        Request request = builder.url(url).get().build();
        generate(request, callBack);

    }


    private void generate(Request request, final CallBack callBack) {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Logger.d("onFailure:" + e.toString());
                callBack.onError(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callBack != null) {
                    try {
                        callBack.parseNetworkResponse(response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    //构建post请求
    public void buildPost(String url, List<Parameter> params,CallBack callBack) {
        Request.Builder builder = new Request.Builder();
        FormBody.Builder formBody = new FormBody.Builder();
        if (params == null || params.isEmpty()) {
            return;
        }
        for (Parameter pm : params) {
            formBody.add(pm.key, pm.value);
        }
        RequestBody requestBody = formBody.build();
        Request request = builder.url(url).post(requestBody).build();
        generate(request,callBack);

    }


    //构建文件请求


}
