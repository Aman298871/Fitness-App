package com.example.fitnessapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity2 extends AppCompatActivity {
    String buttonvalue;
    Button btnstart;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftMills;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise);
        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");
        int intvalue = Integer.valueOf(buttonvalue);

        switch (intvalue) {
            case 1:
                setContentView(R.layout.activity_bow2);
                break;
            case 2:
                setContentView(R.layout.activity_bridge2);
                break;
            case 3:
                setContentView(R.layout.activity_chair2);
                break;
            case 4:
                setContentView(R.layout.activity_child2);
                break;
            case 5:
                setContentView(R.layout.activity_cobler2);
                break;
            case 6:
                setContentView(R.layout.activity_cow2);
                break;
            case 7:
                setContentView(R.layout.activity_play2);
                break;
            case 8:
                setContentView(R.layout.activity_crunches2);
                break;
            case 9:
                setContentView(R.layout.activity_pause2);
                break;
            case 10:
                setContentView(R.layout.activity_situp2);
                break;
            case 11:
                setContentView(R.layout.activity_rotation2);
                break;
            case 12:
                setContentView(R.layout.activity_twist2);
                break;
            case 13:
                setContentView(R.layout.activity_windmill2);
                break;
            case 14:
                setContentView(R.layout.activity_legup2);
                break;
            case 15:
                setContentView(R.layout.activity_plank2);
                break;
        }

        btnstart = findViewById(R.id.btnstart);
        mtextview = findViewById(R.id.btntime);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MTimeRunning) {
                    StopTimer();
                } else {
                    if (MTimeLeftMills == 0) {
                        // Reset to 5 minutes if time is exhausted
                        MTimeLeftMills = 5 * 60 * 1000;
                        UpdateTimer();
                    }
                    StartTimer();
                }
            }
        });

    }

    private void StopTimer() {
        countDownTimer.cancel();
        MTimeRunning = false;
        btnstart.setText("START");
    }

    private void StartTimer() {
        final CharSequence val = mtextview.getText();
        String num1 = val.toString();
        String num2 = num1.substring(0, 2); // Extract minutes
        String num3 = num1.substring(3, 5); // Extract seconds

        final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3); // Calculate total seconds
        MTimeLeftMills = number * 1000; // Convert seconds to milliseconds

        countDownTimer = new CountDownTimer(MTimeLeftMills, 1000) {
            @Override
            public void onTick(long l) {
                MTimeLeftMills = l;
                UpdateTimer();
            }

            @Override
            public void onFinish() {
                mtextview.setText("00:00");
                btnstart.setText("START");
                MTimeRunning = false;
            }
        }.start();

        btnstart.setText("PAUSE");
        MTimeRunning = true;
    }


    private void UpdateTimer() {
        int minutes = (int) (MTimeLeftMills / 1000) / 60;
        int seconds = (int) (MTimeLeftMills / 1000) % 60;
        String timelefttext = String.format("%02d:%02d", minutes, seconds);
        mtextview.setText(timelefttext);

        if (minutes < 10) {
            timelefttext = "0";
            timelefttext = timelefttext + minutes + ":";
            if (seconds < 10) {
                timelefttext += "0";
            }
            timelefttext += seconds;
            mtextview.setText(timelefttext);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
