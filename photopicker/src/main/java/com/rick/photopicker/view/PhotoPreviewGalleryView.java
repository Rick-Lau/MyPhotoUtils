package com.rick.photopicker.view;

import android.content.Context;
import android.graphics.Canvas;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.rick.photopicker.model.PhotoInfo;

/**
 * Created by Rick.Lau on 2020/1/13 9:57.
 */

public class PhotoPreviewGalleryView extends PhotoView {


    public PhotoPreviewGalleryView(Context context, PhotoInfo photoInfo) {
        super(context);
        Glide.with(getContext()).load(photoInfo.getPhotoPath()).into(PhotoPreviewGalleryView.this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
