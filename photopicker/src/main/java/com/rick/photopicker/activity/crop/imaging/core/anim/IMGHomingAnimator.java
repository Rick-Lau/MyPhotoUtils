package com.rick.photopicker.activity.crop.imaging.core.anim;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.rick.photopicker.activity.crop.imaging.core.homing.IMGHoming;
import com.rick.photopicker.activity.crop.imaging.core.homing.IMGHomingEvaluator;

/**
 * author： Rick.Lau
 * time： 2020/1/13
 * E-mail：rick.lau.effort@gmail.com
 * description：
 * version:
 */

public class IMGHomingAnimator extends ValueAnimator {

    private boolean isRotate = false;

    private IMGHomingEvaluator mEvaluator;

    public IMGHomingAnimator() {
        setInterpolator(new AccelerateDecelerateInterpolator());
    }

    @Override
    public void setObjectValues(Object... values) {
        super.setObjectValues(values);
        if (mEvaluator == null) {
            mEvaluator = new IMGHomingEvaluator();
        }
        setEvaluator(mEvaluator);
    }

    public void setHomingValues(IMGHoming sHoming, IMGHoming eHoming) {
        setObjectValues(sHoming, eHoming);
        isRotate = IMGHoming.isRotate(sHoming, eHoming);
    }

    public boolean isRotate() {
        return isRotate;
    }
}
