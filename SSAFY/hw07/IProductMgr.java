package com.ssafy.hw07.step3;

import java.util.ArrayList;

public interface IProductMgr {
    void add(Product product);

    ArrayList<Product> list();

    Product searchById(int id);

    ArrayList<Product> searchByName(String name);

    ArrayList<TV> listOfTV();

    ArrayList<Refrigerator> listOfRefrigerator();

    ArrayList<TV> search50inchTV();

    ArrayList<Refrigerator> search400LRefrigerator();

    boolean changePrice(int id, int price);

    boolean delete(int id);

    int getAmountPrice();
}
