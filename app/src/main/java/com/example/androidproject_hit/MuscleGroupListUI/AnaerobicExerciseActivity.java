package com.example.androidproject_hit.MuscleGroupListUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject_hit.R;

public class AnaerobicExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaerobic_exercise);

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int GIF = getIntent().getIntExtra("GIF",0);

        TextView nameTextView = findViewById(R.id.Ex_Title1);
        TextView descriptionTextView = findViewById(R.id.Ex_Description1);
        ImageView GIF_gifView = findViewById(R.id.Ex_GIF1);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        GIF_gifView.setImageResource(GIF);
    }
}