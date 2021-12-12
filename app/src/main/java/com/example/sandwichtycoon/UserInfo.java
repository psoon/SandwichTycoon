package com.example.sandwichtycoon;

public class UserInfo {
    int userLevel;
    int userExp;
    long userMoney;
    int userJem;

    public UserInfo(int userLevel, int userExp, long userMoney, int userJem) {
        this.userLevel = userLevel;
        this.userExp = userExp;
        this.userMoney = userMoney;
        this.userJem = userJem;
    }

    public int getUserJem() {
        return userJem;
    }

    public void setUserJem(int userJem) {
        this.userJem = userJem;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getUserExp() {
        return userExp;
    }

    public void setUserExp(int userExp) {
        this.userExp = userExp;
    }

    public long getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(long userMoney) {
        this.userMoney = userMoney;
    }

}
