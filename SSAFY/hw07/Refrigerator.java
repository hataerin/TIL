package com.ssafy.hw07.step3;

public class Refrigerator extends Product {
    private int liter;

    public Refrigerator(int id, String name, int price, int stock, int liter) {
        super(id, name, price, stock);
        this.liter = liter;
    }

    public int getLiter() {
        return liter;
    }

    public void setLiter(int liter) {
        this.liter = liter;
    }

    @Override
    public String toString() {
        return super.toString() + ", 용량 : " + liter + "L";
    }
}
