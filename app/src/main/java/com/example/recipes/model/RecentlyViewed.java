package com.example.recipes.model;

public class RecentlyViewed {

    String nametext, nametext1, nametext2, video;
    int imageView;

    public RecentlyViewed(String nametext, String nametext1, String nametext2, String video, int imageView) {
        this.nametext = nametext;
        this.nametext1 = nametext1;
        this.nametext2 = nametext2;
        this.video = video;
        this.imageView = imageView;
    }

    public String getNametext() {
        return nametext;
    }

    public void setNametext(String nametext) {
        this.nametext = nametext;
    }

    public String getNametext1() {
        return nametext1;
    }

    public void setNametext1(String nametext1) {
        this.nametext1 = nametext1;
    }

    public String getNametext2() {
        return nametext2;
    }

    public void setNametext2(String nametext2) {
        this.nametext2 = nametext2;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
