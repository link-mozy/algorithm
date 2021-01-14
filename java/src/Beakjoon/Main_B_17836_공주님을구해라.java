package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 14.
 *  @see  https://www.acmicpc.net/problem/17836
 *  @mem  15352
 *  @time 140
 *  @caution 
 *  visited를 3차 배열로 만들어 칼을 갖고있는 경우, 칼이 없는 경우 두가를 방문하도록 한다.
 *  그렇게 하면 자연적으로 칼이 없는 경우가 먼저 도달한다. (벽을 무시하기 때문...)
*/
public class Main_B_17836_공주님을구해라 {

	static int N, M, max;
	static int map[][];
	static int dir[][] = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = bfs();
		System.out.println((min == 10001)? "Fail" : min);
	}
	
	private static int bfs() {
		boolean visited [][][] = new boolean [N][M][2];
		Queue<Point> queue = new LinkedList<>();
		int row;
		int col;
		int type;
		int dist;
		
		queue.add(new Point(0, 0, 0, 0));
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		
		while(!queue.isEmpty()) {
			Point front = queue.poll();
			row = front.row;
			col = front.col;
			type = front.type;
			dist = front.dist;
			
			if(dist > max) continue;
			for(int d = 0; d < 4; d++) {
				int nrow = row + dir[d][0];
				int ncol = col + dir[d][1];
				
				if(nrow == N - 1 && ncol == M - 1) return dist + 1;
				if(!isin(nrow, ncol) || visited[nrow][ncol][type]) continue;
				// 칼이 없는 경우
				if(type == 0) {
					if(map[nrow][ncol] == 1) continue;
					visited[nrow][ncol][type] = true;
					if(map[nrow][ncol] == 2) {
						queue.add(new Point(nrow, ncol, 1, dist + 1));
						visited[nrow][ncol][1] = true;
					}
					else {
						queue.add(new Point(nrow, ncol, 0, dist + 1));
					}
						
				}
				// 칼이 있는 경우
				else {
					queue.add(new Point(nrow, ncol, type, dist + 1));
					visited[nrow][ncol][type] = true;
				}
			}
		}
		
		return 10001;
	}

	private static boolean isin(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < M;
	}
	
	static class Point {
		int row;
		int col;
		int type;
		int dist;
		
		public Point(int row, int col, int type, int dist) {
			this.row = row;
			this.col = col;
			this.type = type;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "P[r:" + row + ", c:" + col + ", t:" + type + ", d:" + dist + "]";
		}
	}

	static String src = "3 4 100\n" + 
			"0 0 0 0\n" + 
			"1 1 1 1\n" + 
			"0 0 2 0";
}
