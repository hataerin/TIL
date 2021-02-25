import java.util.Arrays;
import java.util.Scanner;

public class 기지국 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int count = 0;
			// 테케별로 map 입력받기
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				char[] c = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = c[j];
				}
			}

			int k = 1;
			int[] dx = { 0, 0, -k, k };
			int[] dy = { k, -k, 0, 0 };
			// 기지국 찾아서 좌표찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (map[i][j] == 'H' || map[i][j] == 'X')
						continue;

					for (int c = 1; c <= map[i][j] - 'A' + 1; c++) {
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d] * c;
							int ny = j + dy[d] * c;

							if (nx < 0 || ny < 0 || nx >= N || ny >= N)
								continue;
							if (map[nx][ny] == 'H') {
								map[nx][ny] = 'X';
							}
						}

					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H')
						++count;
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}
}
