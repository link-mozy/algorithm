package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 10.
 *  @see https://www.acmicpc.net/problem/3055
 *  @mem  11864 
 *  @time 80
 *  @caution
 *  정올 화염에서탈출문제와 완전 똑 같은 문제.
 *  BFS를 활용하며, 조건에 맞게 queue에 넣어주면 되는 문제.
 *  중요 포인트는 저주(화염)이 먼저 큐에 넣고 나중에 사람을 넣어줘야한다. 
*/
public class Main_B_3055_탈출 {

	static int R, C;
	static char map[][];
	static boolean visited[][];
	
	static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		visited = new boolean [R][C];

		Queue<Point> queue = new LinkedList<>(); 
		int srow = 0;
		int scol = 0;
		int drow = 0;
		int dcol = 0;
		
		for(int row = 0; row < R; row++) {
			map[row] = in.readLine().toCharArray();
			for(int col = 0; col < C; col++) {
				if(map[row][col] == 'S') {
					srow = row;
					scol = col;
					visited[row][col] = true;
				} else if(map[row][col] == 'D') {
					drow = row;
					dcol = col;
				} else if(map[row][col] == '*') {
					queue.add(new Point(row, col, 1, 0));
				}
			}
		}
		
		queue.add(new Point(srow, scol, 0, 0));
		int result = dfs(queue, drow, dcol);

		System.out.println((result != -1)? result : "KAKTUS");
	}
	
	private static int dfs(Queue<Point> queue, int drow, int dcol) {
		int row;
		int col;
		int type;
		int dist;
		
		while(!queue.isEmpty()) {
			Point front = queue.poll();
			row = front.row;
			col = front.col;
			type = front.type;
			dist = front.dist;
			
			for(int d = 0; d < 4; d++) {
				int nrow = row + dir[d][0];
				int ncol = col + dir[d][1];
				
				if(!isin(nrow, ncol) || map[nrow][ncol] == 'X' || map[nrow][ncol] == '*')
					continue;
				if(nrow == drow && ncol == dcol) {
					if(type == 0) {
						return dist + 1;
					} else {
						continue;
					}
				} else if(type == 0 && !visited[nrow][ncol]) {
					queue.add(new Point(nrow, ncol, 0, dist + 1));
					visited[nrow][ncol] = true;
				} else if(type == 1) {
					queue.add(new Point(nrow, ncol, 1, 0));
					map[nrow][ncol] = '*'; 
				}
			}
		}
		
		return -1;
	}

	private static boolean isin(int row, int col) {
		return 0 <= row && row < R && 0 <= col && col < C;
	}

	static class Point {
		int row;
		int col;
		int type;
		int dist;
		
		public Point(int row, int col, int type, int dist) {
			super();
			this.row = row;
			this.col = col;
			this.type = type;
			this.dist = dist;
		}
	}
	
	static String src = "3 3\n" + 
			"D.*\n" + 
			"...\n" + 
			"..S";
}
