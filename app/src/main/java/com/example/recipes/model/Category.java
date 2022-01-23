package com.example.recipes.model;

public class Category {
    String name;
    int category;
    Integer imageurl;

    public Category(int category, String name, Integer imageurl) {
        this.category = category;
        this.name = name;
        this.imageurl = imageurl;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }
}
