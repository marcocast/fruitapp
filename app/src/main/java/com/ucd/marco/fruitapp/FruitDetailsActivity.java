package com.ucd.marco.fruitapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.TypedValue;
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

        final TextView textFruitFirstLetter = (TextView)findViewById(R.id.textFruitFirstLetter);

        textFruitFirstLetter.setText(intent.getStringExtra(MainActivity.EXTRA_FRUIT_NAME).substring(0,1));

        textFruitFirstLetter.setTextSize(TypedValue.COMPLEX_UNIT_SP,150);

        textFruit.setText(intent.getStringExtra(MainActivity.EXTRA_FRUIT_NAME).substring(1));

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
