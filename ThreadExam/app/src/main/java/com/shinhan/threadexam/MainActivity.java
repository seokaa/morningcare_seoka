package com.shinhan.threadexam;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressHandler progressHandler = new ProgressHandler();
    Handler handler = new Handler();
    ProgressRunnable progressRunnable = new ProgressRunnable();
    boolean isRunning = false;
    ProgressBar progressBar1, progressBar2;
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView)findViewById(R.id.textview1);
        textView2 = (TextView)findViewById(R.id.textview1);
        progressBar1 = (ProgressBar)findViewById(R.id.progress1);
        progressBar2 = (ProgressBar)findViewById(R.id.progress2);
    }
}

public class ProgressHandler(){
        ProgressHandler
        };