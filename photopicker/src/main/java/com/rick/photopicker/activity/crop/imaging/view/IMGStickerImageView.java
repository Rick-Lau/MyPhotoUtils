package com.rick.photopicker.activity.crop.imaging.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.rick.photopicker.R;

/**
 * Created by Rick.Lau on 2020/1/13 9:46.
 */

public class IMGStickerImageView extends IMGStickerView {

    private ImageView mImageView;

    public IMGStickerImageView(Context context) {
        super(context);
    }

    public IMGStickerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IMGStickerImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public View onCreateContentView(Context context) {
        mImageView = new ImageView(context);
        mImageView.setImageResource(R.mipmap.ic_launcher);
        return mImageView;
    }
}
