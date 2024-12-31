package com.example.fitnessapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize toolbar and set it
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize the array with button IDs
        newArray = new int[] {
                R.id.bowPose, R.id.bridgePose, R.id.chairPose, R.id.childPose, R.id.coblerPose,
                R.id.cowPose, R.id.playPose, R.id.crunchesPose, R.id.pausePose, R.id.situpPose,
                R.id.rotationPose, R.id.twistPose, R.id.windmillPose, R.id.legupPose, R.id.plankPose
        };
    }

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

    // This method is called when any button (ImageButton) is clicked
    public void ImageButton(View view) {
        // Iterate through the array and match the clicked button ID
        for (int i = 0; i < newArray.length; i++) {
            if (view.getId() == newArray[i]) {
                int value = i + 1; // Mapping the button index to a value (start from 1)
                Log.i("FirstActivity", "Button clicked with value: " + value);

                // Create an Intent to start the ExerciseActivity
                Intent intent = new Intent(SecondActivity.this, ExerciseActivity.class);

                // Pass the value to the ExerciseActivity
                intent.putExtra("value", String.valueOf(value));

                // Start the ExerciseActivity
                startActivity(intent);
                return; // Exit the loop once a matching button is found
            }
        }
    }
}
