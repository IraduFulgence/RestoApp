package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class OrderDishActivity extends AppCompatActivity {
    private Integer[] IMAGES = {R.drawable.chicken,R.drawable.burger,R.drawable.pizza,R.drawable.pork,R.drawable.rwanda};
    private  String[] FOODNAMES ={"Chicken","Humberger","Royal Pizza","Pork beef","Rwandan foods"};
    private String[] FOODSDETAILS ={"Price =======>18000frw","Price =======5000frw","Price =======5000frw","Price =======8000frw","Price =======3000frw"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_dish);
        MyDishView.MyListAdapter myListAdapter = new MyDishView.MyListAdapter(this,FOODNAMES,FOODSDETAILS,IMAGES);
        ListView listView = (ListView)findViewById(R.id.listed);
        listView.setAdapter(myListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    protected Boolean doInBackground(Void... params) {
        // TODO: attempt authentication against a network service.

        try {
            // Simulate network access.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }
}
