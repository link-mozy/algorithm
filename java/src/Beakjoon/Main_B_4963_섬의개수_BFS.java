package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 12.
 *  @see https://www.acmicpc.net/problem/4963
 *  @mem  15420 
 *  @time 148
 *  @caution 
*/
public class Main_B_4963_섬의개수_BFS {

	static int R, C;
	static int map[][];
	static boolean visited[][];
	static int dir[][] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();

		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			// 종료 조건
			if(R + C == 0) break;
			
			map = new int [R][C];
			visited = new boolean [R][C];
			
			for(int row = 0; row < R; row++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int col = 0; col < C; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<Point> queue = new LinkedList<>();
			int cnt = 0;
			
			for(int row = 0; row < R; row++) {
				for(int col = 0; col < C; col++) {
					if(!visited[row][col] && map[row][col] == 1) {
						queue.add(new Point(row, col));
						visited[row][col] = true;
						
						while(!queue.isEmpty()) {
							Point front = queue.poll();
							
							for(int d = 0; d < 8; d++) {
								int nrow = front.row + dir[d][0];
								int ncol = front.col + dir[d][1];
								
								if(isin(nrow, ncol) && !visited[nrow][ncol] && map[nrow][ncol] == 1) {
									queue.add(new Point(nrow, ncol));
									visited[nrow][ncol] = true;
								}
							}
						}
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	
	private static boolean isin(int row, int col) {
		return 0 <= row && row < R && 0 <= col && col < C;
	}

	static class Point {
		int row;
		int col;
		
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	static String src = "1 1\n" + 
			"0\n" + 
			"2 2\n" + 
			"0 1\n" + 
			"1 0\n" + 
			"3 2\n" + 
			"1 1 1\n" + 
			"1 1 1\n" + 
			"5 4\n" + 
			"1 0 1 0 0\n" + 
			"1 0 0 0 0\n" + 
			"1 0 1 0 1\n" + 
			"1 0 0 1 0\n" + 
			"5 4\n" + 
			"1 1 1 0 1\n" + 
			"1 0 1 0 1\n" + 
			"1 0 1 0 1\n" + 
			"1 0 1 1 1\n" + 
			"5 5\n" + 
			"1 0 1 0 1\n" + 
			"0 0 0 0 0\n" + 
			"1 0 1 0 1\n" + 
			"0 0 0 0 0\n" + 
			"1 0 1 0 1\n" + 
			"0 0";
	
}
