package com.qxy.addd.simpletiktok.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.qxy.addd.simpletiktok.DAO.Address;
import com.qxy.addd.simpletiktok.DAO.Gender;
import com.qxy.addd.simpletiktok.DAO.User;
import com.qxy.addd.simpletiktok.R;
import com.qxy.addd.simpletiktok.adapter.UserAdapter;
import com.qxy.addd.simpletiktok.bean.FollowBean;
import com.qxy.addd.simpletiktok.bean.UserBean;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {
    private List<User> userList = new ArrayList<>();
    private List<UserBean> userBeanList = new ArrayList<>();
    private SmartRefreshLayout smartRefreshLayout;
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private String baseUrl = "https://open.douyin.com";
    private Handler handler = new Handler();
    private boolean has_more = false;
    private String  cursor = "0";
    private int pageCount = 10;
    //是粉丝页面还是关注页面；
    private String type = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_fragment, container,false);
        //initFruits();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Bundle bundle = this.getArguments();
        if(bundle != null){
            type = bundle.getString("title");
        }
        //Log.d("web", type);
        initData();

        //下拉刷新和上拉加载监听
        //设置下拉刷新和上拉加载样式，默认样式
        smartRefreshLayout.setRefreshHeader(new ClassicsHeader(view.getContext()));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(view.getContext()));
        //下拉刷新和上拉加载更新数据
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener(){
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore();
                initData();
            }
        });
        return view;
    }
    private void initData(){
        String url = baseUrl;
        if(type.equals("Following")){
            url += "/following/list/";
        }
        else if(type.equals("Follower")){
            url += "/fans/list/";
        }
        OkHttpUtils
            .get()
            .url(url)
            .addParams("count", String.valueOf(pageCount))
            .addParams("open_id", "_000O49a2c4BDhkHhw-BG7VeVOPm2B6Sdt02")
            .addParams("cursor", cursor)
            .addHeader("access-token", "act.7320f55e6984bda1c09829d7a1782ab08eHgVe3cQWRl3reS5IuTQt5FVD9C")
            .addHeader("Content-Type", "application/json")
            .build()
            .execute(new StringCallback() {
                @Override
                public void onError(Request request, Exception e) {
                    //Toast.makeText(view.getContext(), "信息已加载完成", Toast.LENGTH_LONG);
                    Log.d("web", "error");
                }

                @Override
                public void onResponse(String response) {
                    Log.d("web", response);
                    beanResult(response);
                }
            });

        //Log.d("web", response.body().toString());
    }
    private void beanResult(final String response){
        //在UI主线程操作
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Log.d(this.getClass().toString(), response);
                FollowBean bean = JSON.parseObject(response, FollowBean.class);
                has_more = bean.getData().getHas_more();
                cursor = bean.getData().getCursor();
                List<UserBean> list = bean.getData().getList();
                List<User> userList = new ArrayList<>();
                if(list == null){
                    return;
                }
                for(UserBean user : list){
                    Address address = new Address(user.getCountry(), user.getProvince(), user.getCity());
                    Gender gender = (user.getGender() == 1 ? Gender.MALE : Gender.FEMALE);
                    userList.add(new User(user.getAvatar(), user.getNickname(), address, gender));
                    //Log.d("web", user.toString());
                }
                setData(userList);
            }
        });
    }

    private void setData(List<User> userList){
        //this.userList = userList;
        //this.userList.clear();
        this.userList.addAll(userList);
        adapter.notifyDataSetChanged();
    }
//    private void initFruits(){
//        for(int i = 0; i < 2; i++){
//            userList.add(new User(R.drawable.apple, "apple", new Address("中国", "北京", "海淀"), Gender.FEMALE));
//            userList.add(new User(R.drawable.banana, "banana", new Address("中国", "上海", "闵行"), Gender.MALE));
//            userList.add(new User(R.drawable.grape, "grape", new Address("中国", "河北", "石家庄"), Gender.MALE));
//            userList.add(new User(R.drawable.orange, "orange", new Address("中国", "辽宁", "沈阳"), Gender.FEMALE));
//            userList.add(new User(R.drawable.pear, "pear", new Address("中国", "吉林", "吉林"), Gender.MALE));
//            userList.add(new User(R.drawable.pineapple, "pineapple", new Address("中国", "黑龙江", "哈尔滨"), Gender.MALE));
//            userList.add(new User(R.drawable.strawberry, "strawberry", new Address("中国", "辽宁", "大连"), Gender.FEMALE));
//            userList.add(new User(R.drawable.watermelon, "watermelon", new Address("中国", "吉林", "长春"), Gender.FEMALE));
//        }
//    }
}
