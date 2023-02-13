package com.example.androidproject_hit.Models;

import com.example.androidproject_hit.imageModels.RootImageModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeModel {
    private String label;
    private String image;
    private String source;
    private float yield;
    private float calories;
    private float totalWeight;
    @SerializedName("images")
    @Expose()
    private RootImageModel rootImageModel;

    public RecipeModel() {
    }

    public RecipeModel(String label, String image, String source, float yield, float calories, float totalWeight, RootImageModel rootImageModel) {
        this.label = label;
        this.image = image;
        this.source = source;
        this.yield = yield;
        this.calories = calories;
        this.totalWeight = totalWeight;
        this.rootImageModel = rootImageModel;
    }

    public String getLabel() {
        return label;
    }

    public String getImage() {
        return image;
    }

    public String getSource() {
        return source;
    }

    public float getYield() {
        return yield;
    }

    public float getCalories() {
        return calories;
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public RootImageModel getRootImageModel() {
        return rootImageModel;
    }
}
