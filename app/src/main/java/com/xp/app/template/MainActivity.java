package com.xp.app.template;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xp.app.template.bean.Water;
import com.xp.template.framework.bean.CityBean;
import com.xp.template.framework.net.Http;
import com.xp.template.framework.net.Parameter;
import com.xp.template.framework.net.callback.ListCallBack;
import com.xp.template.framework.utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url = "http://v.juhe.cn/historyWeather/province";
    String key = "bac05c59259643ac48f28a2542aedfc4";

    String river = "http://web.juhe.cn:8080/environment/water/river";
    String rKey = "6e191d16833c2878b11bb5106820b5d4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpTest();
    }

    private void httpTest() {
        List<Parameter> get = new ArrayList<>();
        get.add(new Parameter("key", key));
        Http.get(url, get, new ListCallBack<CityBean>() {


            @Override
            protected void onSuccess(List<CityBean> data) {
                for (CityBean city : data) {
//                    Logger.d("city:" + city.getProvince());
                }
            }

            @Override
            protected void onFailed(int errorCode, String msg) {

            }
        });

        //post错误码请求测试
        List<Parameter> post = new ArrayList<>();
        post.add(new Parameter("key", rKey));
        post.add(new Parameter("river", river));
        Http.post(river, post, new ListCallBack<Water>() {
            @Override
            protected void onSuccess(List<Water> data) {

            }

            @Override
            protected void onFailed(int errorCode, String msg) {
                Logger.i("errorCode:" + errorCode, " msg:" + msg);
            }
        });

    }


}
