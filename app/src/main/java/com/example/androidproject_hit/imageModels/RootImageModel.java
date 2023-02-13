package com.example.androidproject_hit.imageModels;

import android.util.proto.ProtoOutputStream;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RootImageModel {

    @SerializedName("LARGE")
    @Expose
    private LargeImage largeImage;

    @SerializedName("NORMAL")
    @Expose
    private NormalImage normalImage;

    @SerializedName("SMALL")
    @Expose
    private SmallImage smallImage;

    @SerializedName("THUMBNAIL")
    @Expose
    private ThumbNail thumbNail;

    public RootImageModel(LargeImage largeImage, NormalImage normalImage, SmallImage smallImage, ThumbNail thumbNail) {
        this.largeImage = largeImage;
        this.normalImage = normalImage;
        this.smallImage = smallImage;
        this.thumbNail = thumbNail;
    }

    public LargeImage getLargeImage() {
        return largeImage;
    }

    public NormalImage getNormalImage() {
        return normalImage;
    }

    public SmallImage getSmallImage() {
        return smallImage;
    }

    public ThumbNail getThumbNail() {
        return thumbNail;
    }
}
