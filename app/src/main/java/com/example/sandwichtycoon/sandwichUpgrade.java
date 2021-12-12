package com.example.sandwichtycoon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class sandwichUpgrade extends Fragment {
    TextView stvArr[] = new TextView[11];
    Button sbtnArr[] = new Button[11];
    Integer[] id_stv = {
            R.id.sandTv1, R.id.sandTv2, R.id.sandTv3, R.id.sandTv4, R.id.sandTv5, R.id.sandTv6, R.id.sandTv7, R.id.sandTv8,
            R.id.sandTv9, R.id.sandTv10, R.id.sandTv11
    };
    Integer[] id_sbtn = {
            R.id.sandBtn1, R.id.sandBtn2, R.id.sandBtn3, R.id.sandBtn4, R.id.sandBtn5, R.id.sandBtn6, R.id.sandBtn7, R.id.sandBtn8,
            R.id.sandBtn9, R.id.sandBtn10, R.id.sandBtn11
    };
    String[] sandName = {
            "베지", "에그마요", "베이컨", "참치", "햄", "치킨 데리야끼", "풀드포크", "스테이크", "이탈리안 비엠티", "로스트 치킨", "k-바베큐"
    };
    public sandwichUpgrade() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_sandwich_upgrade, container, false);
        for(int i = 0; i<id_stv.length; i++){
            stvArr[i] = (TextView)rootview.findViewById(id_stv[i]);
            sbtnArr[i] = (Button)rootview.findViewById(id_sbtn[i]);
            if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(i).needLevel){
                stvArr[i].setText(sandName[i]);
                sbtnArr[i].setText("열림!");
                sbtnArr[i].setClickable(false);
            }
            else{
                stvArr[i].setText(sandName[i] + " 잠김");
                sbtnArr[i].setText("해제!");
                sbtnArr[i].setClickable(true);
            }
        }
        sbtnArr[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(0).needLevel){
                    stvArr[0].setText(sandName[0]);
                    sbtnArr[0].setText("열림!");
                    sbtnArr[0].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(0).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sbtnArr[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(1).needLevel){
                    stvArr[1].setText(sandName[1]);
                    sbtnArr[1].setText("열림!");
                    sbtnArr[1].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(1).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sbtnArr[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(2).needLevel){
                    stvArr[2].setText(sandName[2]);
                    sbtnArr[2].setText("열림!");
                    sbtnArr[2].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(2).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sbtnArr[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(3).needLevel){
                    stvArr[3].setText(sandName[3]);
                    sbtnArr[3].setText("열림!");
                    sbtnArr[3].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(3).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sbtnArr[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(4).needLevel){
                    stvArr[4].setText(sandName[4]);
                    sbtnArr[4].setText("열림!");
                    sbtnArr[4].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(4).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sbtnArr[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(5).needLevel){
                    stvArr[5].setText(sandName[5]);
                    sbtnArr[5].setText("열림!");
                    sbtnArr[5].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(5).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sbtnArr[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(6).needLevel){
                    stvArr[6].setText(sandName[6]);
                    sbtnArr[6].setText("열림!");
                    sbtnArr[6].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(6).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sbtnArr[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(7).needLevel){
                    stvArr[7].setText(sandName[7]);
                    sbtnArr[7].setText("열림!");
                    sbtnArr[7].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(7).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sbtnArr[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(8).needLevel){
                    stvArr[8].setText(sandName[8]);
                    sbtnArr[8].setText("열림!");
                    sbtnArr[8].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(8).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sbtnArr[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(9).needLevel){
                    stvArr[9].setText(sandName[9]);
                    sbtnArr[9].setText("열림!");
                    sbtnArr[9].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(9).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sbtnArr[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.userInfo.getUserLevel() >= MainActivity.dataList.get(10).needLevel){
                    stvArr[10].setText(sandName[10]);
                    sbtnArr[10].setText("열림!");
                    sbtnArr[10].setClickable(false);
                    MainActivity.setSandwichIdx++;
                }
                else{
                    Toast.makeText(getContext(), (MainActivity.dataList.get(10).needLevel - MainActivity.userInfo.getUserLevel()) + "레벨이 더 필요합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootview;
    }
}