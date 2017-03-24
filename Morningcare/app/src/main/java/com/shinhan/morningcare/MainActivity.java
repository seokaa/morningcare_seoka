package com.shinhan.morningcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText currentTime = (EditText)findViewById(R.id.editText0);
        Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String now = (new SimpleDateFormat("HH:mm:ss")).format(date);
        currentTime.setText(now);
    }
}
