package hw04;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int towerNum = Integer.parseInt(br.readLine());
		
		int[] tower = new int[towerNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < towerNum; i++) {
			int receive = 0;
			tower[i] = Integer.parseInt(st.nextToken());
			for (int j = i - 1; j >= 0; j--) {
				if (tower[j] >= tower[i]) {
					receive = j + 1;
					break;
				}
			}
			bf.write(receive + " ");
		}
		
		bf.flush();
		
		br.close();
		bf.close();
	}
}
