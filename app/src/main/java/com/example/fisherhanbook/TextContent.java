package com.example.fisherhanbook;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextContent extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState/*, @Nullable PersistableBundle persistentState*/) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
    }
}
