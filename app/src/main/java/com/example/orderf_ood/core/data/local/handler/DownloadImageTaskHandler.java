package com.example.orderf_ood.core.data.local.handler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadImageTaskHandler extends AsyncTask<String,Void, Bitmap> {

     private static final String CLASS_NAME = DownloadImageTaskHandler.class.getName();
     ImageView mImageView;
     public DownloadImageTaskHandler(ImageView imageView){
         this.mImageView = imageView;
     }
    @Override
    protected Bitmap doInBackground(String... strings) {
         String UrlImage = strings[0];
         Bitmap bitmapResult = null;
        InputStream inputStream = null;
        try {
            inputStream = new URL(UrlImage).openStream();
        } catch (IOException e) {
            Log.e(CLASS_NAME, "Error downlload image " +e.getMessage());
            e.printStackTrace();
        }
        bitmapResult = BitmapFactory.decodeStream(inputStream);

        return bitmapResult;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(bitmap != null){
            mImageView.setImageBitmap(bitmap);
        }
    }
}