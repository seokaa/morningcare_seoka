package com.shinhan.hellowworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 변수 세팅
        Button button = (Button)findViewById(R.id.button1);
        TextView textView = (TextView)findViewById(R.id.textview);
        //textView.setText("안녕, 석화야!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "버튼1 클릭", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onButton2Clicked(View v) {
        Toast.makeText(MainActivity.this, "버튼2 클릭", Toast.LENGTH_SHORT).show();
    }

    public void onButton3Clicked(View v) {
        Intent internetIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(internetIntent);
    }

    public void onButton4Clicked(View v) {
        Intent callIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-9102-5203"));
        startActivity(callIntent);
    }

}
