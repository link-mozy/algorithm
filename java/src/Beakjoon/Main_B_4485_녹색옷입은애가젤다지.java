package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B_4485_녹색옷입은애가젤다지 {
	
	static int N;
	static int [][] map;
	static boolean [][] visited;
	static int min;
	static int [][] dir = {{0, 1}, {1, 0}};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		in = new BufferedReader(new StringReader(src));
		StringBuffer sb = new StringBuffer();
		
		int round = 1;
		while(true) {
			N = Integer.parseInt(in.readLine());
			if(N == 0) break;
			map = new int [N][N];
			visited = new boolean [N][N];
			min = Integer.MAX_VALUE;
			
			// input
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int column = 0; column < N; column++) {
					map[row][column] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 루피 구하기
			bfs();
			
			// 결과 값 저장
			sb.append("Problem ").append(round++).append(": ").append(min).append("\n");
		} // while
		System.out.println(sb);
	}
	
	static class Point implements Comparable<Point> {
		int row;
		int column;
		int value;
		
		@Override
		public int compareTo(Point o) {
			if(this.value < o.value) return 1;
			else return -1;
		}
	}

	private static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		
	}
	

	static String src = "";
}
