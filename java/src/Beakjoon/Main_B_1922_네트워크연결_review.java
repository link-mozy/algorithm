package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 3. 6.
 *  @see  https://www.acmicpc.net/problem/1922
 *  @mem  46128
 *  @time 480
 *  @caution 
 *  union-find 알고리즘 문제.
 *  우선순위 큐를 사용하여 비용 기준으로 정렬
 *  정렬뒤 연결되어있는지 확인해가며 서로 처음에는 연결되어있지 않는다면 비용을 더해주고 연결
 *  union-find 알고리즘도 사용하고 구현도 해야한느 문제라 좋은 문제로 생각된다.
*/
public class Main_B_1922_네트워크연결_review {

	static int parent[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		PriorityQueue<Computer> pq = new PriorityQueue<>();
		StringTokenizer st;
		
		parent = new int [N + 1];
		// make set
		for(int i = 1; i <= N; i++) parent[i] = i;
		
		// queue에 담기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			pq.add(new Computer(Integer.parseInt(st.nextToken())
							, Integer.parseInt(st.nextToken())
							, Integer.parseInt(st.nextToken())));
		}
		
		// queue에서 빼기
		int min = 0;
		while(!pq.isEmpty()) {
			Computer front = pq.poll();
			
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
		
		if(number1 != number2) parent[number1] = number2; // 연결만 되어있으면 됨.
	}

	private static int find(int number) {
		if(number == parent[number]) return number;
		else return parent[number] = find(parent[number]);
	}

	static class Computer implements Comparable<Computer>{
		int left;
		int right;
		int cost;
		
		public Computer(int left, int right, int cost) {
			this.left = left;
			this.right = right;
			this.cost = cost;
		}

		@Override
		public int compareTo(Computer o) {
			if(this.cost < o.cost) return -1;
			else if(this.cost > o.cost) return 1;
			else return 0;
		}
	}
	
	static String src = "6\n" + 
			"9\n" + 
			"1 2 5\n" + 
			"1 3 4\n" + 
			"2 3 2\n" + 
			"2 4 7\n" + 
			"3 4 6\n" + 
			"3 5 11\n" + 
			"4 5 3\n" + 
			"4 6 8\n" + 
			"5 6 8";
}
