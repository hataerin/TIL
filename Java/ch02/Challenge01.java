package com.java.ch02;

import java.util.Scanner;

public class Challenge01 {
	public static void main(String[] args) {
		double w, h, area;
		Scanner sc = new Scanner(System.in);
		System.out.println("직사각형의 가로 길이를 입력하세요 : ");
		w = sc.nextDouble();
		System.out.println("직사각형의 세로 길이를 입력하세요 : ");
		h = sc.nextDouble();
		
		System.out.printf("직사각형의 넓이는 %.1f입니다", w * h);
	}
}
