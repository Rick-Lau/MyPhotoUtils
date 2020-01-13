package com.rick.photopicker.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.rick.photopicker.R;
import com.rick.photopicker.model.GalleryPhotoParameterModel;
import com.rick.photopicker.photointerface.GalleryPhotoInterface;
import com.rick.photopicker.util.GalleryViewUtil;
import com.rick.photopicker.view.GalleryView;

import java.io.Serializable;
import java.util.List;
/**
 * author： Rick.Lau
 * time： 2020/1/13
 * E-mail：rick.lau.effort@gmail.com
 * description：
 * version:
 */

public class GalleryViewActivity extends FragmentActivity {

    private GalleryView galleryView;
    private static final String LIST_GALLERY_PHOTO = "LIST_GALLERY_PHOTO";
    private static final String GALLERY_PHOTO_PARAMETER_MODEL = "GALLERY_PHOTO_PARAMETER_MODEL";
    private static final String IS_FULL_SCREEN = "IS_FULL_SCREEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().getBoolean(IS_FULL_SCREEN,false)){
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        }
        setContentView(R.layout.photo_picker_activity_gallery_view);
        galleryView = findViewById(R.id.activity_gallery_view);
        galleryView.setGalleryViewFadedListener(new GalleryView.OnGalleryViewFadedListener() {
            @Override
            public void onGalleryViewFaded() {
                finish();
            }
        });
        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().getSerializable(LIST_GALLERY_PHOTO) != null && getIntent().getExtras().getSerializable(GALLERY_PHOTO_PARAMETER_MODEL) != null) {
                galleryView.showPhotoGallery((List<GalleryPhotoInterface>)(getIntent().getExtras().getSerializable(LIST_GALLERY_PHOTO)), (GalleryPhotoParameterModel)(getIntent().getExtras().getSerializable(GALLERY_PHOTO_PARAMETER_MODEL)));
            } else {
                finish();
            }
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /**
     *
     * @param context           上下文
     * @param photoList         需要展示的图片的集合
     * @param position          点击的图片所在集合中的index值
     * @param clickImage        点击的图片view（要求ImageView）
     * @param isFullScreen      是否全屏展示
     */
    public static void launch (Context context, List<? extends GalleryPhotoInterface> photoList, int position, ImageView clickImage, boolean isFullScreen) {
        GalleryViewActivity.launch(context, photoList, GalleryViewUtil.getGalleryPhotoParameterModel(position, photoList.get(position).getPhotoResource(), clickImage), isFullScreen);
    }



    public static void launch (Context context, List<? extends GalleryPhotoInterface> photoList, GalleryPhotoParameterModel photoParameter, boolean isFullScreen) {
        Intent intent = new Intent(context, GalleryViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(LIST_GALLERY_PHOTO, (Serializable) photoList);
        bundle.putSerializable(GALLERY_PHOTO_PARAMETER_MODEL, photoParameter);
        bundle.putBoolean(IS_FULL_SCREEN, isFullScreen);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
