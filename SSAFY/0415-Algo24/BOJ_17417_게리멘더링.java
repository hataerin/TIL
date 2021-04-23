import java.io.*;
import java.util.*;

public class Main {
	static int[] population;
	static boolean visited[];
	static ArrayList<Integer>[] adjList;
	static ArrayList<Integer> groupSum = new ArrayList<>();
	static int sum, n, min = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[n + 1];
		population = new int[n + 1];
		visited = new boolean[n + 1];
		int[] nArray = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int adjNum = Integer.parseInt(st.nextToken());
			adjList[i] = new ArrayList<Integer>();
			nArray[i-1] = i;
			
			for (int j = 0; j < adjNum; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 1; i <= n; i++) { // 처음에 연결 요소가 몇개로 나뉘는지 알아본다.
			if (!visited[i]) {
				groupSum.add(bfs(i,nArray));
			}
		}

		switch (groupSum.size()) {
			case 1:
				divideGroup();
				break;
			case 2:
				min = subPopulation(groupSum.get(0), groupSum.get(1));
				break;
			default:
				min = -1;
		}

		System.out.println(min);

	}

	static int subPopulation(int population1, int population2) {
		int sub = population1 - population2;
		return sub < 0 ? -sub : sub;
	}

	static void divideGroup() {
		sum = groupSum.get(0);
		int areaCount = adjList.length;
		int half = areaCount / 2;

		for (int i = 1; i <= half; i++) {
			combination(new int[n + 1], n + 1, i, 1, 1, i);
		}
	}

	public static void combination(int[] combArr, int n, int r, int index, int target, int rootR) {
		if (r == 0) { // 조합 완성
			int[] firstGroup = new int[rootR];
			boolean isConnectedGroup = true;
			System.arraycopy(combArr, 1, firstGroup, 0, rootR);
			int[] secondGroup = makeSecondGroup(firstGroup);

			resetVisit();
			int firstSum = bfs(firstGroup[0], firstGroup);
			if(!isConnected(firstGroup)) {
				return;
			}
			
			resetVisit();
			int secondSum = bfs(secondGroup[0], secondGroup);
			if(!isConnected(secondGroup)) {
				return;
			}
			
			int sub = subPopulation(firstSum, secondSum);
			if (sub < min) { // min update
				min = sub;
			}

		} else if (target == n) {
			return;
		} else {
			combArr[index] = target;
			combination(combArr, n, r - 1, index + 1, target + 1, rootR);
			combination(combArr, n, r, index, target + 1, rootR);
		}
	}

	public static boolean isConnected(int[] group) {
		for (int i = 0; i < group.length; i++) {
			if (!visited[group[i]]) {
				return false;
			}
		}
		return true;
	}

	public static void resetVisit() {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}
	
	public static int bfs(int v, int[] group) {
		boolean isFind;
		int adjV,sum=0;

		Queue q = new LinkedList<Integer>();
		q.add(v);

		while (!q.isEmpty()) {
			int index = (int) q.poll();
			sum += population[index];
			visited[index] = true;
			ArrayList<Integer> tmp = adjList[index];

			for (int i = 0; i < tmp.size(); i++) {
				isFind = false;
				adjV = tmp.get(i);
				for (int k = 0; k < group.length; k++) {
					if (adjV == group[k]) {
						isFind = true;
						break;
					}
				}
				if (isFind && !visited[adjV]) {
					q.add(adjV);
					visited[adjV] = true;
				}
			}
		}
		return sum;
	}

	public static int[] makeSecondGroup(int[] firstGroup) {
		int[] secondGroup = new int[n - firstGroup.length];
		int index = 0;
		boolean isFind;

		for (int i = 1; i <= n; i++) {
			isFind = false;
			for (int j = 0; j < firstGroup.length; j++) {
				if (firstGroup[j] == i) {
					isFind = true;
					break;
				}
			}
			if (!isFind) {
				secondGroup[index++] = i;
			}
		}
		return secondGroup;
	}

}