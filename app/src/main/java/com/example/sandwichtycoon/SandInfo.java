package com.example.sandwichtycoon;

public class SandInfo {
    int sandPrice;
    int sandExp;
    int needLevel;

    public SandInfo(int sandPrice, int sandExp, int needLevel) {
        this.sandPrice = sandPrice;
        this.sandExp = sandExp;
        this.needLevel = needLevel;
    }

    public int getNeedLevel() {
        return needLevel;
    }

    public void setNeedLevel(int needLevel) {
        this.needLevel = needLevel;
    }

    public int getSandPrice() {
        return sandPrice;
    }

    public void setSandPrice(int sandPrice) {
        this.sandPrice = sandPrice;
    }

    public int getSandExp() {
        return sandExp;
    }

    public void setSandExp(int sandExp) {
        this.sandExp = sandExp;
    }

}
