package com.ssafy.hw05.step3;

import java.util.Scanner;

public class ProductTest {
	
	public static void main(String[] args) {
		ProductMgr mgr = new ProductMgr();
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("메뉴 1.저장 2.저장된 상품 검색 3.상품 번호 검색 4.상품 삭제 5.특정가격 이하 상품 검색 6.종료");
			int menu = scanner.nextInt();
			switch (menu) {
			case 1:
				System.out.print("상품 번호를 입력하세요 : ");
				int id = scanner.nextInt();
				
				System.out.print("상품 이름을 입력하세요 : ");
				scanner.nextLine();
				String name = scanner.nextLine();
				
				System.out.print("상품 가격을 입력하세요 : ");
				int price = scanner.nextInt();
				
				System.out.print("상품 수량을 입력하세요 : ");
				int stock = scanner.nextInt();
				
				mgr.add(new Product(id, name, price, stock));
				break;
			case 2:
				Product[] list = mgr.list();
				for (int i = 0; i < list.length; i++) {
					if (list[i] == null)
						continue;
					System.out.println(list[i].toString());
				}
				break;
			case 3:
				System.out.print("상품 번호 : ");
				int num = scanner.nextInt();
				Product product = mgr.list(num);
				System.out.println(product.toString());
				break;
			case 4:
				System.out.print("상품 번호 : ");
				int num2 = scanner.nextInt();
				mgr.delete(num2);
				break;
			case 5:
				System.out.print("가격 입력 :");
				int price2 = scanner.nextInt();
				Product[] list3 = mgr.priceList(price2);
				for (int i = 0; i < list3.length; i++) {
					if (list3[i] == null)
						continue;
					System.out.println(list3[i].toString());
				}
				break;
			case 6:
				return;
			}
			
			System.out.println();
		}
		
	}
}
