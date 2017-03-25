package com.shinhan.morningcare;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(Intro.this, MainActivity.class);
                startActivity(intent);
            }
        }, 3*1000); // 3초
    }
}
