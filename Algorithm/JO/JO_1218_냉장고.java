package hw10;
import java.io.*;
import java.util.*;


// 너무 어려워요ㅠㅠㅠㅠ 다 못풀었습니다아

public class JO_1218_냉장고 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int minNum = Integer.parseInt(st.nextToken());
            int maxNum = Integer.parseInt(st.nextToken());

            if (min.isEmpty()) {
                min.add(minNum);
                max.add(maxNum);
            }
            else {
                boolean isFlag = false;
                for (int j = 0; j < min.size(); j++) {
                    if (min.get(j) <= minNum && minNum <= max.get(j) || min.get(j) <= maxNum && maxNum <= max.get(j)) {
                        if (min.get(j) < minNum)
                            min.set(j, minNum);
                        else if (max.get(j) > maxNum)
                            max.set(j, maxNum);
                        isFlag = true;
                        break;
                    }
                }

                if (!isFlag) {
                    min.add(minNum);
                    max.add(maxNum);
                }
            }
        }

        System.out.println(min.size());

        bf.flush();

        br.close();
        bf.close();
    }
}