package com.dewan.bitmapconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;

import com.dewan.bitmaphelper.BitmapHelper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ImageView test_image;
    private Drawable drawable;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test_image = findViewById(R.id.test_image);
        drawable = test_image.getDrawable();

        /*
        example how to use the helper class
         */

        bitmap = BitmapHelper.convertDrawableToBitmap(drawable,100,100);
        String base64 = BitmapHelper.convertBitmapToBase64(bitmap);
        bitmap = BitmapHelper.convertBase64ToBitmap(base64);
        test_image.setImageBitmap(bitmap);


    }


}
