package com.example.roya.cookingstudio;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // show the splash screen
        setContentView(R.layout.activity_main);

        mProgress = findViewById(R.id.splash_screen_progress_bar);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }

    private void doWork() {

        for (int progress = 0; progress < 100; progress += 10) {

            try {

                Thread.sleep(200);
                mProgress.setProgress(progress);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(MainActivity.this, HomeScreen.class);
        startActivity(intent);
    }
}