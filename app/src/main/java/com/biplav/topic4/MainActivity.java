package com.biplav.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public static final String countries[]={"Nepal", "India", "China", "UK", "US", "Canada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lv);
        ArrayAdapter countryApapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        listView.setAdapter(countryApapter);
    }
}
