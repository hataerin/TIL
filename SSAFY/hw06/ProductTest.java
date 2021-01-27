package com.ssafy.hw06.step3;

public class ProductTest {

    public static void main(String[] args) {
        TV tv = new TV(
                0,
                "SAMSUNG QLED 8K 214 cm Infinity Screen",
                17300000,
                100,
                85,
                "QLED"
        );

        Refrigerator refrigerator = new Refrigerator(
                1,
                "삼성전자 비스포크",
                1713140,
                200,
                697
        );

        TV tv2 = new TV(
                2,
                "테스트 TV",
                133333,
                100,
                85,
                "QLED"
        );

        Refrigerator refrigerator2 = new Refrigerator(
                3,
                "테스트 냉장고",
                2222222,
                200,
                697
        );

        ProductMgr productMgr = new ProductMgr();

        productMgr.add(tv);
        productMgr.add(refrigerator);
        productMgr.add(tv2);
        productMgr.add(refrigerator2);

        System.out.println("상품정보 전체");
        for (Product p : productMgr.list()) {
            System.out.println(p);
        }

        System.out.println("\n상품번호 검색");
        System.out.println(productMgr.searchById(0));

        System.out.println("\n상품명 검색");
        System.out.println(productMgr.searchByName("테스트"));

        System.out.println("\nTV 검색");
        for (Product p : productMgr.listOfTV()) {
            System.out.println(p);
        }

        System.out.println("\n냉장고 검색");
        for (Product p : productMgr.listOfRefrigerator()) {
            System.out.println(p);
        }

        System.out.println("\n상품 삭제");
        System.out.println(productMgr.delete(2) ? "상품 삭제 성공" : "상품 삭제 실패");
        for (Product p : productMgr.list()) {
            System.out.println(p);
        }

        System.out.println("\n전체 재고 상품 금액");
        System.out.println(productMgr.getAmountPrice());
    }
}
