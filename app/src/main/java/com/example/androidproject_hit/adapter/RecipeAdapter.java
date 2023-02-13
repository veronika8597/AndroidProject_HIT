package com.example.androidproject_hit.adapter;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.androidproject_hit.Models.RootObjectModel;
import com.example.androidproject_hit.R;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.FoodViewHolder>{

    private final Context context;
    private final ArrayList<RootObjectModel>recipes;

    public RecipeAdapter(Context context, ArrayList<RootObjectModel> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_entries, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        holder.lable.setText("Label\t"+recipes.get(position).getRecipeModel().getLabel());
        holder.source.setText("Source\t"+recipes.get(position).getRecipeModel().getSource());
        holder.yield.setText("Yield\t"+recipes.get(position).getRecipeModel().getYield());
        holder.calories.setText("Calories\t"+recipes.get(position).getRecipeModel().getCalories());
        holder.weight.setText("Weight\t"+recipes.get(position).getRecipeModel().getTotalWeight());
            Glide.with(holder.itemView.getContext()).load(recipes.get(position).getRecipeModel().getImage())
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        if(recipes != null)
        {
            return recipes.size();
        }
        return 0;
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder{
        TextView lable, source, yield, calories, weight;
        ImageView imageView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            lable = itemView.findViewById(R.id.textLable);
            source = itemView.findViewById(R.id.textSource);
            yield = itemView.findViewById(R.id.textYield);
            calories = itemView.findViewById(R.id.textCalories);
            weight = itemView.findViewById(R.id.textWeight);
            imageView = itemView.findViewById(R.id.recipeImage);

        }
    }
}
