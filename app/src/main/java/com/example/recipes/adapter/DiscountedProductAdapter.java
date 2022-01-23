package com.example.recipes.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipes.R;
import com.example.recipes.model.DiscountedProducts;
import com.example.recipes.model.Order;

import java.util.List;


public class DiscountedProductAdapter extends RecyclerView.Adapter<DiscountedProductAdapter.DiscountedProductViewHolder> {

    Context context;
    List<DiscountedProducts> discountedProductsList;
    int selectedItem = 0;

    public DiscountedProductAdapter(Context context, List<DiscountedProducts> discountedProductsList) {
        this.context = context;
        this.discountedProductsList = discountedProductsList;
    }

    @NonNull
    @Override
    public DiscountedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.discounted_row_items, parent, false);
        return new DiscountedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedProductViewHolder holder, int position) {

        holder.discountImageView.setImageResource(discountedProductsList.get(position).getImageurl());
        holder.name.setText(discountedProductsList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return discountedProductsList.size();
    }

    class DiscountedProductViewHolder extends  RecyclerView.ViewHolder{

        ImageView discountImageView;
        TextView name;


        public DiscountedProductViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_title);
            discountImageView = itemView.findViewById(R.id.categoryImage1);


        }
    }



}