package com.ssafy.hw07.step3;

import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {
    ArrayList<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public ArrayList<Product> list() {
        return products;
    }

    @Override
    public Product searchById(int id) {
        for (Product p : products) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    @Override
    public ArrayList<Product> searchByName(String name) {
        ArrayList<Product> temp = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().contains(name))
                temp.add(p);
        }
        return temp;
    }

    @Override
    public ArrayList<TV> listOfTV() {
        ArrayList<TV> temp = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof TV)
                temp.add((TV) p);
        }
        return temp;
    }

    @Override
    public ArrayList<Refrigerator> listOfRefrigerator() {
        ArrayList<Refrigerator> temp = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Refrigerator)
                temp.add((Refrigerator) p);
        }
        return temp;
    }

    @Override
    public ArrayList<TV> search50inchTV() {
        ArrayList<TV> temp = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof TV && ((TV) p).getInch() >= 50)
                temp.add((TV) p);
        }
        return temp;
    }

    @Override
    public ArrayList<Refrigerator> search400LRefrigerator() {
        ArrayList<Refrigerator> temp = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Refrigerator && ((Refrigerator) p).getLiter() >= 400)
                temp.add((Refrigerator) p);
        }
        return temp;
    }

    @Override
    public boolean changePrice(int id, int price) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setPrice(price);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (Product p : products) {
            if (p.getId() == id)
                return products.remove(p);
        }
        return false;
    }

    @Override
    public int getAmountPrice() {
        int amount = 0;
        for (Product p : products) {
            amount += p.getPrice();
        }
        return amount;
    }
}
