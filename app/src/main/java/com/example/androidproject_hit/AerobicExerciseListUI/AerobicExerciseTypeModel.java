package com.example.androidproject_hit.AerobicExerciseListUI;

public class AerobicExerciseTypeModel {

    String exerciseTypeName;
    String exerciseDescription;
    int GIF;
    int image;

    public AerobicExerciseTypeModel(String exerciseTypeName, String exerciseDescription, int GIF, int image) {
        this.exerciseTypeName = exerciseTypeName;
        this.exerciseDescription = exerciseDescription;
        this.GIF = GIF;
        this.image = image;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public int getGIF() {
        return GIF;
    }

    public String getExerciseTypeName() {
        return exerciseTypeName;
    }

    public int getImage() {
        return image;
    }
}
