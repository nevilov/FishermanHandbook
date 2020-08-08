package com.example.fisherhanbook;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class StartActivity extends Activity {
    private Animation logoApplication, buttonApplication;
    private Button buttonAnimation;
    private ImageView logoImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        init();

    }

    private void init(){
        logoApplication = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_animation); // Загрузка анимации в переменную
        buttonApplication = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);

        logoImage = findViewById(R.id.logoView);
        buttonAnimation = findViewById(R.id.buttonView);
        //*Запуск анимации*//*
        logoImage.startAnimation(logoApplication);
        buttonAnimation.startAnimation(buttonApplication);

    }

    public void onClickStart(View view) {
        Intent transition = new Intent(StartActivity.this, MainActivity.class);
        startActivity(transition);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
