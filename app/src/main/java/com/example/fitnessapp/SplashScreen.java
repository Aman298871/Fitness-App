package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {
TextView txt;
ImageView img;
Animation up,down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        txt= findViewById(R.id.textviewYogaAppName);
        img = findViewById(R.id.imageviewsplashimage);
        up= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        down= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        img.setAnimation(up);
        txt.setAnimation(down);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();
            }
        },3500);

    }
}