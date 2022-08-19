package com.qxy.addd.simpletiktok.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qxy.addd.simpletiktok.DAO.Gender;
import com.qxy.addd.simpletiktok.DAO.User;
import com.qxy.addd.simpletiktok.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private final List<User> mUserList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView userImage;
        TextView nickName;
        TextView address;
        ImageView gender;

        public ViewHolder(View view){
            super(view);
            userImage = (ImageView) view.findViewById(R.id.user_image);
            nickName = (TextView) view.findViewById(R.id.nickname);
            address = (TextView) view.findViewById(R.id.address);
            gender = (ImageView) view.findViewById(R.id.gender);
        }
    }

    public UserAdapter(List<User> userList){
        mUserList = userList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = mUserList.get(position);
        holder.userImage.setImageResource(user.getImageId());
        holder.nickName.setText(user.getName());
        Gender gender = user.getGender();
        int imageId = (gender.equals(Gender.FEMALE) ? R.drawable.female : R.drawable.male);
        holder.gender.setImageResource(imageId);
        holder.address.setText(user.getAddress().toString());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }
}
