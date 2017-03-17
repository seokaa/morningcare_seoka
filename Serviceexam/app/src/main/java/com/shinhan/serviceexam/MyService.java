package com.shinhan.serviceexam;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()-------------------------!!!!!");
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand()-------------------!!!!!");
        if(intent==null){ // 인텐트가 널일경우 자동 재시작 처리
            return Service.START_STICKY;
        }else{ // 인텐트가 정상일 경우
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");
            Log.d(TAG, "command:"+command+" ,name:"+name);//정상로그
            /////////////////////////////////////////////////
            Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
            showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP );
            showIntent.putExtra("command", command);
            showIntent.putExtra("name", name+"from service");
            startActivity(showIntent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
