package com.rick.photopicker.activity.crop.imaging.core.sticker;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by Rick.Lau on 2020/1/13 9:44.
 */

public interface IMGStickerPortrait {

    boolean show();

    boolean remove();

    boolean dismiss();

    boolean isShowing();

    RectF getFrame();

//    RectF getAdjustFrame();
//
//    RectF getDeleteFrame();

    void onSticker(Canvas canvas);

    void registerCallback(IMGSticker.Callback callback);

    void unregisterCallback(IMGSticker.Callback callback);

    interface Callback {

        <V extends View & IMGSticker> void onDismiss(V stickerView);

        <V extends View & IMGSticker> void onShowing(V stickerView);

        <V extends View & IMGSticker> boolean onRemove(V stickerView);
    }
}
