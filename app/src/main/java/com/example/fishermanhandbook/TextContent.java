package com.example.fishermanhandbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fisherhanbook.R;

public class TextContent extends AppCompatActivity {
    private int category = 0;
    private int position = 0;

    private Typeface face;
    private SharedPreferences textSizePreference;
    private ActionBar actionBar;

    /*FISH*/
    private int [] arrayFish = { R.string.FishInfo_Som, R.string.FishInfo_Karas, R.string.FishInfo_Karp}; //Массив для рыб, индекс элементов массива arrays должны совпадать с номером information
    private int [] ArrayFishImages = {R.drawable.som, R.drawable.karas, R.drawable.karp}; //Массив для картинок с рыбами
    private String [] titleFish = {"Сом", "Карась", "Карп"};

    /*BAIT*/
    private int [] arrayBait = {R.string.BaitInfo_Bread, R.string.BaitInfo_Kukuruza,R.string.BaitInfo_Chervyak }; //Массив для снастей
    private int [] ArrayBaitImages = new int[]{R.drawable.bestbait1,R.drawable.kukuruza1,R.drawable.chervyak_bait};
    private String [] titleBait = {"Лучшая прикормка", "Кукуруза", "Червяк"};

    /*TACKLE*/
    private int [] arrayTackle = {R.string.TackleInfo_FishingRod,R.string.TackleInfo_Spin, R.string.TackleInfo_Donka};
    private int [] ArrayTackleImages = new int []{R.drawable.tackle1,R.drawable.tackle2,R.drawable.tackle3};
    private String [] titleTackle = {"Удочка", "Спиннинг", "Донка"};


    private ImageView iContent;
    private TextView TextContent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState/*, @Nullable PersistableBundle persistentState*/) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        getPreferences();
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
                iContent.setImageResource(ArrayFishImages[position]);
                actionBar.setTitle(titleFish[position]);
                break;
            case 1:
                TextContent.setText(arrayBait[position]);
                iContent.setImageResource(ArrayBaitImages[position]);
                actionBar.setTitle(titleBait[position]);
                break;
            case 2:
                TextContent.setText(arrayTackle[position]);
                iContent.setImageResource(ArrayTackleImages[position]);
                actionBar.setTitle(titleTackle[position]);
                break;

        }

    }

    private void init(){
        iContent = findViewById(R.id.ImageContent);
        TextContent = findViewById(R.id.TextContent);

        face = Typeface.createFromAsset(this.getAssets(),"fonts/Pribambas-Regular.ttf");
        TextContent.setTypeface(face);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); // Устанавливаем AB
    }

    private void getPreferences(){
        textSizePreference = PreferenceManager.getDefaultSharedPreferences(this); //Назначение основного preference
        String textSize = textSizePreference.getString("mainTextSize","Средний");
        if(textSize != null) {
            switch (textSize) {
                case "Маленький":
                    TextContent.setTextSize(14);
                    break;
                case "Средний":
                    TextContent.setTextSize(18);
                    break;
                case "Большой":
                    TextContent.setTextSize(24);
                    break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
