package com.example.fisherhanbook;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class StartActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

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
