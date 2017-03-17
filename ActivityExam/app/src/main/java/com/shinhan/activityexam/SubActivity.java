package com.shinhan.activityexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String string = intent.getStringExtra("String");
        EditText editText = (EditText)findViewById(R.id.edittext2);
        editText.setText(string);
    }

    public void onBackButtonClicked(View v) {
        Intent backIntent = new Intent();
        EditText et = (EditText)findViewById(R.id.edittext2);
        String string = et.getText().toString();
        backIntent.putExtra("String2", string);
        setResult(RESULT_OK, backIntent);
        finish(); //정상종료
    }
}