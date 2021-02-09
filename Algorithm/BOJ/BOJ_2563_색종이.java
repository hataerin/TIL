package hw07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            
            for (int j = row; j < row + 10; j++) {
                for (int k = col; k < col + 10; k++) {
                    if (paper[j][k] == 1)
                        continue;
                    paper[j][k] = 1;
                }
            }
        }

        int size = 0;
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                if (paper[i][j] == 1)
                    size++;

        System.out.println(size);
    }

}