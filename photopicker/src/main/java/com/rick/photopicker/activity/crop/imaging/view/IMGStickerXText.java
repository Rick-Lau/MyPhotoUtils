package com.rick.photopicker.activity.crop.imaging.view;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.TypedValue;

import com.rick.photopicker.activity.crop.imaging.core.IMGText;
import com.rick.photopicker.activity.crop.imaging.core.sticker.IMGStickerX;

/**
 * Created by Rick.Lau on 2020/1/13 9:47.
 */


public class IMGStickerXText extends IMGStickerX {

    private IMGText mText;

    private StaticLayout mTextLayout;

    private TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    public IMGStickerXText(IMGText text) {
        // 字体大小 22sp
        mTextPaint.setTextSize(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 22, Resources.getSystem().getDisplayMetrics()));

        setText(text);
    }

    public void setText(IMGText text) {
        mText = text;

        mTextPaint.setColor(text.getColor());
        mTextLayout = new StaticLayout(text.getText(), mTextPaint,
                Math.round(Resources.getSystem().getDisplayMetrics().widthPixels * 0.8f),
                Layout.Alignment.ALIGN_NORMAL, 1f, 0, false);

        float width = 0f;
        for (int i = 0; i < mTextLayout.getLineCount(); i++) {
            width = Math.max(width, mTextLayout.getLineWidth(i));
        }

        onMeasure(width, mTextLayout.getHeight());
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(mFrame.left, mFrame.top);
        mTextLayout.draw(canvas);
        canvas.restore();
    }
}
