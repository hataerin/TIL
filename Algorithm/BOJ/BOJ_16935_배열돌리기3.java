package hw08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer value = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(value.nextToken());
            }
        }

        StringTokenizer testCase = new StringTokenizer(br.readLine());

        for (int i = 0; i < R; i++) {
            int number = Integer.parseInt(testCase.nextToken());

            switch (number) {
                case 1:
                    arr = operation1(arr);
                    break;
                case 2:
                    arr = operation2(arr);
                    break;
                case 3:
                    arr = operation3(arr);
                    break;
                case 4:
                    arr = operation4(arr);
                    break;
                case 5:
                    arr = operation5(arr);
                    break;
                case 6:
                    arr = operation6(arr);
                    break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static int[][] operation1(int arr[][]) {
        int[][] tempArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length / 2; i++) {
            int[] temp = arr[i];
            tempArr[i] = arr[arr.length - i - 1];
            tempArr[arr.length - i - 1] = temp;
        }

        return tempArr;
    }

    public static int[][] operation2(int arr[][]) {
        int[][] tempArr = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length / 2; j++) {
                int temp = arr[i][j];
                tempArr[i][j] = arr[i][arr[i].length - j - 1];
                tempArr[i][arr[i].length - j - 1] = temp;
            }
        }

        return tempArr;
    }

    public static int[][] operation3(int arr[][]) {
        int[][] tempArr = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                tempArr[j][arr.length - i - 1] = arr[i][j];
            }
        }

        return tempArr;
    }

    public static int[][] operation4(int arr[][]) {
        int[][] tempArr = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                tempArr[j][i] = arr[i][arr[i].length - j - 1];
            }
        }

        return tempArr;
    }

    public static int[][] operation5(int arr[][]) {
        int[][] tempArr = arr.clone();

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr[i].length / 2; j++) {
                int temp = arr[i][j];
                tempArr[i][j] = arr[arr.length / 2 + i][j];
                tempArr[arr.length / 2 + i][j] = temp;
            }
        }

        for (int i = arr.length / 2; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length / 2; j++) {
                int temp = arr[i][j];
                tempArr[i][j] = arr[i][arr[i].length / 2 + j];
                tempArr[i][arr[i].length / 2 + j] = temp;
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = arr[i].length / 2; j < arr[i].length; j++) {
                int temp = arr[i][j];
                tempArr[i][j] = arr[arr.length / 2 + i][j];
                tempArr[arr.length / 2 + i][j] = temp;
            }
        }

        return tempArr;
    }

    public static int[][] operation6(int arr[][]) {
        int[][] tempArr = arr.clone();

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr[i].length / 2; j++) {
                int temp = arr[i][j];
                tempArr[i][j] = arr[i][arr[i].length / 2 + j];
                arr[i][arr[i].length / 2 + j] = temp;
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = arr[i].length / 2; j < arr[i].length; j++) {
                int temp = arr[i][j];
                tempArr[i][j] = arr[arr.length / 2 + i][j];
                tempArr[arr.length / 2 + i][j] = temp;
            }
        }

        for (int i = arr.length / 2; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length / 2; j++) {
                int temp = arr[i][j];
                tempArr[i][j] = arr[i][arr[i].length / 2 + j];
                tempArr[i][arr[i].length / 2 + j] = temp;
            }
        }

        return tempArr;
    }

}