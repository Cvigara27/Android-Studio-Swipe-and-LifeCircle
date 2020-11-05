package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String MainAct = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
                                         public void onSwipeTop() {
                                             Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
                                         }

                                         public void onSwipeRight() {
                                             Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                                         }

                                         public void onSwipeLeft() {
                                             Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                                         }

                                         public void onSwipeBottom() {
                                             Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
                                         }
                                     });

        Log.d("MainActivity", "Hola buenas tardes, esto arranca");

    }

    //LIFE CIRCLE OF AN APP
    @Override
    public void onStart(){
        super.onStart();
        Log.i(MainAct, "Mensaje onStart");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(MainAct, "Mensaje onPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(MainAct, "Mensaje onResuma");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(MainAct, "Mensaje onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(MainAct, "Mensaje onDestroy");
    }



    //MOTION EVENT
    /*@Override
    public boolean onTouchEvent(MotionEvent event){

        int action = MotionEventCompat.getActionMasked(event);
        Context context = getApplicationContext();

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                Toast.makeText(context, "On down", Toast.LENGTH_SHORT).show();
                return true;
            case (MotionEvent.ACTION_UP) :
                Toast.makeText(context, "On up", Toast.LENGTH_SHORT).show();
                return true;
            default :
                return super.onTouchEvent(event);
        }
    }*/
}