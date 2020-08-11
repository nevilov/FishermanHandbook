package com.example.fishermanhandbook.settings;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fisherhanbook.R;

public class SettingsActivity extends AppCompatActivity{

    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar()!=null) {
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); // Устанавливаем AB
        actionBar.setTitle(getString(R.string.action_settings));
        getFragmentManager().beginTransaction().replace(android.R.id.content,new SettingFragment()).commit();
        }


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) //При нажатии домой, скроем
            finish();
        return super.onOptionsItemSelected(item);
    }
}

