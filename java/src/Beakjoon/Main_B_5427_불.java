package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 11.
 *  @see https://www.acmicpc.net/problem/5427
 *  @mem  133140 
 *  @time 608
 *  @caution 
 *  백준 4179 문제와 동일.
 *  큐에서 사람일때, 주위에 가장자리(탈출 조건)인지 확인하고
 *  아니라면, 4방 탐색 DFS를 실행.
*/
public class Main_B_5427_불 {

	static int R, C;
	static char map[][];
	static boolean visited[][];
	static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));

		int TC = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new char [R][C];
			visited = new boolean [R][C];
			
			Queue<Point> queue = new LinkedList<>();
			int srow = 0;
			int scol = 0;

			for(int row = 0; row < R; row++) {
				map[row] = in.readLine().toCharArray();
				for(int col = 0; col < C; col++) {
					if(map[row][col] == '@') {
						srow = row;
						scol = col;
						map[row][col] = '.';
						visited[row][col] = true;
					} else if(map[row][col] == '*') {
						queue.add(new Point(row, col, 1, 0));
					}
				}
			}
			
			queue.add(new Point(srow, scol, 0, 0));
			int min = dfs(queue);
			System.out.println((min != -1)? min : "IMPOSSIBLE");
			
		} // test case loop
	}
	
	private static int dfs(Queue<Point> queue) {
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
			
			// check
			if(type == 0 && check(row, col)) {
				return dist + 1;
			}
			// dfs run
			for(int d = 0; d < 4; d++) {
				int nrow = row + dir[d][0];
				int ncol = col + dir[d][1];
				
				if(!isin(nrow, ncol) || map[nrow][ncol] == '#' || map[nrow][ncol] == '*') {
					continue;
				}
				if(type == 0 && !visited[nrow][ncol]) {
					queue.add(new Point(nrow, ncol, 0, dist+ 1));
					visited[nrow][ncol] = true;
				} else if(type == 1) {
					map[nrow][ncol] = '*';
					queue.add(new Point(nrow, ncol, 1, 0));
				}
			}
		}
		return -1;
	}

	private static boolean check(int row, int col) {
		for(int d = 0; d < 4; d++) {
			if(!isin(row + dir[d][0], col + dir[d][1])) {
				return true;
			}
		}
		return false;
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
	
	static String src = "5\n" + 
			"4 3\n" + 
			"####\n" + 
			"#*@.\n" + 
			"####\n" + 
			"7 6\n" + 
			"###.###\n" + 
			"#*#.#*#\n" + 
			"#.....#\n" + 
			"#.....#\n" + 
			"#..@..#\n" + 
			"#######\n" + 
			"7 4\n" + 
			"###.###\n" + 
			"#....*#\n" + 
			"#@....#\n" + 
			".######\n" + 
			"5 5\n" + 
			".....\n" + 
			".***.\n" + 
			".*@*.\n" + 
			".***.\n" + 
			".....\n" + 
			"3 3\n" + 
			"###\n" + 
			"#@#\n" + 
			"###";
}
