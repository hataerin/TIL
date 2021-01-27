package com.ssafy.hw06.step3;

public class TV extends Product {
    int inch;
    String displayType;

    public TV(int id, String name, int price, int stock, int inch, String displayType) {
        super(id, name, price, stock);
        this.inch = inch;
        this.displayType = displayType;
    }

    public int getInch() {
        return inch;
    }

    public void setInch(int inch) {
        this.inch = inch;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    @Override
    public String toString() {
        return super.toString() + ", 인치 : " + inch + "inch, 디스플레이 타입 : " + displayType;
    }
}
