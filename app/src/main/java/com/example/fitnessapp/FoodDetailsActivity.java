package com.example.fitnessapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FoodDetailsActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food_details);
        textView= findViewById(R.id.txt);
        String dstory=getIntent().getStringExtra("DETAILED_STORY");
        textView.setText(dstory);

    }

    public void gotoback(View view) {
    startActivity(new Intent(FoodDetailsActivity.this,FoodActivity.class));
    finish();
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        startActivity(new Intent(FoodDetailsActivity.this,FoodActivity.class));
        finish();
    }
}