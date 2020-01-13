package com.rick.photopicker.activity.crop.imaging.core.file;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

/**
 * Created by Rick.Lau on 2020/1/13 9:43.
 */

public abstract class IMGDecoder {

    private Uri uri;

    public IMGDecoder(Uri uri) {
        this.uri = uri;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Bitmap decode() {
        return decode(null);
    }

    public abstract Bitmap decode(BitmapFactory.Options options);

}
