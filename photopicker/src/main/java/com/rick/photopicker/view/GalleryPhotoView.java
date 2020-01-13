package com.rick.photopicker.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.rick.photopicker.R;
import com.rick.photopicker.photointerface.GalleryPhotoInterface;

/**
 * Created by Rick.Lau on 2020/1/13 9:56.
 */

public class GalleryPhotoView extends RelativeLayout {

    private MyPhotoView myPhotoView;
    private ProgressBar progressBar;
    private OnPhotoViewClickListener photoViewClickListener;

    public void setPhotoViewClickListener(OnPhotoViewClickListener listener) {
        photoViewClickListener = listener;
    }


    public GalleryPhotoView(final Context context, final GalleryPhotoInterface photoModel) {
        super(context);
        initView(context);
        myPhotoView.setPhotoModel(context, photoModel);
        myPhotoView.setPhotoLoadListener(new MyPhotoView.OnPhotoLoadListener() {
            @Override
            public void onPhotoLoadComplete() {
                progressBar.setVisibility(GONE);
            }

            @Override
            public void onPhotoLoadFail() {
                progressBar.setVisibility(GONE);
                Toast.makeText(context, "图片加载失败", Toast.LENGTH_SHORT).show();
            }
        });
        myPhotoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (photoViewClickListener != null) {
                    photoViewClickListener.onPhotoViewClick();
                }
            }
        });
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.photo_picker_view_gallery, this);
        progressBar = this.findViewById(R.id.photo_picker_view_gallery_progressbar);
        myPhotoView = this.findViewById(R.id.photo_picker_view_gallery_my_photo_view);
    }

    public void startGlide() {
        if (myPhotoView != null) {
            myPhotoView.startGlide();
        }
    }

    public interface OnPhotoViewClickListener {
        void onPhotoViewClick();
    }

}
