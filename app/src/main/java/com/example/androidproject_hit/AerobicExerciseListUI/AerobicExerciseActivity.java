package com.example.androidproject_hit.AerobicExerciseListUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject_hit.R;

public class AerobicExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aerobic_exercise);

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int GIF = getIntent().getIntExtra("GIF",0);

        TextView nameTextView = findViewById(R.id.Ex_Title);
        TextView descriptionTextView = findViewById(R.id.Ex_Description);
        ImageView GIF_gifView = findViewById(R.id.Ex_GIF);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        GIF_gifView.setImageResource(GIF);
    }
}