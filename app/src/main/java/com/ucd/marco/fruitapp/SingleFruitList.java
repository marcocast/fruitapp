package com.ucd.marco.fruitapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleFruitList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] fruits;
    private final Integer[] imageId;

    public SingleFruitList(Activity context, String[] fruits, Integer[] imageId) {
        super(context, R.layout.list_single_fruit, fruits);
        this.context = context;
        this.fruits = fruits;
        this.imageId = imageId;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single_fruit, null, true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}