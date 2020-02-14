package com.example.try1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class widgets_activity extends AppCompatActivity {

    private GestureDetectorCompat mGestureDetector;
    ImageView img1, img2, img3, img4, img5, img6;
    String url1 = "https://www.publicdomainpictures.net/pictures/290000/nahled/world-news-free-illustration.jpg";
    String url2 = "https://cdn.pixabay.com/photo/2017/12/08/11/53/event-party-3005668_960_720.jpg";
    String url3 = "https://media.defense.gov/2014/Jul/16/2000832464/780/780/0/140715-F-MI136-027.JPG", url4 = "https://p0.pxfuel.com/preview/76/1021/76/hand-commercial-search-web-page.jpg";
    String url5 = "https://cdn.pixabay.com/photo/2019/08/07/03/45/brain-4389724_960_720.png", url6 = "http://www.thebluediamondgallery.com/handwriting/images/entertainment.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_activity);

        mGestureDetector = new GestureDetectorCompat(widgets_activity.this, new GestureListener());
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
//        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
//        animationDrawable.setEnterFadeDuration(1000);
//        animationDrawable.setExitFadeDuration(2000);
//        animationDrawable.start();

        img1 = (ImageView) findViewById(R.id.imageView10);
        img2 = (ImageView) findViewById(R.id.imageView11);
        img3 = (ImageView) findViewById(R.id.imageView12);
        img4 = (ImageView) findViewById(R.id.imageView13);
        img5 = (ImageView) findViewById(R.id.imageView14);
        img6 = (ImageView) findViewById(R.id.imageView15);

        Glide.with(this).asBitmap().load(url1).into(img1);
        Glide.with(this).asBitmap().load(url2).into(img2);
        Glide.with(this).asBitmap().load(url3).into(img3);
        Glide.with(this).asBitmap().load(url4).into(img4);
        Glide.with(this).asBitmap().load(url5).into(img5);
        Glide.with(this).asBitmap().load(url6).into(img6);


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(widgets_activity.this, newsActivity.class);
                intent.putExtra("Section", "Highlights");
                intent.putExtra("image_url", url1);
                startActivity(intent);
            }
        });


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(widgets_activity.this, newsActivity.class);
                intent.putExtra("Section", "Events");
                intent.putExtra("image_url", url2);
                startActivity(intent);
            }
        });


        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(widgets_activity.this, newsActivity.class);
                intent.putExtra("Section", "Sports");
                intent.putExtra("image_url", url3);
                startActivity(intent);
            }
        });


        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(widgets_activity.this, newsActivity.class);
                intent.putExtra("Section", "Sci. - Tech.");
                intent.putExtra("image_url", url4);
                startActivity(intent);
            }
        });


        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(widgets_activity.this, newsActivity.class);
                intent.putExtra("Section", "Creativity");
                intent.putExtra("image_url", url5);
                startActivity(intent);
            }
        });


        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(widgets_activity.this, newsActivity.class);
                intent.putExtra("Section", "Entertainment");
                intent.putExtra("image_url", url6);
                startActivity(intent);
            }
        });

        //now loading image from url:

    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Toast.makeText(widgets_activity.this, "(switching)", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(widgets_activity.this, HomeScreen.class);
            startActivity(intent);
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}