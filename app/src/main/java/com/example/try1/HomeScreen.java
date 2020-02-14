package com.example.try1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    Button button;
    private ArrayList<String> mImagesUrls = new ArrayList<>();
    private ArrayList<String> Editors = new ArrayList<>();
    private ArrayList<String> sections = new ArrayList<>();

//    private GestureDetectorCompat mGestureDetector;
    // float x1,x2,y1,y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
//        mGestureDetector = new GestureDetectorCompat(this, new GestureListener());
        initImageBitmaps();
        button = findViewById(R.id.button);
        button.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                registerForContextMenu(button);
                return false;
            }
        });
    }



//
//    public boolean OnTouchEvent(MotionEvent touchEvent){
//        switch(touchEvent.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                x1=touchEvent.getX();
//                y1=touchEvent.getY();
//                break;
//            case MotionEvent.ACTION_UP:
//                x2=touchEvent.getX();
//                y2=touchEvent.getY();
//                if(x1<x2){
//                    Intent intent = new Intent(HomeScreen.this, widgets_activity.class);
//                    startActivity(intent);
//                }
//                break;
//        }
//        return false;
//    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.options, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.editor_login:
                Intent intent4 = new Intent(this, login.class);
                startActivity(intent4);
                break;
            case R.id.contact_details:
                Intent intent5 = new Intent(this, contacts.class);
                startActivity(intent5);
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void initImageBitmaps() {
        mImagesUrls.add("https://www.publicdomainpictures.net/pictures/290000/nahled/world-news-free-illustration.jpg");
        Editors.add("By: Shanu Garg & Vineet Dhankar");
        sections.add("Highlights");

        mImagesUrls.add("https://cdn.pixabay.com/photo/2017/12/08/11/53/event-party-3005668_960_720.jpg");
        Editors.add("By: Bansari Sinha");
        sections.add("Events");

        mImagesUrls.add("https://media.defense.gov/2014/Jul/16/2000832464/780/780/0/140715-F-MI136-027.JPG");
        Editors.add("By: Vinay Kumar");
        sections.add("Sports");

        mImagesUrls.add("https://p0.pxfuel.com/preview/76/1021/76/hand-commercial-search-web-page.jpg");
        Editors.add("By: Pratham Agrasen & Agam Kaushik");
        sections.add("Science & Technology");

        mImagesUrls.add("https://cdn.pixabay.com/photo/2019/08/07/03/45/brain-4389724_960_720.png");
        Editors.add("By: Yash Sharma & Himanshu Atri");
        sections.add("Creativity");

        mImagesUrls.add("http://www.thebluediamondgallery.com/handwriting/images/entertainment.jpg");
        Editors.add("By: Shaurya Anand & Khushboo");
        sections.add("Entertainment");

        initRecyclerView();
    }
    public void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.programmingList);
        ProgrammingAdapter adapter = new ProgrammingAdapter(Editors, mImagesUrls, sections, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


//    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
//        @Override
//        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            Intent intent = new Intent(HomeScreen.this, widgets_activity.class);
//            startActivity(intent);
//            return super.onFling(e1, e2, velocityX, velocityY);
//        }
//    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event){
//        mGestureDetector.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }
}
