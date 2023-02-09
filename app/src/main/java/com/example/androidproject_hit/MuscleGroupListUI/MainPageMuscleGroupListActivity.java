package com.example.androidproject_hit.MuscleGroupListUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidproject_hit.R;
import com.example.androidproject_hit.RecyclerViewInterface;

import java.util.ArrayList;

public class MainPageMuscleGroupListActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<MuscleGroupModel> muscleGroupModels = new ArrayList<>();

    int[] muscleGroupImages = {R.drawable.image, R.drawable.arm_image,
            R.drawable.chest_image, R.drawable.abs_image, R.drawable.leg_image};

    int[] anaerobicExerciseGIF = {R.drawable.bent_over_row_illustration, R.drawable.biceps_curl_exercise_illustration,
            R.drawable.dumbbell_pullover_exercise_illustration, R.drawable.crunches_exercise_illustration,
            R.drawable.squat_exercise_illustration};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_musclegroup_list);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView1);

        setUpMuscleGroupModel();

        MG_RecyclerViewAdapter adapter = new MG_RecyclerViewAdapter(this, muscleGroupModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void setUpMuscleGroupModel(){
        String[] muscleGroupNames = getResources().getStringArray(R.array.muscle_group);
        String[] aerobicExerciseTypeNames = getResources().getStringArray(R.array.anaerobic_exercises);
        String[] aerobicExerciseTypeDesc = getResources().getStringArray(R.array.Description_Of_AnaerobicEx_txt);

        for (int i =0; i<muscleGroupNames.length; i++)
        {
            muscleGroupModels.add(new MuscleGroupModel(muscleGroupNames[i], aerobicExerciseTypeNames[i],
                    aerobicExerciseTypeDesc[i], anaerobicExerciseGIF[i], muscleGroupImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent  intent = new Intent(MainPageMuscleGroupListActivity.this, AnaerobicExerciseActivity.class);

        intent.putExtra("NAME", muscleGroupModels.get(position).getExerciseTypeName());
        intent.putExtra("GIF", muscleGroupModels.get(position).getGIF());
        intent.putExtra("DESCRIPTION", muscleGroupModels.get(position).getExerciseDescription());

        startActivity(intent);


    }
}