package com.ssafy.hw02.step2;

import java.util.Scanner;

public class DigitTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = -1;
		int[] arr = new int[10];
		while(true) {
			n = sc.nextInt();
			if (n == 0) break;
			int result = n / 10;
			switch(result) {
			case 0: arr[0] += 1; break;
			case 1: arr[1] += 1; break;
			case 2: arr[2] += 1; break;
			case 3: arr[3] += 1; break;
			case 4: arr[4] += 1; break;
			case 5: arr[5] += 1; break;
			case 6: arr[6] += 1; break;
			case 7: arr[7] += 1; break;
			case 8: arr[8] += 1; break;
			case 9: arr[9] += 1; break;
			}	
		}
		for(int i = 0; i < 10; i++) {
			if(arr[i] > 0) {
				System.out.println(i + ":" + arr[i] + "개");
			}
		}
	}
}
