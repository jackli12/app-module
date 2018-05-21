package com.xp.template.framework.net;

import com.xp.template.framework.net.callback.CallBack;
import com.xp.template.framework.net.callback.DefaultCallBack;

import java.io.File;
import java.util.List;

/**
 * describe 基础请求类
 * date 2018/5/17
 * author xugaopan
 */

public class Http {

    /**
     * 不带参数get请求
     *
     * @param url
     */
    public static void get(String url, DefaultCallBack callBack) {
        OkHttpUtils.getInstance().buildGet(url, callBack);
    }


    /**
     * 带参数get请求
     *
     * @param url
     * @param parameters
     */
    public static void get(String url, List<Parameter> parameters, CallBack callBack) {
        OkHttpUtils.getInstance().buildGetWithParam(url, parameters, callBack);
    }

    /**
     * post带参数请求
     *
     * @param url
     * @param parameters
     */
    public static void post(String url, List<Parameter> parameters, CallBack callBack) {
        OkHttpUtils.getInstance().buildPost(url, parameters, callBack);
    }

    /**
     * 文件上传
     *
     * @param url
     * @param parameters
     * @param file
     */
    public static void uploadFile(String url, List<Parameter> parameters, File file) {

    }


}
