package com.osmancansonmezisik.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterActivity extends AppCompatActivity {

    final List<Animal> animals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        animals.add(new Animal("Cat",R.mipmap.ic_launcher));
        animals.add(new Animal("Butterfly", R.mipmap.ic_launcher));

        ListView listView = findViewById(R.id.listView);
        AnimalAdapter adapter = new AnimalAdapter(animals,this);
        listView.setAdapter(adapter);
    }
}