package com.example.orderf_ood.core.handler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadImageTaskHandler extends AsyncTask<String, Void, Bitmap> {
    private static final String CLASS_NAME = DownloadImageTaskHandler.class.getName();
    ImageView imageView;

    public DownloadImageTaskHandler(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String urlImage = strings[0];
        Bitmap bitmapResult = null;
        try {
            InputStream inputStream = new URL(urlImage).openStream();
            bitmapResult = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            Log.e(CLASS_NAME, "Error download image " + e.getMessage());
            e.printStackTrace();
        }
        return bitmapResult;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
