package com.example.recipes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipes.R;
import com.example.recipes.model.Order;
import com.example.recipes.model.RecentlyViewed;
import com.google.android.material.card.MaterialCardView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewedViewHolder> {

    Context context;
    List<RecentlyViewed> recentlyViewedList;

    @NonNull
    @Override
    public RecentlyViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_course_details, parent, false);
        return new RecentlyViewedViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedViewHolder holder, int position) {

        holder.imageView.setImageResource(recentlyViewedList.get(position).getImageView());
        holder.name.setText(recentlyViewedList.get(position).getNametext());
        holder.ingred.setText(recentlyViewedList.get(position).getNametext1());
        holder.recipes.setText(recentlyViewedList.get(position).getNametext2());
    }

    @Override
    public int getItemCount() {
        return recentlyViewedList.size();
    }

    public static class RecentlyViewedViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,ingred, recipes;

        public RecentlyViewedViewHolder(@NonNull View view){
            super(view);

            name = itemView.findViewById(R.id.nametext);
            ingred = itemView.findViewById(R.id.ingred);
            recipes = itemView.findViewById(R.id.recipes);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }




}
