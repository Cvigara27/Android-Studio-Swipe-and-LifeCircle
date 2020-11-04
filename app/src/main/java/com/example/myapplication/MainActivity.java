package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private static final String MainAct = "MainActivity";
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);

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
        Toast.makeText(this, "On destroy", Toast.LENGTH_SHORT).show();
    }



    //MOTION EVENT
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Toast.makeText(this, "On down", Toast.LENGTH_SHORT).show();
        Log.i(MainAct, "Mensaje onDown");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Toast.makeText(this, "On fling", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Toast.makeText(this, "On long press", Toast.LENGTH_SHORT).show();
        Log.i(MainAct, "Mensaje onLongPress");
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        Toast.makeText(this, "On scroll", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Toast.makeText(this, "On show press", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Toast.makeText(this, "On single tap up", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Toast.makeText(this, "On double tap", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Toast.makeText(this, "On double tap event", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Toast.makeText(this, "On single tap confirmed", Toast.LENGTH_SHORT).show();
        return true;
    }


    public void setWallpaper(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hollow);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        try {
            wallpaperManager.setBitmap(bitmap);
            Toast.makeText(this, "Wallpaper Changed Successfully", Toast.LENGTH_SHORT).show();
        }catch (IOException e) {
            Toast.makeText(this, "An error has occured" ,Toast.LENGTH_SHORT).show();
        }
    }
}