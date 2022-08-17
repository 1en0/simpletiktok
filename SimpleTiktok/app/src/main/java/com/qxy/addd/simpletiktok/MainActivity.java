package com.qxy.addd.simpletiktok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    private boolean init(){
        String clientkey = "awsmbt4qp3nm9zlf"; // 需要到开发者网站申请
        DouYinOpenApiFactory.init(new DouYinOpenConfig(clientkey));
        DouYinOpenApi douyinOpenApi = DouYinOpenApiFactory.create(this);
        Authorization.Request request = new Authorization.Request();
        request.scope = "user_info,following.list,fans.list,fans.check,trial.whitelist";                          // 用户授权时必选权限
        //request.optionalScope0 = "";
        //request.state = "ww";                                 // 用于保持请求和回调的状态，授权请求后原样带回给第三方。
        //request.callerLocalEntry = "com.xxx.xxx...activity";
        return douyinOpenApi.authorize(request);
    }
}