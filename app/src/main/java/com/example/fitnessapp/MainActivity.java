package com.example.fitnessapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    LinearLayout l1, l2, l3;
    Button btn1, btn2;
    Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu); // Inflate the menu resource
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.privacy){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://iotexpert1.blogspot.com/2020/10/weight-loss-privacy-ploicy-page.html"));
            startActivity(intent);
            return true;
        }if(id==R.id.term){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://iotexpert1.blogspot.com/2020/10/weight-loss-terms-and-conditions-page.html"));
            startActivity(intent);
            return true;
        }if(id==R.id.rate){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(""));
            startActivity(intent);
            return true;
        }if(id==R.id.more){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(""));
            startActivity(intent);
            return true;
        }if(id==R.id.share){
            Intent intent= new Intent(Intent.ACTION_SEND    );
                intent.setType("text/plain");
                String sharebody="This is the best Fitness App\n By this App You Streach your Body\n Yhis is a free App ";
                String sharehub="Fitness App";
                intent.putExtra(intent.EXTRA_SUBJECT,sharehub);
                intent.putExtra(intent.EXTRA_TEXT,sharebody);
                 startActivity(Intent.createChooser(intent, "Share Using "));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        l1 = findViewById(R.id.AfterAge8);
        l2 = findViewById(R.id.BeforeAge8);
        l3 = findViewById(R.id.Food);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        toolbar = findViewById(R.id.toolbar);

        // Set the toolbar
        setSupportActionBar(toolbar);

        // Set click listeners
        btn1.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));

        btn2.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ThirdActivity.class)));

        l1.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));

        l2.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ThirdActivity.class)));

        l3.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FoodActivity.class)));
    }
}
