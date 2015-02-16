package com.ucd.marco.fruitapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class FruitDetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_details);

        Intent intent = getIntent();

        final TextView textFruit = (TextView)findViewById(R.id.textFruit);



        textFruit.setText(intent.getStringExtra(MainActivity.EXTRA_FRUIT_NAME));

        ImageView img = (ImageView) findViewById(R.id.imageFruit);

        String fruitName =  intent.getStringExtra(MainActivity.EXTRA_FRUIT_NAME);

        if("kiwi".equalsIgnoreCase(fruitName)){
            img.setImageResource(R.drawable.kiwi);

        }else  if("banana".equalsIgnoreCase(fruitName)){
            img.setImageResource(R.drawable.banana);
        }else{
            img.setImageResource(R.drawable.dragon);
        }

    }

}
