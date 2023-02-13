package com.example.androidproject_hit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RootObjectModel {

    @SerializedName("recipe")
    @Expose()
    private RecipeModel recipeModel;

    public RootObjectModel() {
        this.recipeModel = recipeModel;
    }

    public RecipeModel getRecipeModel() {
        return recipeModel;
    }

/*    public void setRecipeModel(RootObjectModel recipeModel) {
        this.recipeModel = recipeModel;
    }*/
}
