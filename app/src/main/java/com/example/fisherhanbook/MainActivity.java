package com.example.fisherhanbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ListView list;
    private DrawerLayout drawer;
    private String[] array;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;
    private int IndexCategory = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = findViewById(R.id.listView);
        array  = getResources().getStringArray(R.array.fish); // Находим массив с рыбами
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array))); //Синхронизируем адаптер и массив
        list.setAdapter(adapter);//Синхронизируем LW и адаптер

        NavigationView navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(this); // Указание, что слушатель нажатий находится здесь
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close); //Добавляем в меню кнопку
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /*Слушатель на нажатия отдельных итемов (вывод экрана при нажатии на итем)*/
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int id, long position) {
                Intent intent = new Intent(MainActivity.this,TextContent.class);
                startActivity(intent);
                /*Передаем значения в другой Activity*/
                intent.putExtra("Category",IndexCategory);
                intent.putExtra("Position",position);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) { //Слушитель нажатий
        int id = item.getItemId();

        switch (id){
            case R.id.fish:
                toolbar.setTitle(R.string.menu_fish);
                array = getResources().getStringArray(R.array.fish);
                adapter.clear();
                adapter.addAll(array); // Добавляем новые элементы массива
                adapter.notifyDataSetChanged(); // Обновляем новые элементы массива
               // Toast.makeText(this, "Привет, домой", Toast.LENGTH_SHORT).show();
                IndexCategory = 0;
                break;
            case R.id.bait:
                toolbar.setTitle(R.string.menu_bait);
                array = getResources().getStringArray(R.array.bait);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                IndexCategory = 1;
                break;
            case R.id.tackle:
                toolbar.setTitle(R.string.menu_tackle);
                array = getResources().getStringArray(R.array.tackle);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                IndexCategory = 2;
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}