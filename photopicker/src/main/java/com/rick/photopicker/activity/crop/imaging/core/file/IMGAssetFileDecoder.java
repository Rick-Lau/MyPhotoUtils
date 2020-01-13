package com.rick.photopicker.activity.crop.imaging.core.file;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * author： Rick.Lau
 * time： 2020/1/13
 * E-mail：rick.lau.effort@gmail.com
 * description：
 * version:
 */


public class IMGAssetFileDecoder extends IMGDecoder {

    private Context mContext;

    public IMGAssetFileDecoder(Context context, Uri uri) {
        super(uri);
        mContext = context;
    }

    public Bitmap decode(BitmapFactory.Options options) {
        Uri uri = getUri();
        if (uri == null) {
            return null;
        }

        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }

        path = path.substring(1);

        try {
            InputStream iStream = mContext.getAssets().open(path);
            return BitmapFactory.decodeStream(iStream, null, options);
        } catch (IOException ignore) {

        }

        return null;
    }
}
