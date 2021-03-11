/*
 C x R 만큼만 true로 바꾸기
 진행중인 방향이 true라면 false로 바꾸고 계속 간다
 진행중인 방향이 false라면 방향을 바꾼다.
 count를 세면서 입력받은 숫자의 좌표를 출력
 */

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10157_자리배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); //가로
		int R = sc.nextInt(); //세로
		
		boolean[][] arr = new boolean[R+2][C+2];
		
		for (int r = 1; r <= R; r++) { // R*C 부분만 true로 바꿔주기
			for (int c = 1; c <= C; c++) {
				arr[r][c] = true;
			}
		}
		
//		for (int r = 0; r < R+2; r++) { // true로 잘 바뀌었는지 확인
//			for (int c = 0; c < C+2; c++) {
//				System.out.printf("%7s", arr[r][c]);
//			}
//			System.out.println();
//		}
			
		int r = 1;
		int c = 1;
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0}; // 아래, 오, 위, 왼
		int k = 0;
		int dir = 0; // 시계방향으로 계속 반복하도록
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
				
			if(!arr[c + dc[dir]][r + dr[dir]]) { //현재 위치가 거짓이면 방향을 바꾸기
				k++;
				dir = k % 4;
			}
			r += dr[dir];
			c += dc[dir];															
		}
		System.out.println((r-dr[dir]) + ", " + (c-dc[dir]));				
	
	}
}
