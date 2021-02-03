package hw03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_D2_2001_파리퇴치 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        int[] deadFly = new int[testcase];

        for (int i = 0; i < testcase; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int[][] fly = new int[n][n];

            for (int j = 0; j < n; j++) {
                String[] f = br.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    fly[j][k] = Integer.parseInt(f[k]);
                }
            }

            int max = 0;
            int row = 0;
            int col = 0;
            while (true) {
                int dead = 0;
                for (int k = row; k < m + row; k++) {
                    for (int p = col; p < m + col; p++) {
                        dead += fly[k][p];
                    }
                }
                if (row <  n - m) {
                    row++;
                }
                else if (col <  n - m) {
                    col++;
                    row = 0;
                }
                else {
                    break;
                }

                if (dead > max) {
                    max = dead;
                }
            }

            System.out.println("#" + (i + 1) + " " + max);
        }

    }
}