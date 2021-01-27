package com.ssafy.hw06.step3;

import java.util.Arrays;

public class ProductMgr {
    private static final int MAX_SIZE = 100;

    private Product products[] = new Product[MAX_SIZE];
    private int index = 0;

    public void add(Product product) {
        products[index++] = product;
    }

    public Product[] list() {
        return Arrays.copyOf(products, index);
    }

    public Product searchById(int id) {
        for (int i = 0; i < index; i++) {
            if (products[i].getId() == id)
                return products[i];
        }
        return null;
    }

    public Product searchByName(String name) {
        for (int i = 0; i < index; i++) {
            if (products[i].getName().contains(name))
                return products[i];
        }
        return null;
    }

    public TV[] listOfTV() {
        TV temp[] = new TV[index];
        int tempIndex = 0;

        for (int i = 0; i < index; i++) {
            if (products[i] instanceof TV)
                temp[tempIndex++] = (TV) products[i];
        }

        return Arrays.copyOf(temp, tempIndex);
    }

    public Refrigerator[] listOfRefrigerator() {
        Refrigerator temp[] = new Refrigerator[index];
        int tempIndex = 0;

        for (int i = 0; i < index; i++) {
            if (products[i] instanceof Refrigerator)
                temp[tempIndex++] = (Refrigerator) products[i];
        }

        return Arrays.copyOf(temp, tempIndex);
    }

    public boolean delete(int id) {
        for (int i = 0; i < index; i++) {
            if (products[i].getId() == id) {
                int moveCnt = index - i -1;
                // 뒤쪽의 데이터를 삭제할 인덱스자리로 한칸씩 이동
                if (moveCnt != 0) {
                    System.arraycopy(products, i + 1, products, i, moveCnt);
                }
                products[--index] = null;
                return true;
            }
        }
        return false;
    }

    public int getAmountPrice() {
        int amount = 0;
        for (int i = 0; i < index; i++)
            amount += products[i].getPrice();

        return amount;
    }
}
