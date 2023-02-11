package com.example.androidproject_hit.AerobicExerciseListUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject_hit.AerobicExerciseListUI.TimerFragments.TenMinFragment;
import com.example.androidproject_hit.AerobicExerciseListUI.TimerFragments.ThirtyMinFragment;
import com.example.androidproject_hit.AerobicExerciseListUI.TimerFragments.TwentyMinFragment;
import com.example.androidproject_hit.R;

public class AerobicExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aerobic_exercise);

        Button TenMin_Button;
        Button TwentyMin_Button;
        Button ThirtyMin_Button;

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int GIF = getIntent().getIntExtra("GIF",0);

        TextView nameTextView = findViewById(R.id.Ex_Title);
        TextView descriptionTextView = findViewById(R.id.Ex_Description);
        ImageView GIF_gifView = findViewById(R.id.Ex_GIF);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        GIF_gifView.setImageResource(GIF);

        TenMin_Button = findViewById(R.id.button_10min);
        TwentyMin_Button = findViewById(R.id.button_20min);
        ThirtyMin_Button = findViewById(R.id.button_30min);


        TenMin_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.exercisePage, new TenMinFragment()).commit();
            }
        });

        TwentyMin_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.exercisePage, new TwentyMinFragment()).commit();
            }
        });

        ThirtyMin_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.exercisePage, new ThirtyMinFragment()).commit();
            }
        });




    }
}