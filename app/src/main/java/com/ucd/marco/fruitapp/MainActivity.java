package com.ucd.marco.fruitapp;
        import android.content.Intent;
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
    private Random random = new Random();
    private ListView list;
    private String[] fruits = {
            "Kiwi",
            "Dragon",
            "Banana"
    } ;
    private Integer[] imageId = {
            R.drawable.kiwi,
            R.drawable.dragon,
            R.drawable.banana
    };

    private static String[] kiwiFacts = {
            "Kiwifruit has also been considered a nutritional all-star",
            "kiwifruit has the best nutrient density of 21 commonly consumed fruits",
            "If you want clean energy, think of kiwifruit because they’re rich in magnesium",
            "Kiwifruit has been growing in New Zealand for over 100 years",
            "At first, kiwis were referred to as Yang Tao or Chinese Gooseberry"
    } ;

    private static String[] dragonFacts = {
            "To choose a ripe dragon fruit: look for bright, even-colored skin",
            "Dragon fruit is loaded with beneficial antioxidant",
            "Dragon fruit is also called Pitaya",
            "Dragon fruit does have a small amount of fats because there are so many seeds in the edible part of the fruit."
    } ;


    private static String[] bananaFacts = {
            "Bananas are the fruit produced by various banana plants",
            "When rip they are usually long and curved with a soft inside covered by a yellow skin (peel)",
            "Bananas can be found in other colors, including red",
            "Banana plants are not trees, they are a type of herb",
            "Bananas have high nutritional value and are a healthy snack",
            "Humans have grown bananas for thousands of years"
    } ;


   private static Map<String,String[]> fruitFacts = new HashMap<String,String[]>();
    static {
        Map<String,String[]> tempFruitFacts = new HashMap<String,String[]>();
        tempFruitFacts.put("Kiwi", kiwiFacts);
        tempFruitFacts.put("Dragon", dragonFacts);
        tempFruitFacts.put("Banana", bananaFacts);
        fruitFacts = Collections.unmodifiableMap(Collections.unmodifiableMap(tempFruitFacts));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        String[] facts =  fruitFacts.get(fruit);
        int randomIndex = random.nextInt(facts.length - 0 + 1) + 0;
        return facts[randomIndex];
    }
}