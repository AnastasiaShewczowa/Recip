package com.example.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recipes.model.Order;

public class ProductDetalls extends AppCompatActivity {

    String name, ingred,recipes;

    ImageView img, back;
    TextView proname, proname1, proname2;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        Utils.changeStatusBarAndNavigationBarColor(ProductDetalls.this, R.color.mirage, R.color.mirage);


        Intent i = getIntent();

        name = i.getStringExtra("name");
        image = i.getIntExtra("food_image", R.drawable.popular1);
        ingred = i.getStringExtra("ingred");
        recipes = i.getStringExtra("recipes");



        proname = findViewById(R.id.nametext);
        proname1 = findViewById(R.id.nametext1);
        proname2 = findViewById(R.id.nametext2);
        img = findViewById(R.id.imageView);
        back = findViewById(R.id.back);

        proname.setText(name);
        proname1.setText(ingred);
        proname2.setText(recipes);
        img.setImageResource(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDetalls.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void addToCart(View view){
        String items_id = getIntent().getStringExtra("name");
        Order.items_id.add(items_id);

        Toast.makeText(this, "Добавлено! ", Toast.LENGTH_SHORT).show();
    }



}
