package com.example.sandwichtycoon;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class foodUpgrade extends Fragment {
    TextView ftvArr[] = new TextView[15];
    Button fbtnArr[] = new Button[15];
    Integer[] id_ftv = {
            R.id.foodTv1, R.id.foodTv2, R.id.foodTv3, R.id.foodTv4, R.id.foodTv5, R.id.foodTv6, R.id.foodTv7, R.id.foodTv8,
            R.id.foodTv9, R.id.foodTv10, R.id.foodTv11, R.id.foodTv12, R.id.foodTv13, R.id.foodTv14, R.id.foodTv15
    };
    Integer[] id_fbtn = {
            R.id.foodBtn1, R.id.foodBtn2, R.id.foodBtn3, R.id.foodBtn4, R.id.foodBtn5, R.id.foodBtn6, R.id.foodBtn7, R.id.foodBtn8,
            R.id.foodBtn9, R.id.foodBtn10, R.id.foodBtn11, R.id.foodBtn12, R.id.foodBtn13, R.id.foodBtn14, R.id.foodBtn15
    };
    String[] foodName = {
            "양상추", "토마토", "양파", "아메리칸 치즈", "모짜렐라 치즈", "에그마요", "베이컨", "참치", "햄", "치킨 데리야끼", "풀드포크", "스테이크", "이탈리안 비엠티", "로스트 치킨", "k-바베큐"
    };
    public foodUpgrade() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_food_upgrade, container, false);
        int[] needMoneyToUpgFood = MainActivity.getNeedMoneyToUpgFood();
        for(int i = 0; i<id_ftv.length; i++){
            ftvArr[i] = (TextView)rootview.findViewById(id_ftv[i]);
            ftvArr[i].setText(foodName[i] + "Lv "+MainActivity.foodLvArr[i]+ "\n업그레이드 비용 :" +needMoneyToUpgFood[MainActivity.foodLvArr[i]]);
        }
        for(int i = 0; i<id_fbtn.length; i++){
            fbtnArr[i] = (Button)rootview.findViewById(id_fbtn[i]);
        }
        fbtnArr[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[0]<10){
                    if(MainActivity.userInfo.getUserMoney() >= MainActivity.needMoneyToUpgFood[MainActivity.foodLvArr[0]]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - MainActivity.needMoneyToUpgFood[MainActivity.foodLvArr[0]]);
                        MainActivity.foodLvArr[0]++;
                        ftvArr[0].setText(foodName[0] + "Lv "+MainActivity.foodLvArr[0]+ "\n업그레이드 비용 :" + MainActivity.needMoneyToUpgFood[MainActivity.foodLvArr[0]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10){
                    if(MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[1]]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[1]]);
                        MainActivity.foodLvArr[1]++;
                        ftvArr[1].setText(foodName[1] + "Lv "+MainActivity.foodLvArr[1]+ "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[1]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[2]<10){
                    if(MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[2]]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[2]]);
                        MainActivity.foodLvArr[2]++;
                        ftvArr[2].setText(foodName[2] + "Lv "+MainActivity.foodLvArr[2]+ "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[2]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10){
                    if(MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[3]]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[3]]);
                        MainActivity.foodLvArr[3]++;
                        ftvArr[3].setText(foodName[3] + "Lv "+MainActivity.foodLvArr[3]+ "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[3]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10) {
                    if (MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[4]]) {
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[4]]);
                        MainActivity.foodLvArr[4]++;
                        ftvArr[4].setText(foodName[4] + "Lv " + MainActivity.foodLvArr[4] + "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[4]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10) {
                    if (MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[5]]) {
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[5]]);
                        MainActivity.foodLvArr[5]++;
                        ftvArr[5].setText(foodName[5] + "Lv " + MainActivity.foodLvArr[5] + "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[5]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10) {
                    if (MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[6]]) {
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[6]]);
                        MainActivity.foodLvArr[6]++;
                        ftvArr[6].setText(foodName[6] + "Lv " + MainActivity.foodLvArr[6] + "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[6]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.foodLvArr[1] < 10) {
                    if (MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[7]]) {
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[7]]);
                        MainActivity.foodLvArr[7]++;
                        ftvArr[7].setText(foodName[7] + "Lv " + MainActivity.foodLvArr[7] + "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[7]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                } else {
                    ftvArr[0].setText("최고 레벨 입니다.");
                }
            }
        });
        fbtnArr[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.foodLvArr[1] < 10) {
                    if (MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[8]]) {
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[8]]);
                        MainActivity.foodLvArr[8]++;
                        ftvArr[8].setText(foodName[8] + "Lv " + MainActivity.foodLvArr[8] + "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[8]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                } else {
                    ftvArr[0].setText("최고 레벨 입니다.");
                }
            }
        });
        fbtnArr[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10){
                    if(MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[9]]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[9]]);
                        MainActivity.foodLvArr[9]++;
                        ftvArr[9].setText(foodName[9] + "Lv "+MainActivity.foodLvArr[9]+ "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[9]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10){
                    if(MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[10]]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[10]]);
                        MainActivity.foodLvArr[10]++;
                        ftvArr[10].setText(foodName[10] + "Lv "+MainActivity.foodLvArr[10]+ "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[10]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10){
                    if(MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[11]]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[11]]);
                        MainActivity.foodLvArr[11]++;
                        ftvArr[11].setText(foodName[11] + "Lv "+MainActivity.foodLvArr[11]+ "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[11]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10){
                    if(MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[12]]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[12]]);
                        MainActivity.foodLvArr[12]++;
                        ftvArr[12].setText(foodName[12] + "Lv "+MainActivity.foodLvArr[12]+ "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[12]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10){
                    if(MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[13]]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[13]]);
                        MainActivity.foodLvArr[13]++;
                        ftvArr[13].setText(foodName[13] + "Lv "+MainActivity.foodLvArr[13]+ "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[13]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });
        fbtnArr[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.foodLvArr[1]<10){
                    if(MainActivity.userInfo.getUserMoney() >= needMoneyToUpgFood[MainActivity.foodLvArr[14]]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpgFood[MainActivity.foodLvArr[14]]);
                        MainActivity.foodLvArr[14]++;
                        ftvArr[14].setText(foodName[14] + "Lv "+MainActivity.foodLvArr[14]+ "\n업그레이드 비용 :" + needMoneyToUpgFood[MainActivity.foodLvArr[14]]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                    }
                }
                else{ftvArr[0].setText("최고 레벨 입니다."); }
            }
        });


        return rootview;
    }
}