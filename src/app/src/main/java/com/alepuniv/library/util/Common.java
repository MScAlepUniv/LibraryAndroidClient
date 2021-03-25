package com.alepuniv.library.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.alepuniv.library.R;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedDrawable;
import com.makeramen.roundedimageview.RoundedImageView;

import com.theartofdev.edmodo.cropper.CropImage;

import java.io.ByteArrayOutputStream;

public class Common
{
    public static int currentCategoryId = -1;

    ///region Permissions Requests

    public static final int EXTERNAL_REQUEST_PERMISSION = 500;

    ///endregion

    ///region Requests Code

    public static final int GALLERY_REQUEST_CODE = 200;

    ///endregion

    ///region Permissions

    ///region External

    public static boolean isPermissionsExternalGranted(Context context)
    {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestRuntimePermissionsExternal(Activity activity)
    {
        ActivityCompat.requestPermissions(
                activity,
                new String[] { Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE },
                EXTERNAL_REQUEST_PERMISSION);
    }

    public static void requestRuntimePermissionsExternal(Fragment fragment)
    {
        fragment.requestPermissions(
                new String[] { Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE },
                EXTERNAL_REQUEST_PERMISSION);
    }

    ///endregion

    ///endregion

    ///region Images

    public static void loadImage(Context context, byte[] image, ImageView imageView)
    {
        Glide
                .with(context)
                .load(image)
                .centerCrop()
                .placeholder(R.drawable.img_book)
                .into(imageView);
    }

    public static byte[] getBytesFromImageView(ImageView imageView)
    {
        Bitmap bitmap = null;
        if (imageView instanceof RoundedImageView)
        {
            bitmap = ((RoundedDrawable) imageView.getDrawable()).toBitmap();
        }
        else
        {
            bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void openGallery(Activity activity)
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        activity.startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    public static void openGallery(Fragment fragment)
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        fragment.startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    public static void cropImageWithImageCropper(Activity activity, Uri imageUri)
    {
        CropImage.activity(imageUri)
                .setAspectRatio(1, 1)
                .setMinCropWindowSize(500, 500)
                .start(activity);
    }

    public static void cropImageWithImageCropper(Context context, Fragment fragment, Uri imageUri)
    {
        CropImage.activity(imageUri)
                .setAspectRatio(1, 1)
                .setMinCropWindowSize(500, 500)
                .start(context, fragment);
    }

    ///endregion
}
