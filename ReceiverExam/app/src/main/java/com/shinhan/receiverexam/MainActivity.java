package com.shinhan.receiverexam;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED){ // 권한이 없을경우
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS) ){
                Toast.makeText(this, "SMS 권한 설명!", Toast.LENGTH_SHORT).show();
            }else{
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECEIVE_SMS}, 1);
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        if(requestCode==1){
            if(grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "SMS권한 승인!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "SMS권한 거부!", Toast.LENGTH_LONG).show();
            }
        }
    }


}
