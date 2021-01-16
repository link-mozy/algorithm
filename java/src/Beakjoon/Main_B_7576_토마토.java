package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 16.
 *  @see https://www.acmicpc.net/problem/7576
 *  @mem  120476
 *  @time 560
 *  @caution BFS문제
 *  visited을 사용하며, map배열에 day를 증가하면서 하루하루 얼마나 증가했는지를 표시하여 문제를 풀었다.
*/
public class Main_B_7576_토마토 {

	static int N, M;
	static int map[][];
	static boolean visited[][];
	
	static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		visited = new boolean [N][M];
		
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				if(map[row][col] == 1) {
					queue.add(new Point(row, col, 1));
					visited[row][col] = true;
				}
			}
		}
		
		bfs(queue);
		
		int result = check();
		System.out.println(result);
	}
	

	private static int check() {
		int max = -1;
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col ++) {
				if(map[row][col] == 0) return -1;
				if(map[row][col] > max) max = map[row][col];
			}
		}
		return max - 1;
	}


	private static void bfs(Queue<Point> queue) {
		int day;
		
		while(!queue.isEmpty()) {
			Point front = queue.poll();
			day = front.day;
			
			for(int d = 0; d < 4; d++) {
				int nrow = front.row + dir[d][0];
				int ncol = front.col + dir[d][1];
				
				if(!isin(nrow, ncol) || visited[nrow][ncol] || map[nrow][ncol] == -1)
					continue;
				if(map[nrow][ncol] == 0) {
					queue.add(new Point(nrow, ncol, day + 1));
					map[nrow][ncol] = day + 1;
					visited[nrow][ncol] = true;
				}
			}
		}
	}


	private static boolean isin(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < M;
	}


	static class Point {
		int row;
		int col;
		int day;
		
		public Point(int row, int col, int day) {
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}
	
	static String src = "6 4\n" + 
			"0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0\n" + 
			"0 0 0 0 0 1";
}
