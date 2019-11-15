package com.dewan.bitmaphelper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class BitmapHelper {

    public static Bitmap convertDrawableToBitmap(Drawable drawable, int width, int height){
        Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0,width,height);
        drawable.draw(canvas);

        return bitmap;
    }

    public static String convertBitmapToBase64(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        return Base64.encodeToString(byteArray,Base64.DEFAULT);
    }

    public static Bitmap convertBase64ToBitmap(String base64){
        byte[] byteArray = Base64.decode(base64,Base64.NO_WRAP);
        return BitmapFactory.decodeByteArray(byteArray,0,base64.length());
    }
}
