package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class SW_D3_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트케이스의 수
		int[] result = new int[T]; //테스트케이스의 답을 저장할 배열
		int cnt = 0;
		for(int i = 0; i < T; i++) {
			String input = br.readLine();			
			int temp = 0;
			for(int j = 0; j < input.length(); j++) {
				int value = Integer.parseInt(input.substring(j, j+1));
				if(value != temp) {
					++cnt;
					temp = value;
				}
			}
			result[i] = cnt;
			cnt = 0;
		}
		for(int i = 0; i < T; i++) {
			System.out.println("#" + (i + 1) + " " + result[i]);			
		}
		
	}
}
