package com.qxy.addd.simpletiktok.moviechart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qxy.addd.simpletiktok.R;
import com.qxy.addd.simpletiktok.net.MovieChartDataModel;

import java.util.List;

public class MovieChartAdapter extends RecyclerView.Adapter<MovieChartAdapter.ViewHolder> {
    private List<MovieChartDataModel.SubjectsBean>list;
    private MovieChartActivity movieChartActivity;
    private OnItemClickListener onItemClickListener;

    MovieChartAdapter(List<MovieChartDataModel.SubjectsBean> list,MovieChartActivity movieChartActivity,OnItemClickListener onItemClickListener) {
        this.list = list;
        this.movieChartActivity = movieChartActivity;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public MovieChartAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_chart_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  MovieChartAdapter.ViewHolder holder, int position) {

        MovieChartDataModel.SubjectsBean subjectsBean = list.get(position);
        holder.tv_movie_name.setText(subjectsBean.getName());
        //holder.tv_movie_tags.setText(subjectsBean.getTags());
        holder.tv_movie_hot.setText(subjectsBean.getDiscussion_hot());
        holder.tv_movie_relase_date.setText(subjectsBean.getRelease_date());
        Glide.with(movieChartActivity).load(subjectsBean.getPoster()).into(holder.iv_movie_poster);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(subjectsBean.getName(),subjectsBean.getRelease_date(),subjectsBean.getDiscussion_hot(),subjectsBean.getPoster());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv_movie_name,tv_movie_tags,tv_movie_relase_date,tv_movie_hot;
        private ImageView iv_movie_poster;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            tv_movie_name =itemView.findViewById(R.id.tv_movie_name);
            tv_movie_tags =itemView.findViewById(R.id.tv_movie_tags);
            tv_movie_relase_date =itemView.findViewById(R.id.tv_movie_relase_date);
            tv_movie_hot =itemView.findViewById(R.id.tv_movie_hot);
            iv_movie_poster =itemView.findViewById(R.id.iv_movie_poster);
        }
    }

    public interface OnItemClickListener{
        void onClick(String a,String b,String c,String d);
    }

}
