package com.example.fishermanhandbook.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fisherhanbook.R;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<ListItemClass> {
    private LayoutInflater inflater;
    private List <ListItemClass> listItem = new ArrayList<>(); //Используем свой тип данных
    private Context context;


    public CustomArrayAdapter(@NonNull Context context, int resource, List<ListItemClass> listItem, LayoutInflater inflater) {
        super(context, resource, listItem);

        this.inflater = inflater;
        this.listItem = listItem;
        this.context = context;



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        ListItemClass listItemMain = listItem.get(position); // Мы берем по одному элементу
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.listview_item, null, false);
            viewHolder = new ViewHolder();
            viewHolder.image  = convertView.findViewById(R.id.imListView);
            viewHolder.name = convertView.findViewById(R.id.tvItemName);
            viewHolder.secName = convertView.findViewById(R.id.TvItemSecondName);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(listItemMain.getNameItem());
        viewHolder.secName.setText(listItemMain.getSecName());
        viewHolder.image.setImageResource(listItemMain.ImageID);

        return convertView;
    }
    private class ViewHolder{
        TextView name;
        TextView secName;
        ImageView image;
    }
}

