package com.closette;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ClosetteMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closette_main);
        
        final LinearLayout topGallery = (LinearLayout) findViewById(R.id.topgallery);
        String galleryDirectoryName = "tops";
        populateGallery(topGallery, galleryDirectoryName);
        final LinearLayout bottomGallery = (LinearLayout) findViewById(R.id.bottomgallery);
        galleryDirectoryName = "bottoms";
        populateGallery(bottomGallery, galleryDirectoryName);



    }

	private void populateGallery(final LinearLayout topGallery, String galleryDirectoryName) {
		try {
            String[] listImages = getAssets().list(galleryDirectoryName);
            for (String imageName : listImages) {
                InputStream is = getAssets().open(galleryDirectoryName + "/" + imageName);
                final Bitmap bitmap = BitmapFactory.decodeStream(is);

                ImageView imageView = new ImageView(getApplicationContext());
                int picSize = (getWindowManager().getDefaultDisplay().getHeight()-150)/2;
                //int picSize = findViewById(R.id.mainview).getHeight()/2;
                imageView.setLayoutParams(new ViewGroup.LayoutParams(picSize, picSize));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageBitmap(bitmap);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //diplayImage.setImageBitmap(bitmap);
                    }
                });

                topGallery.addView(imageView);
            }
            
            
        } catch (IOException e) {
            Log.e("GalleryWithHorizontalScrollView", e.getMessage(), e);
        }
	}

}