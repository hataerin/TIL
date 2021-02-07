package hw05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_1223_계산기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> calcResult = new ArrayList();
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            char[] input = br.readLine().toCharArray();
            Stack<Character> op = new Stack<>();
            List<Character> result = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                switch (input[j]) {
                    case '+':
                        while (!op.isEmpty()) {
                            result.add(op.pop());
                        }
                        op.push(input[j]);
                        break;
                    case '*':
                        while (!op.isEmpty() && op.peek() == '*') {
                            result.add(op.pop());
                        }
                        op.push(input[j]);
                        break;
                    default:
                        result.add(input[j]);
                }
            }

            while (!op.isEmpty())
                result.add(op.pop());

            Stack<Integer> result2 = new Stack<>();
            for (int j = 0; j < result.size(); j++) {
                switch (result.get(j)) {
                    case '+':
                        result2.push(result2.pop() + result2.pop());
                        break;
                    case '*':
                        result2.push(result2.pop() * result2.pop());
                        break;
                    default:
                        result2.push(Integer.parseInt(String.valueOf(result.get(j))));
                }
            }

            calcResult.add(result2.pop());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("#" + (i+1) + " " + calcResult.get(i));
        }
    }
}