package com.example.sandwichtycoon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StoreActivity extends AppCompatActivity {
    Button coin1, coin2, coin3, coin4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        coin1 = findViewById(R.id.coin1);
        coin2 = findViewById(R.id.coin2);
        coin3 = findViewById(R.id.coin3);
        coin4 = findViewById(R.id.coin4);

        coin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserJem() >= 10){
                    MainActivity.userInfo.setUserJem(MainActivity.userInfo.getUserJem() - 10);
                    MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() + 10000);
                    MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    Toast.makeText(getApplicationContext(), "구입 완료!",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),(10 - MainActivity.userInfo.getUserJem()) + "개의 잼이 부족합니다", Toast.LENGTH_SHORT).show();
            }
        });
        coin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserJem() >= 19){
                    MainActivity.userInfo.setUserJem(MainActivity.userInfo.getUserJem() - 19);
                    MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() + 20000);
                    MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    Toast.makeText(getApplicationContext(), "구입 완료!",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),(19 - MainActivity.userInfo.getUserJem()) + "개의 잼이 부족합니다", Toast.LENGTH_SHORT).show();
            }
        });
        coin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserJem() >= 40){
                    MainActivity.userInfo.setUserJem(MainActivity.userInfo.getUserJem() - 40);
                    MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() + 50000);
                    MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    Toast.makeText(getApplicationContext(), "구입 완료!",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),(40 - MainActivity.userInfo.getUserJem()) + "개의 잼이 부족합니다", Toast.LENGTH_SHORT).show();
            }
        });
        coin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserJem() >= 70){
                    MainActivity.userInfo.setUserJem(MainActivity.userInfo.getUserJem() - 70);
                    MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() + 100000);
                    MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    Toast.makeText(getApplicationContext(), "구입 완료!",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),(70 - MainActivity.userInfo.getUserJem()) + "개의 잼이 부족합니다", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
