package com.example.androidproject_hit.MuscleGroupListUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject_hit.AerobicExerciseListUI.TimerFragments.TenMinFragment;
import com.example.androidproject_hit.AerobicExerciseListUI.TimerFragments.TwentyMinFragment;
import com.example.androidproject_hit.MuscleGroupListUI.TimerFragments2.FiveMinFragment;
import com.example.androidproject_hit.MuscleGroupListUI.TimerFragments2.ThreeMinFragment;
import com.example.androidproject_hit.R;

public class AnaerobicExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaerobic_exercise);

        Button FiveMin_Button;
        Button ThreeMin_Button;

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int GIF = getIntent().getIntExtra("GIF",0);

        TextView nameTextView = findViewById(R.id.Ex_Title1);
        TextView descriptionTextView = findViewById(R.id.Ex_Description1);
        ImageView GIF_gifView = findViewById(R.id.Ex_GIF1);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        GIF_gifView.setImageResource(GIF);

        ThreeMin_Button = findViewById(R.id.button_3min);
        FiveMin_Button= findViewById(R.id.button_5min);

        FiveMin_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.exercisePage2, new FiveMinFragment()).commit();
            }
        });

        ThreeMin_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.exercisePage2, new ThreeMinFragment()).commit();
            }
        });

    }
}