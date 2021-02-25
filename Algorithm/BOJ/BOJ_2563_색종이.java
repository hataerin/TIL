import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_2563_색종이 {
	
	public static void main(String[] args) {
		boolean[][] map = new boolean[100][100];
		
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int n = 0; n < N; n++) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			for(int i = w; i < w + 10; i++) {
				for(int j = h; j < h + 10; j++) {
					map[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				
				if(map[i][j] == true) {
					++cnt;
				}
			}
		}
		System.out.println(cnt);	
	}
	
}
