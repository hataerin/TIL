package com.ssafy.ws03.step3;
import java.util.Random;

/**
 * 도서 객체를 생성하고 정보를 출력하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		/*
		int[] a = {1};
		System.out.println(a);  // [I @ 65ae6ba4
		
		String s = "hello";
		System.out.println(s);   // toString 메서드 재정의
		
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		System.out.println(list);  // [a, b]
		
		Random r = new Random();
		System.out.println(r);  // java.util.Random@7960847b
		
		Date d = new Date();
		System.out.println(d);  // Fri Jan 22 10:22:27 KST 2021
		*/
		
//		int v = Integer.parseInt("100");
		
		/*
		package java.lang;
		public class Integer {
			public static int parseInt(String val) {
				return ...;
			}
		}
		 */
		
		// 도서 정보를 저장하는 객체를 생성한다.
		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		Book b3 = new Book();
		b3.isbn = "35356";
		b3.title = "자바과제풀이";
		b3.author = "35356";
		b3.publisher = "35356";
		b3.price = 12345;
		b3.desc = "35356";
		
		System.out.println("**********************도서목록**********************");
		System.out.println(b1.toString()); // 생성한 도서 정보를 조회하여 출력한다.
		System.out.println(b2);
		System.out.println(b3);
		
		String msg = "Book(b2) : " + b2;
		System.out.println(msg);
	}
}
