package hw06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_D3_9229_한빈이와SpotMart {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> result = new ArrayList<>();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] snack = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                snack[j] = Integer.parseInt(st.nextToken());
            }

            int max = -1;
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = snack[j] + snack[k];
                    if (sum > max && sum <= M)
                        max = snack[j] + snack[k];
                }
            }

            result.add(max);
        }


        for (int i = 0; i < result.size(); i++) {
            System.out.println("#" + (i + 1) + " " + result.get(i));
        }
    }

}