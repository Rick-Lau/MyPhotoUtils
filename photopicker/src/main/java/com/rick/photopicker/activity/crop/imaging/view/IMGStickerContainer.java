package com.rick.photopicker.activity.crop.imaging.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Rick.Lau on 2020/1/13 9:46.
 */

public class IMGStickerContainer extends ViewGroup {

    public IMGStickerContainer(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() == 1) {
            View child = getChildAt(0);
            if (child != null) {
                child.layout(
                        (l + r) >> 1 - (child.getMeasuredWidth() >> 1),
                        (t + b) >> 1 - (child.getMeasuredHeight() >> 1),
                        (l + r) >> 1 + (child.getMeasuredWidth() >> 1),
                        (t + b) >> 1 + (child.getMeasuredHeight() >> 1)
                );
            }
        }
    }
}
