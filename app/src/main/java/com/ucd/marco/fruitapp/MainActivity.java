package com.ucd.marco.fruitapp;
        import android.content.Intent;
        import android.content.res.Resources;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.Toast;
        import android.app.Activity;

        import java.util.Collections;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Random;

public class MainActivity extends Activity {

    public final static String EXTRA_FRUIT_NAME = "com.ucd.marco.fruitapp.FRUIT_NAME";
    private ListView list;

    private static Integer[] imageId = {
            R.drawable.kiwi,
            R.drawable.dragon,
            R.drawable.banana
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        final String[] fruits = res.getStringArray(R.array.fruits);

        final Intent intent = new Intent(this, FruitDetailsActivity.class);
        SingleFruitList adapter = new SingleFruitList(MainActivity.this, fruits, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, getFruitFact(fruits[+ position]), Toast.LENGTH_LONG).show();
                intent.putExtra(EXTRA_FRUIT_NAME, fruits[+ position]);
                startActivity(intent);
            }
        });
    }


    private String getFruitFact(String fruit){

        String[] facts = null;
        Resources res = getResources();

        if("Kiwi".equals(fruit)){
            facts = res.getStringArray(R.array.kiwi_facts);
        }else if("Dragon".equals(fruit)){
            facts = res.getStringArray(R.array.dragon_facts);
        }else{
            facts = res.getStringArray(R.array.banana_facts);
        }

        int randomIndex = new Random().nextInt(facts.length);
        return facts[randomIndex];
    }
}