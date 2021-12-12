package com.example.sandwichtycoon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{
    static MediaPlayer mp;
    CountDownTimer countDownTimer;
    ImageButton lettuceBtn, tomatoBtn, onionBtn, mozzalleraBtn, americancheeseBtn, meatBtn, customerBtn, moneyPotionBtn, expPotionBtn;
    ImageView lettuceIv, tomatoIv, onionIv, cheeseIv, meatIv;
    static TextView tvTimer, customerTv, currentMoney;
    ProgressBar currentExp;
    static UserInfo userInfo;
    Button tabSizeBtn, finishBtn;
    LinearLayout tabLin;
    public static ArrayList<SandInfo> dataList = new ArrayList<SandInfo>();
    boolean isTabOpen = false, isRun = true;
    public static int[] needMoneyToUpgFood = {10000, 20000, 40000, 60000, 80000, 100000, 130000, 160000 ,190000, 250000};
    public static int[] foodLvArr = new int[15];
    JSONObject obj;
    static int goldPerSecond, expPerSecond, setSandwichIdx, questReqLv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lettuceBtn = findViewById(R.id.lettuceBtn);
        tomatoBtn = findViewById(R.id.tomatoBtn);
        onionBtn = findViewById(R.id.onionBtn);
        mozzalleraBtn = findViewById(R.id.mozzalleraBtn);
        americancheeseBtn = findViewById(R.id.americancheeseBtn);
        meatBtn = findViewById(R.id.meatBtn);
        finishBtn = findViewById(R.id.finishBtn);
        moneyPotionBtn = findViewById(R.id.moneypotion);
        expPotionBtn = findViewById(R.id.exppotion);

        lettuceIv = findViewById(R.id.lettuceIv);
        tomatoIv = findViewById(R.id.tomatoIv);
        onionIv = findViewById(R.id.onionIv);
        cheeseIv =findViewById(R.id.cheeseIv);
        meatIv = findViewById(R.id.meatIv);
        customerBtn = findViewById(R.id.customer);
        customerTv = findViewById(R.id.customerTv);


        currentExp = (ProgressBar)findViewById(R.id.expBar);
        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager(), 1);
        pager.setAdapter(adapter);
        TabLayout tab = findViewById(R.id.tabLayout1);
        tab.setupWithViewPager(pager);


        int startPrice = 3000, startExp = 20, openLevel = 1;
        dataList.add(0, new SandInfo(startPrice, startExp, 0));
        for(int idx = 1; idx<11; idx++, startPrice += 2000, startExp += 10, openLevel += 5){
            dataList.add(idx, new SandInfo(startPrice, startExp, openLevel));
        }
        try{
            FileInputStream fis = openFileInput("datafile.json");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while(line!=null){
                sb.append(line+"\n");
                line = br.readLine();
            }
            String jsonData = sb.toString();
            obj = new JSONObject(jsonData);
            int userLevel = obj.getInt("userLevel");
            int userExp = obj.getInt("userExp");
            long userMoney = obj.getLong("userMoney");
            int userJem = obj.getInt("userJem");
            goldPerSecond = obj.getInt("goldPerSecond");
            expPerSecond = obj.getInt("expPerSecond");
            currentExp.setMax(obj.getInt("maxExpBar"));
            userInfo = new UserInfo(userLevel, userExp, userMoney, userJem);
            setSandwichIdx = userInfo.getUserLevel() / 5;
            questReqLv = obj.getInt("questReqLv");
            if(setSandwichIdx > 14) setSandwichIdx = 14;
            for(int i = 0; i<foodLvArr.length; i++){
                foodLvArr[i] = obj.getInt("num"+(i+1)+"lv");
            }
            Toast.makeText(getApplicationContext(), "데이터 로딩에 성공하였습니다",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            userInfo = new UserInfo(1,0,0,0);
            goldPerSecond = 100; expPerSecond = 10;
            questReqLv = 5;
            currentExp.setMax(100);
            Toast.makeText(getApplicationContext(), "데이터 로딩에 실패하였습니다",Toast.LENGTH_SHORT).show();
        }

        mp = MediaPlayer.create(this,R.raw.bgm);
        mp.setLooping(true);
        mp.start();

        tabSizeBtn = (Button)findViewById(R.id.tabSizeBtn);
        tabSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabLin = (LinearLayout)findViewById(R.id.tabLinearLayout);
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)tabLin.getLayoutParams();
                if(isTabOpen){
                    params.weight = 1.5f;
                    isTabOpen = false;
                }
                else {
                    params.weight = 0.3f;
                    isTabOpen = true;
                }
                tabLin.setLayoutParams(params);
            }
        });

        if(userInfo.getUserLevel() < 6) meatBtn.setVisibility(View.INVISIBLE);
        else meatBtn.setVisibility(View.VISIBLE);
        customerTv.setText("저를 클릭하면 새로운 손님을 받을 수 있어요!");
        ImageButton jemBtn = (ImageButton)findViewById(R.id.jemBtn);
        jemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("JEM");
                dlg.setMessage("현재 "+(userInfo.getUserJem()) + "개를 가지고 있습니다.");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dlg.show();
            }
        });
        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
        expPotionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userInfo.getUserJem() >= 10){
                    userInfo.setUserJem(userInfo.getUserJem() - 10);
                    CountDownTimer expTimer = new CountDownTimer(30000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            userInfo.setUserExp(userInfo.getUserExp() + expPerSecond * 2);
                            currentExp.setProgress(currentExp.getProgress()+expPerSecond);
                            if(userInfo.getUserExp() >= currentExp.getMax()){
                                currentExp.setMax((int)(currentExp.getMax()*1.5));
                                currentExp.setProgress(0);
                                userInfo.setUserLevel(userInfo.getUserLevel()+1);
                                userInfo.setUserExp(0);
                            }
                        }

                        @Override
                        public void onFinish() {
                            this.cancel();
                            return;
                        }
                    }.start();
                }
            }
        });
        moneyPotionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userInfo.getUserJem() >= 10){
                    userInfo.setUserJem(userInfo.getUserJem() - 10);
                    CountDownTimer goldTimer = new CountDownTimer(30000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            userInfo.setUserMoney(userInfo.getUserMoney()+goldPerSecond*2);
                            currentMoney.setText(String.valueOf((int)userInfo.getUserMoney()));
                        }
                        @Override
                        public void onFinish() {
                            this.cancel();
                            return;
                        }
                    }.start();
                }
            }
        });
        Timer getMoneyTimer = new Timer();
        currentMoney = (TextView)findViewById(R.id.currentMoney);
        TimerTask getMoneyTimerTask = new TimerTask() {
            @Override
            public void run() {
                userInfo.setUserMoney(userInfo.getUserMoney()+goldPerSecond);
                userInfo.setUserExp(userInfo.getUserExp()+expPerSecond);
                currentMoney.setText(String.valueOf((int)userInfo.getUserMoney()));
                currentExp.setProgress(currentExp.getProgress()+expPerSecond);
                if(userInfo.getUserExp() >= currentExp.getMax()){
                    currentExp.setMax((int)(currentExp.getMax()*1.5));
                    currentExp.setProgress(0);
                    userInfo.setUserLevel(userInfo.getUserLevel()+1);
                    userInfo.setUserExp(0);
                }
            }
        };
        getMoneyTimer.schedule(getMoneyTimerTask, 1000, 10000);
        tvTimer = (TextView)findViewById(R.id.timer);
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(String.valueOf((int)(millisUntilFinished/1000)));
                if((int)(millisUntilFinished/1000)>20) customerBtn.setImageResource(R.drawable.good);
                else if((int)(millisUntilFinished/1000)>10) customerBtn.setImageResource(R.drawable.soso);
                else customerBtn.setImageResource(R.drawable.angry);
            }
            @Override
            public void onFinish() {
                countDownTimer.cancel();
                tomatoIv.setVisibility(View.INVISIBLE);
                onionIv.setVisibility(View.INVISIBLE);
                lettuceIv.setVisibility(View.INVISIBLE);
                cheeseIv.setVisibility(View.INVISIBLE);
                meatIv.setVisibility(View.INVISIBLE);
                customerTv.setText("저를 클릭하면 새로운 손님을 받을 수 있어요!");
            }
        };
    }
    public void play(){
        countDownTimer.start();
        Random random = new Random();
        int max = 0;
        int[] recipe = new int[6];
        int[] checkRecipe = new int[6];
        for(int i = 0; i<recipe.length; i++){
            recipe[i] = random.nextInt(2) + 1;
            max += recipe[i];
        }
        if(userInfo.getUserLevel() < 6){
            recipe[5] = 0;
            meatBtn.setVisibility(View.INVISIBLE);
        }
        else meatBtn.setVisibility(View.VISIBLE);
        customerTv.setText("양상추 " + recipe[0] + "개, " + "토마토 " + recipe[1] + "개, " + "양파 " + recipe[2] + "개, "
                + "모짜렐라 치즈 " + recipe[3] + "개, " + "아메리칸 치즈 " + recipe[4] + "개, " + "패티 " + recipe[5] + "개, ");
        lettuceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lettuceIv.setVisibility(View.VISIBLE);
                checkRecipe[0]++;
            }
        });
        tomatoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomatoIv.setVisibility(View.VISIBLE);
                checkRecipe[1]++;
            }
        });
        onionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onionIv.setVisibility(View.VISIBLE);
                checkRecipe[2]++;
            }
        });
        mozzalleraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheeseIv.setVisibility(View.VISIBLE);
                checkRecipe[3]++;
            }
        });
        americancheeseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheeseIv.setVisibility(View.VISIBLE);
                checkRecipe[4]++;
            }
        });
        meatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meatIv.setVisibility(View.VISIBLE);
                checkRecipe[5]++;
            }
        });
        int finalMax = max;
        finishBtn.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            int result = 0;
            @Override
            public void onClick(View v) {
                for(int i = 0; i<5; i++){
                    if(recipe[i] == checkRecipe[i]) {
                        count++;
                    }
                    result += checkRecipe[i] * (foodLvArr[i]+1) * 500;
                }
                result += checkRecipe[5] * foodLvArr[setSandwichIdx] + dataList.get(setSandwichIdx).sandPrice;
                double accuracy = 0;
                if(count == 0) {
                    countDownTimer.onFinish();
                    return;
                }
                accuracy = count/(double)finalMax;
                int pay = (int) (result*accuracy);
                userInfo.setUserMoney(userInfo.getUserMoney() + pay);
                Toast.makeText(getApplicationContext(), pay + "원 획득!", Toast.LENGTH_SHORT).show();
                userInfo.setUserExp(userInfo.getUserExp() + dataList.get(setSandwichIdx).sandExp);
                currentMoney.setText(String.valueOf((int)userInfo.getUserMoney()));
                currentExp.setProgress(userInfo.getUserExp());
                if(userInfo.getUserExp() >= currentExp.getMax()){
                    currentExp.setMax((int)(currentExp.getMax()*1.5));
                    currentExp.setProgress(0);
                    userInfo.setUserLevel(userInfo.getUserLevel()+1);
                    userInfo.setUserExp(0);
                }
                countDownTimer.onFinish();
                return;
            }
        });
    }
    public static int[] getNeedMoneyToUpgFood(){ return needMoneyToUpgFood;}
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("종료하시겠습니까?");

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                JSONObject json = new JSONObject();
                try{
                    json.put("userLevel", userInfo.getUserLevel());
                    json.put("userMoney", userInfo.getUserMoney());
                    json.put("userExp", userInfo.getUserExp());
                    json.put("userJem", userInfo.getUserJem());
                    for(int o = 0 ; o<foodLvArr.length; o++){
                        json.put("num"+(o+1)+"lv", foodLvArr[o]);
                    }
                    json.put("goldPerSecond", goldPerSecond);
                    json.put("expPerSecond", expPerSecond);
                    json.put("maxExpBar", currentExp.getMax());
                    json.put("questReqLv",questReqLv);
                    String jsonString = json.toString();
                    FileOutputStream fos = openFileOutput("datafile.json", Context.MODE_PRIVATE);
                    fos.write(jsonString.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(), "파일 저장에 성공하였습니다", Toast.LENGTH_SHORT).show();
                    isRun = false;
                    mp.stop();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "파일 저장에 실패하였습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setTitle("게임 종료");
        builder.show();
     }

    public void settingOnClick(View view) {
        Intent intent2 = new Intent(this,SettingActivity.class);
        startActivity(intent2);
    }

     public void questOnClick(View view){
         Intent intent = new Intent(this,questActivity.class);
         startActivity(intent);
     }

    public void storeOnClick(View view) {
        Intent intent3 = new Intent(this,StoreActivity.class);
        startActivity(intent3);
    }
}