package com.rick.photopicker.activity.crop.imaging.core.file;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;

import java.io.File;

/**
 * Created by Rick.Lau on 2020/1/13 9:43.
 */


public class IMGFileDecoder extends IMGDecoder {

    public IMGFileDecoder(Uri uri) {
        super(uri);
    }

    @Override
    public Bitmap decode(BitmapFactory.Options options) {
        Uri uri = getUri();
        if (uri == null) {
            return null;
        }

        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }

        File file = new File(path);
        if (file.exists()) {
            return BitmapFactory.decodeFile(path, options);
        }

        return null;
    }
}
