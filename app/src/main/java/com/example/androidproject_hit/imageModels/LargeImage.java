package com.example.androidproject_hit.imageModels;

public class LargeImage {
    private String url;
    private int width;
    private int hight;

    public LargeImage(String url, int width, int hight) {
        this.url = url;
        this.width = width;
        this.hight = hight;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return hight;
    }
}
