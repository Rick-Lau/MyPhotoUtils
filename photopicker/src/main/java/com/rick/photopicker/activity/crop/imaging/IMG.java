package com.rick.photopicker.activity.crop.imaging;

import android.content.Context;

/**
 * Created by Rick.Lau on 2020/1/13 9:47.
 */

public class IMG {

    private static Context mApplicationContext;

    public static void initialize(Context context) {
        mApplicationContext = context.getApplicationContext();

    }

    public static class Config {

        private boolean isSave;

    }
}
