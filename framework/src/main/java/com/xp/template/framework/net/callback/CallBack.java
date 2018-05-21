package com.xp.template.framework.net.callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * describe
 * date 2018/5/21
 * author xugaopan
 */

public abstract class CallBack {
    protected String data = "result";//后端定义的数据tag

    public abstract void onError(Call call, Exception e);

    public abstract void parseNetworkResponse(Response response) throws Exception;

}
