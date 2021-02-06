
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws Exception {
		int cycle;
		int tmp;
		int[] number = new int[8];
		Queue<Integer> queue = new LinkedList<>();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens;
		for (int t = 1; t <= 10; t++) {
			reader.readLine();
			tokens = reader.readLine().split(" ");
			// 
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				number[i] = Integer.parseInt(tokens[i]);
				min = Math.min(min, number[i]);
			}
//			System.out.println("min -> " + min);
			
			// 1 + 2 + 3 + 4 + 5 : 15
			// 입력된 값의 최소값을 찾아서 특정 사이클이 수행될때 같아지는 공통의 수중에서 최대값을 구한다.
			int v = min / 15 * 15;
			if (min == v) v -= 15;
//			System.out.println(v);
			
			queue.clear();
			
			// Queue에 값 대입하기
			for (int i = 0; i < 8; i++) {
				queue.add(number[i] - v);
			}
//			System.out.println(queue);
			
			// 사이클 돌리기
			cycle = 1;
			while (true) {
				tmp = queue.poll() - cycle;

				cycle++;
				if (cycle == 6)
					cycle = 1;
				
				if (tmp <= 0) {
					queue.offer(0);
					break;
				} 
				queue.offer(tmp);
			}

			System.out.print("#" + t + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}

}