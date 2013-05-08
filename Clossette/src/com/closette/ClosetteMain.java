package com.closette;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ClosetteMain extends Activity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.closette_main, menu);
        return true;
    }
    

    private ImageView selectedImageView;

    private ImageView leftArrowImageView;

    private ImageView rightArrowImageView;

    private Gallery topgallery;
    private Gallery bottomgallery;

    private int selectedImagePosition = 0;

    private List<Drawable> drawables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closette_main);

        getDrawablesList();
        setupUI();
    }

    private void setupUI() {

        topgallery = (Gallery) findViewById(R.id.TopGallery);
        bottomgallery = (Gallery) findViewById(R.id.BottomGallery);

  

        topgallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                selectedImagePosition = pos;

 

                changeBorderForSelectedImage(selectedImagePosition);
                setSelectedImage(selectedImagePosition);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

//        galImageAdapter = new GalleryImageAdapter(this, drawables);
//
//        topgallery.setAdapter(galImageAdapter);

        if (drawables.size() > 0) {

            topgallery.setSelection(selectedImagePosition, false);

        }

//        if (drawables.size() == 1) {
//
//            rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_disabled));
//        }

    }

    private void changeBorderForSelectedImage(int selectedItemPos) {

//        int count = topgallery.getChildCount();
//
//        for (int i = 0; i < count; i++) {
//
//            ImageView imageView = (ImageView) topgallery.getChildAt(i);
//            imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.image_border));
//            imageView.setPadding(3, 3, 3, 3);
//
//        }
//
//        ImageView imageView = (ImageView) gallery.getSelectedView();
//        imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.selected_image_border));
//        imageView.setPadding(3, 3, 3, 3);
    
    }
    

    private void getDrawablesList() {

        drawables = new ArrayList<Drawable>();
        drawables.add(getResources().getDrawable(R.drawable.skirt1));
        drawables.add(getResources().getDrawable(R.drawable.skirt2));

    }

    private void setSelectedImage(int selectedImagePosition) {

        BitmapDrawable bd = (BitmapDrawable) drawables.get(selectedImagePosition);
        Bitmap b = Bitmap.createScaledBitmap(bd.getBitmap(), (int) (bd.getIntrinsicHeight() * 0.9), (int) (bd.getIntrinsicWidth() * 0.7), false);
        selectedImageView.setImageBitmap(b);
        selectedImageView.setScaleType(ScaleType.FIT_XY);

    }
}
