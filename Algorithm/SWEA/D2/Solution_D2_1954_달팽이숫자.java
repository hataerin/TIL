package hw02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1954_달팽이숫자 {
	private final static int DIRECTION_UP = 0;
	private final static int DIRECTION_DOWN = 1;
	private final static int DIRECTION_LEFT = 2;
	private final static int DIRECTION_RIGHT = 3;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int testcase = Integer.parseInt(br.readLine());
		int[] snailSize = new int[testcase];

		for (int i = 0; i < testcase; i++) {
			snailSize[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < testcase; i++) {
			System.out.println("#" + (i + 1));

			int size = snailSize[i];
			int[][] snail = new int[size][size];

			int row = 0;
			int col = 0;
			int direction = DIRECTION_RIGHT;
			int count = 1;

			while (true) {
				snail[row][col] = count++;
				if (count == size * size + 1)
					break;
				switch (direction) {
				case DIRECTION_UP:
					row--;
					if (row == col + 1) {
						direction = DIRECTION_RIGHT;
					}
					break;
				case DIRECTION_DOWN:
					row++;
					if (row % col == 0) {
						direction = DIRECTION_LEFT;
					}
					break;
				case DIRECTION_LEFT:
					col--;
					if (col == size - row - 1) {
						direction = DIRECTION_UP;
					}
					break;
				case DIRECTION_RIGHT:
					col++;
					if (col % (size - row - 1) == 0) {
						direction = DIRECTION_DOWN;
					}
					break;
				}
			}

			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					System.out.print(snail[j][k] + " ");
				}
				System.out.println();
			}
		}

		br.close();
	}

}
