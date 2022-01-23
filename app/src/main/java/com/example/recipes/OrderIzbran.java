package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.recipes.model.FoodItem;
import com.example.recipes.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderIzbran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_izbran);

        Utils.changeStatusBarAndNavigationBarColor(OrderIzbran.this, R.color.mirage, R.color.mirage_dark);

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> izbranTitle = new ArrayList<>();
        for (FoodItem c: MainActivity.fullfoodItemList){
            if (Order.items_id.contains(c.getId()))

              izbranTitle.add(c.getName());


        }
        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Order.items_id.toArray()));
    }
}