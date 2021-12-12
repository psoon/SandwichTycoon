package com.example.sandwichtycoon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class questActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        Button receiveBtn = findViewById(R.id.questBtn1);
        TextView questTv = findViewById(R.id.questTv1);
        Button closeBtn = findViewById(R.id.closeBtn);


        questTv.setText(MainActivity.questReqLv + "레벨 달성");
        receiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel()>= MainActivity.questReqLv){
                    MainActivity.userInfo.setUserJem(MainActivity.userInfo.getUserJem() + 30);
                    MainActivity.questReqLv += 5;
                    questTv.setText(MainActivity.questReqLv + "레벨 달성");
                    Toast.makeText(getApplicationContext(), "젬 5개 획득!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), (MainActivity.questReqLv - MainActivity.userInfo.getUserLevel()) + "레벨이 부족합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
