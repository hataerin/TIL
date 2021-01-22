package com.ssafy.ws04.step3;

/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {

	public static void main(String[] args) {
		
		// 도서 리스트를 유지하고 관리하는 BookManager 객체를 생성한다.
		// The constructor BookManager() is not visible
//		BookManager bookManager = new BookManager();
		BookManager bookManager = BookManager.getInstance();
		
		// BookManager 객체를 이용해  도서정보를 추가한다.
		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		bookManager.add(b1);
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bookManager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));

		// BookManager 객체를 이용해  도서리스트를 조회한다.
		System.out.println("**********************도서목록**********************");
		for (Book book : bookManager.getList()) {
			System.out.println(book);
		}
		// BookManager 객체를 이용해  고유번호로 도서를 조회한다.
		System.out.println("**********************도서조회:21424**********************");
		Book b = bookManager.searchByIsbn("21424");
		System.out.println(b == null ? "도서를 찾지 못했습니다." : b);
		// BookManager 객체를 이용해  고유번호로 도서를 삭제한다.
		System.out.println("**********************도서삭제:21424**********************");
		String isbn = "21420";
		String msg = "도서가 존재하지 않습니다.";
		if (bookManager.remove(isbn)) {
			msg = "도서가 삭제되었습니다.";
		} 
		System.out.println(isbn + msg);			
		
		// BookManager 객체를 이용해  도서리스트를 조회한다.
		System.out.println("**********************도서목록**********************");
		for (Book book : bookManager.getList()) {
			System.out.println(book);
		}			
	}
}
