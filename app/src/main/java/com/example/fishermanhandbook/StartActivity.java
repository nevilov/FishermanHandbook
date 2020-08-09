package com.example.fishermanhandbook;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.fisherhanbook.R;

public class StartActivity extends Activity {
    private Animation logoApplication;
    private ImageView logoImage;
    private Typeface startface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        init();
        StartMainActivity();

    }

    private void init(){
        logoApplication = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_animation); // Загрузка анимации в переменную

        logoImage = findViewById(R.id.logoView);
        //*Запуск анимации*//*
        logoImage.startAnimation(logoApplication);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void StartMainActivity(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    Intent transition = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(transition);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
