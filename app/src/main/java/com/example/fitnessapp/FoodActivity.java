package com.example.fitnessapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        listView = findViewById(R.id.list);
        String[] tstory = getResources().getStringArray(R.array.title_story);
        final String[] dstory = getResources().getStringArray(R.array.details_story);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row, R.id.rowtext1, tstory);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String t = dstory[i];  // Get the detailed story based on the clicked item

                // Create an intent to start FoodDetailsActivity and pass the detailed story
                Intent intent = new Intent(FoodActivity.this, FoodDetailsActivity.class);
                intent.putExtra("DETAILED_STORY", t);  // Passing the detailed story to the next activity
                startActivity(intent);
            }
        });
    }

    public void foodgoback(View view) {
        startActivity(new Intent(FoodActivity.this,MainActivity.class));
        finish();
    }
    @SuppressLint("MissingSuperCall")
    public void onBackPressed() {
        //super.onBackPressed();
        startActivity(new Intent(FoodActivity.this,MainActivity.class));
        finish();
    }
}
