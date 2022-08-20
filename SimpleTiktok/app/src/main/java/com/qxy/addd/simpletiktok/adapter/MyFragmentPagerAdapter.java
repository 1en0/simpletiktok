package com.qxy.addd.simpletiktok.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.qxy.addd.simpletiktok.fragment.PageFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    //private final String[] titles = {"关注", "粉丝"};
    private final String[] titles = {"Following", "Follower"};
    //private Context context;
    public MyFragmentPagerAdapter(FragmentManager fm){
        super(fm);
        //this.context = context;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        PageFragment pageFragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", titles[position]);
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
