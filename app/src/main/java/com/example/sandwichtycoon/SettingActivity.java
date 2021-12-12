package com.example.sandwichtycoon;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Switch bgm = findViewById(R.id.bgm);
        if(MainActivity.mp.isPlaying()) bgm.setChecked(true);
        else bgm.setChecked(false);
        bgm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    MainActivity.mp = MediaPlayer.create(getApplicationContext(),R.raw.bgm);
                    MainActivity.mp.setLooping(true);
                    MainActivity.mp.start();
                }
                else MainActivity.mp.stop();
            }
        });

        Button devUrl = findViewById(R.id.devUrl);
        devUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://bestkcs1234.tistory.com"));
                startActivity(intent);
            }
        });
        Button closeBtn = findViewById(R.id.settingCloseBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
