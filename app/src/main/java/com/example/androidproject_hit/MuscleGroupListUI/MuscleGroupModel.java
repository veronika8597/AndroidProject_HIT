package com.example.androidproject_hit.MuscleGroupListUI;

public class MuscleGroupModel {

    String exerciseTypeName;
    String exerciseDescription;
    String muscleGroupName;
    int GIF;
    int image;

    public MuscleGroupModel(String muscleGroupName, String exerciseTypeName, String exerciseDescription, int GIF, int image) {
        this.exerciseTypeName = exerciseTypeName;
        this.exerciseDescription = exerciseDescription;
        this.muscleGroupName = muscleGroupName;
        this.GIF = GIF;
        this.image = image;
    }

    public String getMuscleGroupName() {
        return muscleGroupName;
    }

    public int getImage() {
        return image;
    }

    public String getExerciseTypeName() {
        return exerciseTypeName;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public int getGIF() {
        return GIF;
    }
}
