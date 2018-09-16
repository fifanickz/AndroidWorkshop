package com.arit.demo.mvp;

public class Number {


    int number;

    public  void  increaseNumber() {
        this.number++;
    }

    public void decreaseNumber() {
        this.number--;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
