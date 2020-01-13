package com.rick.photopicker.util;

import android.content.Context;

/**
 * Created by Rick.Lau on 2020/1/13 9:55.
 */

public class DipPxUtils {

    public static int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5F);
    }

    public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(spValue * fontScale + 0.5F);
    }

}
