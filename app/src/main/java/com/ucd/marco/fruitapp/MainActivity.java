package com.ucd.marco.fruitapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_FRUIT_NAME = "com.ucd.marco.fruitapp.FRUIT_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, FruitDetailsActivity.class);



        ImageView imgKiwi = (ImageView) findViewById(R.id.imageKiwi);
        imgKiwi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra(EXTRA_FRUIT_NAME, "kiwi");

                startActivity(intent);
            }
        });

        ImageView imgBanana = (ImageView) findViewById(R.id.imageBanana);
        imgBanana.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra(EXTRA_FRUIT_NAME, "banana");

                startActivity(intent);
            }
        });

        ImageView imgDragon = (ImageView) findViewById(R.id.imageDragon);
        imgDragon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra(EXTRA_FRUIT_NAME, "dragon");

                startActivity(intent);
            }
        });


    }


}
