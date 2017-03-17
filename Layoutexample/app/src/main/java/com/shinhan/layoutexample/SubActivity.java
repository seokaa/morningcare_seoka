package com.shinhan.layoutexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void clicked2(View view) {
        ImageView image1 = (ImageView)findViewById(R.id.i1);
        ImageView image2 = (ImageView)findViewById(R.id.i2);
        Button button = (Button)view;

        if(button.getText().toString().equals("외관")){
            image1.setBackgroundResource(R.drawable.a3);
            image2.setBackgroundResource(R.drawable.a4);

        }else{
            image1.setBackgroundResource(R.drawable.a5);
            image2.setBackgroundResource(R.drawable.a6);

        }
    }
}
