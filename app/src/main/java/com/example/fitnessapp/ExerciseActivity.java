package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity extends AppCompatActivity {
    String buttonvalue;
    Button btnstart;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftMills;

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
                setContentView(R.layout.activity_bow);
                break;
            case 2:
                setContentView(R.layout.activity_bridge);
                break;
            case 3:
                setContentView(R.layout.activity_chair);
                break;
            case 4:
                setContentView(R.layout.activity_child);
                break;
            case 5:
                setContentView(R.layout.activity_cobler);
                break;
            case 6:
                setContentView(R.layout.activity_cow);
                break;
            case 7:
                setContentView(R.layout.activity_play);
                break;
            case 8:
                setContentView(R.layout.activity_crunches);
                break;
            case 9:
                setContentView(R.layout.activity_pause);
                break;
            case 10:
                setContentView(R.layout.activity_situp);
                break;
            case 11:
                setContentView(R.layout.activity_rotation);
                break;
            case 12:
                setContentView(R.layout.activity_twist);
                break;
            case 13:
                setContentView(R.layout.activity_windmill);
                break;
            case 14:
                setContentView(R.layout.activity_legup);
                break;
            case 15:
                setContentView(R.layout.activity_plank);
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
        String num2 = num1.substring(0, 2);
        String num3 = num1.substring(3, 5);

        final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);
        MTimeLeftMills = number * 1000;

        countDownTimer = new CountDownTimer(MTimeLeftMills, 1000) {
            @Override
            public void onTick(long l) {
                MTimeLeftMills = l;
                UpdateTimer();
            }

            @Override
            public void onFinish() {
                int newvalue = Integer.valueOf(buttonvalue);
                if (newvalue <= 7) {
                    Intent intent = new Intent(ExerciseActivity.this, ExerciseActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);
                } else {
                    newvalue = 1;
                    Intent intent = new Intent(ExerciseActivity.this, ExerciseActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);
                }
            }
        }.start();
        btnstart.setText("PAUSE");
        MTimeRunning = true;
    }

    private void UpdateTimer() {
        int minutes = (int) MTimeLeftMills / 60000;
        int seconds = (int) MTimeLeftMills % 60000 / 1000;
        String timelefttext = "";
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
