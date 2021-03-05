package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 3. 2.
 *  @see  https://www.acmicpc.net/problem/1922
 *  @mem  45908
 *  @time 468
 *  @caution
 *  쿠르스칼 알고리즘.
 *  사실 쿠르스칼 알고리즘을 잘모르지만, union-find 와 priorityQueue 를 사용하여,
 *  최단 거리의 처음 간선들을 더하고 union으로 연결되면 결국 자신을 가리키니깐 if(start == end)에서
 *  continue로 생략하는 컨셉이 멋진 문제이다. 혼자서는 못풀었을 것같다... 
*/
public class Main_B_1922_네트워크 {
	
	static int numberArr [];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		numberArr = new int [N + 1];
		for(int i = 1; i <= N; i++) numberArr[i] = i;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			pq.add(new Edge(Integer.parseInt(st.nextToken())
						, Integer.parseInt(st.nextToken())
						, Integer.parseInt(st.nextToken())));
		}
		
		int min = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			int number1 = find(edge.number1);
			int number2 = find(edge.number2);
			
			if(number1 == number2) continue;
			
			union(number1, number2);
			
			min += edge.cost;
		}
		
		System.out.println(min);
	}
	
	private static void union(int number1, int number2) {
		number1 = find(number1);
		number2 = find(number2);
		
		if(number1 != number2) numberArr[number1] = number2;
	}

	private static int find(int number) {
		if(number == numberArr[number]) return number;
		else return numberArr[number] = find(numberArr[number]);
	}

	static class Edge implements Comparable<Edge>{
		int number1;
		int number2;
		int cost;
		
		public Edge(int number1, int number2, int cost) {
			super();
			this.number1 = number1;
			this.number2 = number2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
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
