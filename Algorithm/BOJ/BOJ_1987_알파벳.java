package hw12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] alpha;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        alpha = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                alpha[i][j] = br.read();
            }
            br.read();
        }

        System.out.println(alphabet(0, 0, R, C, new ArrayList<>()));

        br.close();
    }

    public static int alphabet(int row, int col, int R, int C, List<Integer> ignore) {
        int value = alpha[row][col];

        int max = 0;

        ignore.add(value);

        if (col < C && alpha[row][col + 1] != value) {
            int count = alphabet(row, col + 1, R, C, ignore);
            if (count > max)
                max = count;
        }
        else if (row < R && alpha[row + 1][col] != value) {
            row++;
            int count = alphabet(row + 1, col, R, C, ignore);
            if (count > max)
                max = count;
        }
        else if (col > 0 && alpha[row][col - 1] != value) {
            col--;
            int count = alphabet(row, col - 1, R, C, ignore);
            if (count > max)
                max = count;
        }
        else if (row > 0 && alpha[row - 1][col] != value) {
            row--;
            int count = alphabet(row - 1, col, R, C, ignore);
            if (count > max)
                max = count;
        }

        return max;
    }
}