package com.qxy.addd.simpletiktok.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qxy.addd.simpletiktok.DAO.Address;
import com.qxy.addd.simpletiktok.DAO.Gender;
import com.qxy.addd.simpletiktok.DAO.User;
import com.qxy.addd.simpletiktok.R;
import com.qxy.addd.simpletiktok.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {
    private final List<User> userList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_fragment, container,false);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        UserAdapter adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private void initFruits(){
        for(int i = 0; i < 2; i++){
            userList.add(new User(R.drawable.apple, "apple", new Address("中国", "北京", "海淀"), Gender.FEMALE));
            userList.add(new User(R.drawable.banana, "banana", new Address("中国", "上海", "闵行"), Gender.MALE));
            userList.add(new User(R.drawable.grape, "grape", new Address("中国", "河北", "石家庄"), Gender.MALE));
            userList.add(new User(R.drawable.orange, "orange", new Address("中国", "辽宁", "沈阳"), Gender.FEMALE));
            userList.add(new User(R.drawable.pear, "pear", new Address("中国", "吉林", "吉林"), Gender.MALE));
            userList.add(new User(R.drawable.pineapple, "pineapple", new Address("中国", "黑龙江", "哈尔滨"), Gender.MALE));
            userList.add(new User(R.drawable.strawberry, "strawberry", new Address("中国", "辽宁", "大连"), Gender.FEMALE));
            userList.add(new User(R.drawable.watermelon, "watermelon", new Address("中国", "吉林", "长春"), Gender.FEMALE));
        }
    }
}
