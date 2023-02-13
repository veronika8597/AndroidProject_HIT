package com.example.androidproject_hit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidproject_hit.AerobicExerciseListUI.MainAerobicExerciseTypeListActivity;
import com.example.androidproject_hit.MuscleGroupListUI.MainPageMuscleGroupListActivity;

public class TrainingType extends AppCompatActivity {

    Button Anaerobic;
    Button Aerobic;
    Button Nutrition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_type);

        Anaerobic = findViewById(R.id.buttonAnaerobic);
        Aerobic = findViewById(R.id.buttonAerobic);
        Nutrition = findViewById(R.id.buttonNutrition);


        Anaerobic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrainingType.this, MainPageMuscleGroupListActivity.class);
                startActivity(intent);
            }
        });

        Aerobic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrainingType.this, MainAerobicExerciseTypeListActivity.class);
                startActivity(intent);
            }
        });

        Nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrainingType.this, NutritionMainActivity.class);
                startActivity(intent);
            }
        });
    }
}