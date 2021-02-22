package com.ssafy.hw01.step1;

import java.util.Scanner;

public class Compute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		System.out.println("곱=" + n1 * n2);
		System.out.println("몫=" + n1 / n2);
	}
}
