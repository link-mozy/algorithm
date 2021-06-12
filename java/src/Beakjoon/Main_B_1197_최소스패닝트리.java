package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2021. 6. 12.
 * @see  https://www.acmicpc.net/problem/1197
 * @mem  50716
 * @time 576
 * @caution 
 * union-find 알고리즘
 */
public class Main_B_1197_최소스패닝트리 {
	
	static int parent [];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(str));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parent = new int [V + 1];
		for(int i = 1; i < V + 1; i++) parent[i] = i;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new Node(Integer.parseInt(st.nextToken()), 
							Integer.parseInt(st.nextToken()), 
							Integer.parseInt(st.nextToken())));
		}
		
		int min = 0;
		while(!pq.isEmpty()) {
			Node front = pq.poll();
			int number1 = front.left;
			int number2 = front.right;
			if(find(number1) == find(number2)) continue;
			union(number1, number2);
			min += front.cost;
		}
		
		System.out.println(min);
	}
	
	private static void union(int number1, int number2) {
		number1 = find(number1);
		number2 = find(number2);
		
		if(number1 != number2) parent[number1] = number2;
	}

	private static int find(int number) {
		if(parent[number] == number) return number;
		return parent[number] = find(parent[number]);
	}

	static class Node implements Comparable<Node>{
		int left;
		int right;
		int cost;
		
		public Node(int left, int right, int cost) {
			this.left = left;
			this.right = right;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			if(this.cost < o.cost) return -1;
			else if(this.cost > o.cost) return 1;
			return 0;
		}
	}
	
	static String str ="3 3\n"
			+ "1 2 1\n"
			+ "2 3 2\n"
			+ "1 3 3";
}
