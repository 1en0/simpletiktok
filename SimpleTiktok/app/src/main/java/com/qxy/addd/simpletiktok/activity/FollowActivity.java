package com.qxy.addd.simpletiktok.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.google.android.material.tabs.TabLayout;
import com.qxy.addd.simpletiktok.R;
import com.qxy.addd.simpletiktok.adapter.MyFragmentPagerAdapter;

public class FollowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String clientkey = "awsmbt4qp3nm9zlf";
        //DouYinOpenApiFactory.init(new DouYinOpenConfig(clientkey));
        setContentView(R.layout.activity_main);
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //init();
    }
    private boolean init(){
        DouYinOpenApi douyinOpenApi = DouYinOpenApiFactory.create(this);

        Authorization.Request request = new Authorization.Request();
        request.scope = "trial.whitelist";                          // 用户授权时必选权限
        //request.state = "ww";                                 // 用于保持请求和回调的状态，授权请求后原样带回给第三方。
        //request.callerLocalEntry = "com.xxx.xxx...activity";
        return douyinOpenApi.authorize(request);                    // 优先使用抖音app进行授权，如果抖音app因版本或者其他原因无法授权，则使用web页授权
    }
}