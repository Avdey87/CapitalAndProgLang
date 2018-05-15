package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class TimerActivity extends Activity {

    private static final String IS_RUNNING_KEY = "running";
    private static final String WAS_RUNNING_LEY = "wasRunning";
    private static final String SECONDS_KEY = "seconds";

    // is static by intention?
    private int seconds = 0;
    private boolean isRunning;
    private boolean wasRunning;

    private TextView timerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt(SECONDS_KEY);
            isRunning = savedInstanceState.getBoolean(IS_RUNNING_KEY);
            wasRunning = savedInstanceState.getBoolean(WAS_RUNNING_LEY);
        }

        timerView = findViewById(R.id.timer_text);

        runTimer();
    }

    private void runTimer() {
        timerView.post(new Runnable() {
            @Override
            public void run() {
                int hour = seconds / 3600;
                int min = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format("%2d:%02d:%02d", hour, min, sec);
                timerView.setText(time);

                if (isRunning) {
                    seconds++;
                }
                timerView.postDelayed(this, 1000);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            wasRunning = isRunning;
            isRunning = true;
        }
    }

    public void onClickStart(View view) {
        isRunning = true;
    }

    public void onClickStop(View view) {
        isRunning = false;
    }

    public void onClickResume(View view) {
        isRunning = false;
        seconds = 0;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(WAS_RUNNING_LEY, wasRunning);
        outState.putBoolean(IS_RUNNING_KEY, isRunning);
        outState.putInt(SECONDS_KEY, seconds);
    }
}
