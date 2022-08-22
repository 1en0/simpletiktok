package com.qxy.addd.simpletiktok.moviechart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.qxy.addd.simpletiktok.R;
import com.qxy.addd.simpletiktok.net.MovieChartDataModel;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;

public class MovieChartActivity extends AppCompatActivity {


    private RecyclerView r1;
    private SwipeRefreshLayout s1;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_chart);
        initView();
        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        r1.setLayoutManager(linearLayoutManager);
        s1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        requestData();
                    }
                },1000);
            }
        });

    }

    private void initView() {
        r1 = (RecyclerView) findViewById(R.id.r1);
        s1 = (SwipeRefreshLayout)findViewById(R.id.s1);


    }

    public void getData(MovieChartDataModel movieChartDataModel){
        if(movieChartDataModel==null||movieChartDataModel.getSubjects()==null){
            Toast.makeText(MovieChartActivity.this,"调取数据失败",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(MovieChartActivity.this,"成功",Toast.LENGTH_SHORT).show();
        MovieChartAdapter movieChartAdapter=new MovieChartAdapter(movieChartDataModel.getSubjects(), MovieChartActivity.this, new MovieChartAdapter.OnItemClickListener() {
            @Override
            public void onClick(String a, String b, String c, String d) {

            }
        });
        r1.setAdapter(movieChartAdapter);
        s1.setRefreshing(false);
        Toast.makeText(MovieChartActivity.this, "更新完成" , Toast.LENGTH_SHORT).show();//提示
    }

    public void requestData() {
        String url = "https://open.douyin.com/discovery/ent/rank/item/?type=2";

        OkHttpClient okHttpClient=new OkHttpClient();
        final Request request=new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("access-token", "clt.ca3dd6d3d8156865644cc2e85e567fc42hpWFQWQm1B5DX3uAMOnqkWKGhds")
                .get()
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MovieChartActivity.this,"网络连接失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("auth_code","success");
                String result=response.body().string();
                Gson gson=new Gson();
                final MovieChartDataModel movieChartDataModel=gson.fromJson(result,MovieChartDataModel.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MovieChartActivity.this,"网络连接成功", Toast.LENGTH_SHORT).show();
                        getData(movieChartDataModel);
                    }
                });
            }
        });
    }}
//https://open.douyin.com/oauth/access_token/?client_key=abc123456789&client_secret=abc123456789&code=X2RIIzpaaPGfYzM1jsRFIV1TWdJzFFhuSjmk&grant_type=authorization_code
//        String url="https://open.douyin.com/discovery/ent/rank/item/?type=1";
//        String url="https://movie.douban.com/j/search_subjects?type=movie&tag=%E8%B1%86%E7%93%A3%E9%AB%98%E5%88%86&sort=recommend&page_limit=200&page_start=0";

      /*  OkHttpUtils
                .get()
                .url("https://open.douyin.com/discovery/ent/rank/item/")
                .addHeader("Content-Type", "application/json")
                .addHeader("access-token", "clt.52d336f26f77aa6cc3d27fcdbd63ab12Z3hYeChz06m2J4CN8IyOhvAyGt9B")
                .addParams("access_token", "clt.52d336f26f77aa6cc3d27fcdbd63ab12Z3hYeChz06m2J4CN8IyOhvAyGt9B")
                .addParams("version", "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Log.d("auth_web", "error");
                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("auth_web", response);
                        String result=response.toString();
                        Gson gson=new Gson();
                        final MovieChartDataModel dateModel=gson.fromJson(result,MovieChartDataModel.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                getData(dateModel);
                            }
                        });

                    }

                });
    }}*/




