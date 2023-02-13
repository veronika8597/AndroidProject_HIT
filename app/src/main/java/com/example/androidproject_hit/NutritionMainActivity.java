package com.example.androidproject_hit;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.util.Log;

import com.example.androidproject_hit.Models.RecipeModel;
import com.example.androidproject_hit.Models.RootObjectModel;
import com.example.androidproject_hit.adapter.RecipeAdapter;
import com.example.androidproject_hit.apis.APIClient;
import com.example.androidproject_hit.response.SearchRecipes;
import com.example.androidproject_hit.utils.APICredentials;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NutritionMainActivity extends AppCompatActivity {
    private  static final String TAG = "\t"+NutritionMainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private ArrayList<RootObjectModel>recipes;
    private RecipeAdapter adapter;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_main);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecipeAdapter(NutritionMainActivity.this, recipes);
        recyclerView.setLayoutManager(new LinearLayoutManager(NutritionMainActivity.this));
        recyclerView.setAdapter(adapter); // set the adapter first
        recyclerView.setHasFixedSize(true);

        searchView= findViewById(R.id.searchRecipe);
        searchView.setQueryHint("Search");
        searchView.onActionViewCollapsed();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchRecipes(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchRecipes(newText);
                return true;
            }
        });
    }

    private void searchRecipes(String query)
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APICredentials.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        APIClient apiClient = retrofit.create(APIClient.class);

        Call<SearchRecipes> searchRecipesCall = apiClient.searchRecipes(APICredentials.TYPE, query,
                APICredentials.APP_ID, APICredentials.API_KEY);


        searchRecipesCall.enqueue(new Callback<SearchRecipes>() {
            @Override
            public void onResponse(@NonNull Call<SearchRecipes> call, @NonNull Response<SearchRecipes> response) {
                if((response.isSuccessful()) && (response.body() != null))
                {
                    recipes = new ArrayList<>(Arrays.asList(response.body().getFoodRecipes()));

                    for(int i = 0; i < recipes.size(); i++)
                    {
                        RootObjectModel rootObjectModel = recipes.get(i);
                        recipes.add(rootObjectModel);
                        Log.d("Tag"+ TAG, "label"+rootObjectModel.getRecipeModel().getLabel());

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<SearchRecipes> call, @NonNull Throwable t) {
                Log.d("Tag"+ TAG, "onFailure()" + t.getMessage());
            }
        });
    }
}
