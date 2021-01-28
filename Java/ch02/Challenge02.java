package com.java.ch02;

import java.util.Scanner;

public class Challenge02 {
	public static void main(String[] args) {
		int num;
		int answer;
		String print;
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		num = sc.nextInt();
		answer = num % 2;
		print = (answer == 0) ? "짝수" : "홀수";
		System.out.println(print);
		
	}
}
