package hw11;

import java.io.*;

public class BOJ_1992_쿼드트리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        quadTree(0, N, 0, N);

        bf.flush();

        br.close();
        bf.close();
    }

    public static void quadTree(int rowStart, int rowEnd, int colStart, int colEnd) throws IOException {
        boolean isEqual = isEqual(rowStart, rowEnd, colStart, colEnd);

        if (isEqual) {
            bf.write(arr[rowStart][colStart] + "");
            return;
        }
        else {
            bf.write("(");
        }

        quadTree(rowStart, (rowStart + rowEnd) / 2, colStart, (colStart + colEnd) / 2);
        quadTree(rowStart, (rowStart + rowEnd) / 2, (colStart + colEnd) / 2, colEnd);
        quadTree((rowStart + rowEnd) / 2, rowEnd, colStart, (colStart + colEnd) / 2);
        quadTree((rowStart + rowEnd) / 2, rowEnd, (colStart + colEnd) / 2, colEnd);

        bf.write(")");
    }

    public static boolean isEqual(int rowStart, int rowEnd, int colStart, int colEnd) {
        int temp = arr[rowStart][colStart];
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (temp != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}