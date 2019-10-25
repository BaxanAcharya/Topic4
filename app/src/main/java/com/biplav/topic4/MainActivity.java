package com.biplav.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView, listViewCountry;
    public static final String countries[]={"Nepal", "India", "China", "UK", "US", "Canada"};
    private String countriesAndCapital[]={"Nepal","Kathmandu","India","New Dheli"};

    private Map<String,String> countryMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lv);
        listViewCountry=findViewById(R.id.lvCountry);

        countryMap=new HashMap<>();

        for(int i= 0; i <countriesAndCapital.length; i+=2){
            countryMap.put(countriesAndCapital[i], countriesAndCapital[i+1]);
        }

        ArrayAdapter arrayAdaptercountry=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(countryMap.keySet())

        );
        listViewCountry.setAdapter(arrayAdaptercountry);


        listViewCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country=parent.getItemAtPosition(position).toString();
                String captial=countryMap.get(country);
                Toast.makeText(MainActivity.this, "Capital of "+ country+ " is " + captial, Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter countryApapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        listView.setAdapter(countryApapter);
    }
}
