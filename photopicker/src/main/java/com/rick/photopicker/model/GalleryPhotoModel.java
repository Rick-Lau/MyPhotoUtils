package com.rick.photopicker.model;

import android.support.annotation.DrawableRes;

import java.io.Serializable;

/**
 * Created by Rick.Lau on 2020/1/13 9:54.
 */

public class GalleryPhotoModel implements Serializable {

    public Object photoSource;

    public GalleryPhotoModel(@DrawableRes int drawableRes) {
        this.photoSource = drawableRes;
    }

    public GalleryPhotoModel(String path) {
        this.photoSource = path;
    }

}
