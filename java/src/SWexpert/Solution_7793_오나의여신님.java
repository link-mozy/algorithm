package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 9.
 *  @see  https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWsBQpPqMNMDFARG
 *  @mem  19340
 *  @time 123
 *  @caution 
 *  정올 화염에서탈출문제와 완전 똑 같은 문제.
 *  BFS를 활용하며, 조건에 맞게 queue에 넣어주면 되는 문제.
 *  중요 포인트는 저주(화염)이 먼저 큐에 넣고 나중에 사람을 넣어줘야한다.
*/
public class Solution_7793_오나의여신님 {

	static int N, M, min;
	static char map[][];
	static boolean visited[][];

	static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			min = -1;
			int srow = 0;
			int scol = 0;
			int drow = 0;
			int dcol = 0;
			
			map = new char [N][M];
			visited = new boolean [N][M];
			Queue<Point> queue = new LinkedList<>();
			
			for(int row = 0; row < N; row++) {
				map[row] = in.readLine().toCharArray();
				for(int col = 0; col < M; col++) {
					if(map[row][col] == 'S') {
						srow = row;
						scol = col;
						visited[row][col] = true;
						map[row][col] = '.';
					} else if(map[row][col] == 'D') {
						drow = row;
						dcol = col;
					} else if(map[row][col] == '*') {
						queue.add(new Point(row, col, 1, 0));
					}
				}
			} // map input loop
			
			queue.add(new Point(srow, scol, 0, 0));
			dfs(queue, drow, dcol);
			
			if(min == -1) {
				sb.append("#" + tc + " GAME OVER").append("\n");
			} else {
				sb.append("#" + tc + " " + min).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void dfs(Queue<Point> queue, int drow, int dcol) {
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
			
			// print(front);

			for(int d = 0; d < 4; d++) {
				int nrow = row + dir[d][0];
				int ncol = col + dir[d][1];
				
				if(!isin(nrow, ncol) || map[nrow][ncol] == '*' || map[nrow][ncol] == 'X')
					continue;
				if(drow == nrow && dcol == ncol) {
					if(type == 0) {
						min = dist + 1;
						return;
					} else continue;
				} else if(type == 0 && !visited[nrow][ncol]) {
					queue.add(new Point(nrow, ncol, 0, dist + 1));
					visited[nrow][ncol] = true;
				} else if(type == 1) {
					queue.add(new Point(nrow, ncol, 1, 0));
					map[nrow][ncol] = '*';
				}
			}
		}
		return;
	}
	

	private static void print(Point front) {
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				System.out.print(map[row][col]);
			} System.out.println();
		} System.out.println(front);
		System.out.println();
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
			super();
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
	
	static String src = "2\n" + 
			"5 3\n" + 
			"D*S\n" + 
			".X.\n" + 
			".X.\n" + 
			".X.\n" + 
			"...\n" + 
			"5 3\n" + 
			"D*S\n" + 
			"...\n" + 
			".X.\n" + 
			".X.\n" + 
			"...";
}
