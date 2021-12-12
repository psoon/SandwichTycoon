package com.example.sandwichtycoon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class otherUpgrade extends Fragment {

    public otherUpgrade() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_other_upgrade, container, false);
        int[] needMoneyToUpg = MainActivity.getNeedMoneyToUpgFood();
        Button expPerSecondBtn = rootview.findViewById(R.id.expPerSecondBtn);
        Button moneyPerSecondBtn = rootview.findViewById(R.id.moneyPerSecondBtn);
        TextView expPerSecondTv = rootview.findViewById(R.id.expPerSecondTv);
        TextView moneyPerSecondTv = rootview.findViewById(R.id.moneyPerSecondTv);

        if((MainActivity.expPerSecond/10)>=10) expPerSecondBtn.setClickable(false);
        if((MainActivity.goldPerSecond/100)>=10) moneyPerSecondBtn.setClickable(false);

        expPerSecondTv.setText("시간당 경험치 획등량 증가 : " + MainActivity.expPerSecond+"\n업그레이드 비용 : "+MainActivity.needMoneyToUpgFood[(MainActivity.expPerSecond/10)-1]);
        moneyPerSecondTv.setText("시간당 골드 획득량 증가 : " + MainActivity.goldPerSecond+"\n업그레이드 비용 : "+MainActivity.needMoneyToUpgFood[(MainActivity.goldPerSecond/100)-1]);
        expPerSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((MainActivity.expPerSecond/10)<10){
                    if(MainActivity.userInfo.getUserMoney()>=needMoneyToUpg[(MainActivity.expPerSecond/10)-1]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpg[(MainActivity.expPerSecond/10)-1]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                        MainActivity.expPerSecond += 10;
                        expPerSecondTv.setText("시간당 경험치 획등량 증가 : " + MainActivity.expPerSecond+"\n업그레이드 비용 : "+MainActivity.needMoneyToUpgFood[(MainActivity.expPerSecond/10)-1]);
                    }
                    if((MainActivity.expPerSecond/10) == 10) {
                        expPerSecondBtn.setText("최고 레벨");
                        expPerSecondBtn.setClickable(false);
                    }
                }
            }
        });
        moneyPerSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((MainActivity.goldPerSecond/100)<10){
                    if(MainActivity.userInfo.getUserMoney()>=needMoneyToUpg[(MainActivity.goldPerSecond/100)-1]){
                        MainActivity.userInfo.setUserMoney(MainActivity.userInfo.getUserMoney() - needMoneyToUpg[(MainActivity.goldPerSecond/100)-1]);
                        MainActivity.currentMoney.setText(String.valueOf((int)MainActivity.userInfo.getUserMoney()));
                        MainActivity.goldPerSecond += 100;
                        moneyPerSecondTv.setText("시간당 골드 획득량 증가 : " + MainActivity.goldPerSecond+"\n업그레이드 비용 : "+MainActivity.needMoneyToUpgFood[(MainActivity.goldPerSecond/100)-1]);
                    }
                    if((MainActivity.goldPerSecond/100) == 10) {
                        moneyPerSecondBtn.setText("최고 레벨");
                        moneyPerSecondBtn.setClickable(false);
                    }
                }
            }
        });
        return rootview;
    }
}