package com.example.androidproject_hit.AerobicExerciseListUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidproject_hit.R;
import com.example.androidproject_hit.RecyclerViewInterface;

import java.util.ArrayList;

public class MainAerobicExerciseTypeListActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<AerobicExerciseTypeModel> aerobicExerciseTypeModels = new ArrayList<>();

    int[] aerobicExerciseImages = {R.drawable.running, R.drawable.cycling,
            R.drawable.jumping_rope, R.drawable.stair_climb, R.drawable.burpees};

    int[] aerobicExerciseGIF = {R.drawable.run_exercise_illustration,
            R.drawable.bicycle_crunches_exercise_illustration, R.drawable.jump_rope_exercise_illustration,
            R.drawable.step_up_exercise_illustration, R.drawable.burpees_exercise_illustration};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_exercise_type_list);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView2);

        setUpAerobicExerciseTypeModel();

        MAE_RecyclerViewAdapter adapter = new MAE_RecyclerViewAdapter(this, aerobicExerciseTypeModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpAerobicExerciseTypeModel() {

        String[] aerobicExerciseTypeNames = getResources().getStringArray(R.array.aerobic_exercises);
        String[] aerobicExerciseTypeDesc = getResources().getStringArray(R.array.Description_Of_AerobicEx_txt);

        for(int i = 0; i < aerobicExerciseTypeNames.length; i++)
        {
            aerobicExerciseTypeModels.add(new AerobicExerciseTypeModel(aerobicExerciseTypeNames[i], aerobicExerciseTypeDesc[i],
                    aerobicExerciseGIF[i], aerobicExerciseImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainAerobicExerciseTypeListActivity.this, AerobicExerciseActivity.class);

        intent.putExtra("NAME", aerobicExerciseTypeModels.get(position).getExerciseTypeName());
        intent.putExtra("GIF", aerobicExerciseTypeModels.get(position).getGIF());
        intent.putExtra("DESCRIPTION", aerobicExerciseTypeModels.get(position).getExerciseDescription());

        startActivity(intent);
    }
}