package com.ccl.androidtest.listViewTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ccl.androidtest.R;
import com.ccl.androidtest.listViewTest.adapter.FruitAdapter;
import com.ccl.androidtest.listViewTest.adapter.model.Fruit;
import com.ccl.androidtest.util.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCL on 2016/12/7.
 */

public class ListViewActivity extends BaseActivity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_listview);
        initFruit();
        FruitAdapter adapter = new FruitAdapter(ListViewActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit =fruitList.get(position);
                Toast.makeText(ListViewActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFruit(){
        Fruit apple = new Fruit(R.drawable.apple,"apple");
        fruitList.add(apple);
        Fruit banana = new Fruit(R.drawable.banana,"banana");
        fruitList.add(banana);
        Fruit cherry = new Fruit(R.drawable.cherry,"cherry");
        fruitList.add(cherry);
        Fruit grape = new Fruit(R.drawable.grape,"grape");
        fruitList.add(grape);
        Fruit mango = new Fruit(R.drawable.mango,"mango");
        fruitList.add(mango);
        Fruit orange = new Fruit(R.drawable.orange,"orange");
        fruitList.add(orange);
        Fruit pineapple = new Fruit(R.drawable.pineapple,"pineapple");
        fruitList.add(pineapple);
        Fruit strawberry = new Fruit(R.drawable.strawberry,"strawberry");
        fruitList.add(strawberry);
        Fruit watermelon = new Fruit(R.drawable.watermelon,"watermelon");
        fruitList.add(watermelon);
    }

    public static void actionStart(Context context) {
        Intent itent = new Intent(context, ListViewActivity.class);
        context.startActivity(itent);
    }
}
