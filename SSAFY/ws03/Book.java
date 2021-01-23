package com.ssafy.ws03.step3;
/**
 * 도서 정보를 나타내는 클래스
 */
public class Book {
	/** 고유 번호 */
	String isbn;		
	/**	제목 */
	String title;		
	/** 저자 */
	String author;		
	/** 출판사 */
	String publisher;	
	/** 가격 */
	int price;			
	/**	설명 */
	String desc;		

	/** 기본 생성자 */
	public Book() {
	}

	/** 도서 정보를 모두 받아 생성하는 생성자 */
	public Book(String isbn, String title, String author, String publisher, int price, String desc){
		// 받은 정보로 객체의 상태를 초기화한다.
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	/** 도서의 정보를 문자열로 반환하는 메소드 */
	public String toString() {
		return isbn + "\t| " + title + "\t| " + author + '\t' + "| " + publisher + '\t'
				+ "| " + price + '\t' + "| " + desc + '\t';
	}
}

