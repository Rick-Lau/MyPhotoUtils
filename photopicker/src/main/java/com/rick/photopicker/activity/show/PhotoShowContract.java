package com.rick.photopicker.activity.show;

import android.app.Activity;
import android.content.Context;


import com.rick.photopicker.model.PhotoFolderInfo;
import com.rick.photopicker.model.PhotoInfo;

import java.util.List;

/**
 * Created by Rick.Lau on 2020/1/13 9:50.
 */

public class PhotoShowContract {

    interface View {
        void onGetPhotoListSuccess(List<PhotoFolderInfo> photoList);
        void onHandleCropPhotoSuccess(List<PhotoFolderInfo> photoList);
    }

    interface Presenter {
        void getPhotoList(Activity activity);
        void handleCropPhoto(Context context, String oldPhotoPath, PhotoInfo replacePhoto);
    }

}
