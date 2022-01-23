package com.example.recipes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipes.MainActivity;
import com.example.recipes.ProductDetalls;
import com.example.recipes.R;

import com.example.recipes.model.FoodItem;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

    public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {
        List<FoodItem> foodDataItemList;
        Context context;

        public FoodAdapter(Context context, List<FoodItem> foodDataItemList) {
            this.context = context;
            this.foodDataItemList = foodDataItemList;
        }


        @NonNull
        @Override
        public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.food_holder, parent,false);

            return new FoodHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
            holder.name.setText(foodDataItemList.get(position).getName());
            holder.name_1.setText(foodDataItemList.get(position).getName1());
            holder.name_2.setText(foodDataItemList.get(position).getName2());
            holder.food_image.setImageResource(foodDataItemList.get(position).getImage());
            holder.ingred.setText(foodDataItemList.get(position).getName3());
            holder.recipes.setText(foodDataItemList.get(position).getName4());

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(context, ProductDetalls.class);
                    i.putExtra("name", foodDataItemList.get(position).getName());
                    i.putExtra("ingred", foodDataItemList.get(position).getName3());
                    i.putExtra("recipes", foodDataItemList.get(position).getName4());
                    i.putExtra("food_image", foodDataItemList.get(position).getImage());
                    i.putExtra("foodId", foodDataItemList.get(position).getId());
                    context.startActivity(i);

                }
            });

        }

        @Override
        public int getItemCount() {
            return foodDataItemList.size();
        }

        public void filteredList(ArrayList<FoodItem> filteredList) {
            foodDataItemList = filteredList;
            notifyDataSetChanged();
        }


        class FoodHolder extends RecyclerView.ViewHolder{
            TextView name;
            TextView name_1;
            TextView name_2;
            TextView ingred;
            TextView recipes;

            ImageView food_image;

            MaterialCardView cardView;

            public FoodHolder(View holder){
                super(holder);

                food_image = holder.findViewById(R.id.image3);
                name = holder.findViewById(R.id.tv_name);
                name_1 = holder.findViewById(R.id.tv_name_1);
                name_2 = holder.findViewById(R.id.tv_name_2);
                ingred = holder.findViewById(R.id.ingred);
                recipes = holder.findViewById(R.id.recipes);
                cardView = holder.findViewById(R.id.food_holder);

            }
        }

    }

