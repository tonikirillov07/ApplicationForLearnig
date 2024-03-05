package com.ds.applicationforlearnig;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private AlphaAnimation alphaAnimation;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView moon = findViewById(R.id.moon);
        ImageView star1 = findViewById(R.id.star1);
        ImageView star2 = findViewById(R.id.star2);
        ImageView star3 = findViewById(R.id.star3);
        ImageView star4 = findViewById(R.id.star4);
        ImageView star5 = findViewById(R.id.star5);

        View[] stars = {star1, star2, star3, star4, star5};

        initAlphaTransition();
        initStarsAnimations(stars);
        setTranslateAnimation(moon, moon.getTranslationX(),0, -300, moon.getTranslationY());

    }

    private void initStarsAnimations(View[] stars) {
        Arrays.asList(stars).forEach(v -> setTranslateAnimation(v, v.getTranslationX(),0, -100, v.getTranslationY()));

        new Thread(() -> {
            try {
                Thread.sleep(1000);

                runOnUiThread(() -> setAlphaTransition(stars));

                Thread.sleep(5000);

                runOnUiThread(() -> {
                    View currentStar = stars[new Random().nextInt(stars.length)];

                    setTranslateAnimation(currentStar, currentStar.getTranslationX(), -getMaxSize().x, currentStar.getTranslationY(), getMaxSize().y);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @NonNull
    private Point getMaxSize(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size;
    }

    private void initAlphaTransition() {
        alphaAnimation = new AlphaAnimation(0.5f, 1f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
    }

    private void setAlphaTransition(@NonNull View[] views){
        if(alphaAnimation == null) initAlphaTransition();

        Arrays.asList(views).forEach(star -> {
            star.startAnimation(alphaAnimation);
        });
    }

    private void setTranslateAnimation(@NonNull View view, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        TranslateAnimation translateAnimation = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);

        view.startAnimation(translateAnimation);
    }

}