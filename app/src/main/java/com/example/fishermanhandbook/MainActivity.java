package com.example.fishermanhandbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fisherhanbook.R;
import com.example.fishermanhandbook.settings.SettingsActivity;
import com.example.fishermanhandbook.utils.CustomArrayAdapter;
import com.example.fishermanhandbook.utils.ListItemClass;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ListView list;
    private DrawerLayout drawer;
    private String[] array,secName;
    private CustomArrayAdapter adapter;
    private Toolbar toolbar;
    private int IndexCategory = 0;
    private List<ListItemClass> ListItemMain;
    private ListItemClass listItem;


    private int [] ArrayFishImages = new int[]{R.drawable.som,R.drawable.karas,R.drawable.karp};
    private int [] ArrayBaitImages = new int[]{R.drawable.som,R.drawable.karas,R.drawable.karp};
    private int [] ArrayTackleImages = new int []{R.drawable.som,R.drawable.karas,R.drawable.karp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            writeFirstArrays();

            NavigationView navigationView = findViewById(R.id.nav_view);
            drawer = findViewById(R.id.drawer_layout);

            navigationView.setNavigationItemSelectedListener(this); // Указание, что слушатель нажатий находится здесь
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close); //Добавляем в меню кнопку
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            itemListener();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        /*SEARCH*/
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) { //Слушитель нажатий
        int id = item.getItemId();

        switch (id){
            case R.id.fish:
                FillArray(R.array.fish,R.array.fish_last,ArrayFishImages,0, R.string.menu_fish);
                break;
            case R.id.bait:
                FillArray(R.array.bait,R.array.bait_last,ArrayBaitImages,1,R.string.menu_bait);
                break;
            case R.id.tackle:
                FillArray(R.array.tackle,R.array.tackle_last,ArrayTackleImages,2,R.string.menu_tackle);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void itemListener(){
        /*Слушатель на нажатия отдельных итемов (вывод экрана при нажатии на итем)*/
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,TextContent.class);

                /*Передаем значения в другой Activity*/
                intent.putExtra("category",IndexCategory);
                intent.putExtra("position",position);

                startActivity(intent);

            }
        });

    }

    private void FillArray(int nameArray, int SyntfcNameArray,int[] images, int index,int title){
        toolbar.setTitle(title);
        if(adapter!=null)
            adapter.clear();
        array  = getResources().getStringArray(nameArray); // Находим массив с рыбами
        secName = getResources().getStringArray(SyntfcNameArray);
        for(int i =0 ;i< array.length;i++){
            listItem = new ListItemClass();
            listItem.setNameItem(array[i]);
            listItem.setSecName(secName[i]);
            listItem.setImageID(images[i]);
            ListItemMain.add(listItem);
        }
        IndexCategory = index;
        adapter.notifyDataSetChanged();
    }

    private void writeFirstArrays(){
        list = findViewById(R.id.listView);
        array  = getResources().getStringArray(R.array.fish); // Находим массив с рыбами
        secName = getResources().getStringArray(R.array.fish_last);
        ListItemMain = new ArrayList<>();

        adapter = new CustomArrayAdapter(this,R.layout.listview_item, ListItemMain,getLayoutInflater());
        //Синхронизируем адаптер и массив
        list.setAdapter(adapter);//Синхронизируем LW и адаптер

        FillArray(R.array.fish,R.array.fish_last,ArrayFishImages,0, R.string.menu_fish);


    }


  /*  private void fillArray (int title, int arrayName, int index){
        toolbar.setTitle(title);
        array = getResources().getStringArray(arrayName);
        adapter.clear();
        adapter.addAll(array);
        adapter.notifyDataSetChanged();
        IndexCategory = index;
    }
*/


}