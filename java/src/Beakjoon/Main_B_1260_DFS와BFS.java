package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_1260_DFS와BFS {
	
	/**
	 *  @author mozy
	 *  @since Oct 24, 2020
	 *  @see https://www.acmicpc.net/problem/1260 
	 *  @mem 19420
	 *  @time 208
	 *  @caution 
	 * 그래프를 만들어 탐색하여 푸는 문제.
	 * 그래프를 만들고 중간중간 담아주는 리스트가 필요!
	 * DFS에서는 lists, BFS에서는 childs
	 * 그리고 그래프를 정렬해줘야한다. 문제에서는 설명이 없는데, 입력 순서대로 탐색한 결과는 틀림...
	*/
	
	static int N, M, V;
	static List [] graph;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		V = Integer.parseInt(st.nextToken()); // 시작 지점
		
		graph = new List [N+1];
		for(int i = 1; i < N+1; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(in.readLine(), " ");
			int number1 = Integer.parseInt(st.nextToken());
			int number2 = Integer.parseInt(st.nextToken());
			
			graph[number1].add(number2);
			graph[number2].add(number1);
		}
		
		for(int i = 1; i < N+1; i++) {
			Collections.sort(graph[i]);
		}
		
//		// 입력 확인
//		for(int i = 1; i < N+1; i++) {
//			System.out.println(graph[i]);
//		}
		
		// DFS
		visited = new boolean [N+1];
		DFS(V);
		sb.append("\n");
		// BFS
		visited = new boolean [N+1];
		BFS();
		// 결과 출력
		System.out.println(sb);
	}
	
	static void DFS(int node) {
		if(!visited[node]) {
			visited[node] = true;
			sb.append(node + " ");
			
			List<Integer> lists = graph[node];
			for(int i = 0; i < lists.size(); i++) {
				Integer node_ = lists.get(i);
				if(!visited[node_]) {
					DFS(node_);
				}
			}
		}
	}
	
	static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			List<Integer> childs = graph[node];
			sb.append(node + " ");
			
			for(int i = 0; i < childs.size(); i++) {
				int child = childs.get(i);
				if(!visited[child]) {
					queue.add(child);
					visited[child] = true;
				}
			}
		}
		
	}
	
	static String src = "5 5 3\n" + 
			"5 4\n" + 
			"5 2\n" + 
			"1 2\n" + 
			"3 4\n" + 
			"3 1";
}
