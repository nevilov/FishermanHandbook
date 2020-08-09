package com.example.fisherhanbook;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Type;

public class TextContent extends AppCompatActivity {
    private int category = 0;
    private int position = 0;

    private Typeface face;

    private int [] arrayFish = { R.string.FishInfo_Som, R.string.FishInfo_Karas, R.string.FishInfo_Karp}; //Массив для рыб, индекс элементов массива arrays должны совпадать с номером information
    private int [] arrayBait = {R.string.BaitInfo_Bread}; //Массив для снастей
    private int [] arrayTackle = {R.string.TackleInfo_FishingRod};

    private int [] ImageFishArray = {R.drawable.som, R.drawable.karas, R.drawable.karp}; //Массив для картинок с рыбами

    private ImageView iContent;
    private TextView TextContent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState/*, @Nullable PersistableBundle persistentState*/) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);

        init();

        reciveIntent();
    }

    private void reciveIntent(){
        Intent i = getIntent();
        if(i!= null){ //Получаем данные
            category = i.getIntExtra("category",0);
            position = i.getIntExtra("position",0);
        }
        switch (category) {
            case 0:
                TextContent.setText(arrayFish[position]); // Мы передаем в TW массив, индексом которого является номер элемента
                iContent.setImageResource(ImageFishArray[position]);
                break;
            case 1:
                TextContent.setText(arrayBait[position]);
                break;
            case 2:
                TextContent.setText(arrayTackle[position]);
                break;

        }

    }

    private void init(){
        iContent = findViewById(R.id.ImageContent);
        TextContent = findViewById(R.id.TextContent);

        face = Typeface.createFromAsset(this.getAssets(),"fonts/Pribambas-Regular.ttf");
        TextContent.setTypeface(face);
    }

}
