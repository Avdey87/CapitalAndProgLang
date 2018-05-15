package com.aavdeev.capitalandproglang;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class Timer extends Activity {

    private static int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");

        }


        runTimer();
    }

    private void runTimer() {
        final TextView timer_text = findViewById(R.id.timer_text);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = seconds / 3600;
                int min = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format("%2d:%02d:%02d", hour, min, sec);
                timer_text.setText(time);

                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            wasRunning = running;
            running = true;
        }
    }

    public void onClickStart(View view) {
        running = true;
    }

    public void onClickStop(View view) {
        running = false;
    }

    public void onClickResume(View view) {
        running = false;
        seconds = 0;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("wasRunning", wasRunning);
        outState.putBoolean("running", running);
        outState.putInt("seconds", seconds);
    }
}
