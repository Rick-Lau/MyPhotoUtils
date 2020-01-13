package com.rick.photopicker.activity.crop.imaging.core.elastic;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by Rick.Lau on 2020/1/13 9:42.
 */


public class IMGPointFEvaluator implements TypeEvaluator<PointF> {

    private PointF mPoint;

    public IMGPointFEvaluator() {

    }

    public IMGPointFEvaluator(PointF reuse) {
        mPoint = reuse;
    }

    @Override
    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
        float x = startValue.x + (fraction * (endValue.x - startValue.x));
        float y = startValue.y + (fraction * (endValue.y - startValue.y));

        if (mPoint != null) {
            mPoint.set(x, y);
            return mPoint;
        } else {
            return new PointF(x, y);
        }
    }
}
