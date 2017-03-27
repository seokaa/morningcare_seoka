package com.shinhan.morningcare;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.R.attr.keycode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int Second = 1000;
    int count = 100000;
    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button wakeTimeButton = (Button)findViewById(R.id.wakeTimeButton);
        Button readyTimeButton = (Button)findViewById(R.id.readyTimeButton);
        Button companyTimeButton = (Button)findViewById(R.id.companyTimeButton);
        Button d2dTimeButton = (Button)findViewById(R.id.d2dTimeButton);
        Button completeButton = (Button)findViewById(R.id.completeButton);

        wakeTimeButton.setOnClickListener(this);
        readyTimeButton.setOnClickListener(this);
        companyTimeButton.setOnClickListener(this);
        d2dTimeButton.setOnClickListener(this);
        completeButton.setOnClickListener(this);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        // 현재시간
        //EditText currentTime = (EditText)findViewById(R.id.wakeTimeText);
        String now = (new SimpleDateFormat("HHmmss")).format(date);
        //currentTime.setText(now+"");
        count = Integer.parseInt(now);
        new CountDownTimer(count*Second, Second) { // 기간, 간격
            @Override
            public void onTick(long millisUntilFinished) {
                TextView currentTime = (TextView) findViewById(R.id.editText0);
                currentTime.setText(count+"");
                count++;
            }
            @Override
            public void onFinish() {
            }
        }.start();

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.wakeTimeButton:
                timeSetting2(R.id.wakeTimeText);
                break;
            case R.id.readyTimeButton:
                timeSetting2(R.id.readyTimeText);
                break;
            case R.id.companyTimeButton:
                timeSetting2(R.id.companyTimeText);
                break;
            case R.id.d2dTimeButton:
                timeSetting2(R.id.d2dTimeText);
                break;
            case R.id.completeButton:

                Toast.makeText(MainActivity.this, "설정되었습니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);


                /*
                Intent intent = new Intent(MainActivity.this,
                        AlarmReceiver.class);
                PendingIntent pender = PendingIntent.getBroadcast(
                        MainActivity.this, 0, intent, 0);

                EditText edit1 = (EditText) this.findViewById(R.id.edit1);
                int year = Integer.valueOf(edit1.getText().toString());
                EditText edit2 = (EditText) this.findViewById(R.id.edit2);
                int month = Integer.valueOf(edit2.getText().toString());
                EditText edit3 = (EditText) this.findViewById(R.id.edit3);
                int day = Integer.valueOf(edit3.getText().toString());
                EditText edit4 = (EditText) this.findViewById(R.id.edit4);
                int hour = Integer.valueOf(edit4.getText().toString());
                EditText edit5 = (EditText) this.findViewById(R.id.edit5);
                int minute = Integer.valueOf(edit5.getText().toString());

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month - 1, day, hour, minute);

                alarm.set(AlarmManager.RTC, calendar.getTimeInMillis(), pender);
                */

                break;
        }

    }

    public void timeSetting2(int to){
        final int setting = to;
        TimePickerDialog.OnTimeSetListener timeSetListener;
        new TimePickerDialog(MainActivity.this,

                timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // TODO Auto-generated method stub
                        String msg = String.format("%2d : %2d", hourOfDay, minute);
                        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                        EditText changedTime = (EditText)findViewById(setting);
                        changedTime.setText(msg);
                    }
                }
                , hour, minute, false).show();
    }

    public void timeSetting1(int to){
        final int setting = to;

        Context mContext = getApplicationContext();
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

        //R.layout.dialog는 xml 파일명이고  R.id.popup은 보여줄 레이아웃 아이디
        final View layout = inflater.inflate(R.layout.timeedit,(ViewGroup) findViewById(R.id.popup));
        AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);

        aDialog.setTitle("시간설정"); //타이틀바 제목
        aDialog.setView(layout); //dialog.xml 파일을 뷰로 셋팅

        //그냥 닫기버튼을 위한 부분
        aDialog.setNegativeButton("수정", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                EditText changedTime = (EditText)findViewById(setting);
                EditText editHour = (EditText)layout.findViewById(R.id.editHour);
                EditText editMinute = (EditText)layout.findViewById(R.id.editMinute);

                String hour = editHour.getText().toString();
                String minute = editMinute.getText().toString();

                changedTime.setText(" "+hour+" : "+minute+" ");
            }
        });
        AlertDialog ad = aDialog.create();
        ad.show();
    }
}
