package com.rick.photopicker.activity.preview;

import android.os.Bundle;

import com.rick.photopicker.model.PhotoInfo;

import java.util.List;

/**
 * Created by Rick.Lau on 2020/1/13 9:49.
 */


public class PhotoPreviewContract {

    interface View {
        void onGetBigPicturePreviewData(List<PhotoInfo> bigPictureData, int selectedPosition);
        void onGetThumbnailPreviewData(List<PhotoInfo> thumbnailData, int selectedPosition);
    }

    interface Presenter {
        void getPhotoPreviewData(Bundle bundle);
    }

}
