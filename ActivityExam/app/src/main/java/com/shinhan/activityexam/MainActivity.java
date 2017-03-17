package com.shinhan.activityexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View v) {
        EditText editText = (EditText)findViewById(R.id.edittext);
        String string = editText.getText().toString();
        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra("String", string);
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==0){//Sub종료됐다면
            if(resultCode==RESULT_OK){ // 버튼을 눌렀을때만
                String result = data.getStringExtra("String2");
                EditText et = (EditText)findViewById(R.id.edittext);
                et.setText(result);
            }
        }
    }

}