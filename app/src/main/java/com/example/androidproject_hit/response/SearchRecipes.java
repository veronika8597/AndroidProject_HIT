package com.example.androidproject_hit.response;

import androidx.annotation.NonNull;

import com.example.androidproject_hit.Models.RootObjectModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchRecipes {
    private int from;
    private int to;
    private int count;

    @SerializedName("hits")
    @Expose()
    private RootObjectModel[] foodRecipes;

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCount() {
        return count;
    }

    public RootObjectModel[] getFoodRecipes() {
        return foodRecipes;
    }

    @NonNull
    @Override
    public String toString() {
        return "Recipes{" + "Recipes=\t" + foodRecipes + "from = \t" + from
                + "to = \t" + to + "totalCount =\t" + count+"}";
    }
}
