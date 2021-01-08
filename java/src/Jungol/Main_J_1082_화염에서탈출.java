package Jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 8.
 *  @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=362&sca=3040
 *  @mem  12MB
 *  @time 172
 *  @caution
 *  백준 4179와 비슷하고 BFS를 사용하여 문제를 풀었다.
 *  주의할점은 도착지점을 불로 만들지 않게 주의해야한다. 
*/
public class Main_J_1082_화염에서탈출 {
	
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
					map[row][col] = '.';
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
		System.out.println((result > 0)? result : "impossible");
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
			
			// print(front); // 디버그 프린트
			
			for(int d = 0; d < 4; d++) {
				int nrow = row + dir[d][0];
				int ncol = col + dir[d][1];

				if(!isin(nrow, ncol) || map[nrow][ncol] == '*' || map[nrow][ncol] == 'X')
					continue;
				
				if(drow == nrow && dcol == ncol) {
					// 도착
					if(type == 0) return dist + 1;
				} else if(type == 0 && !visited[nrow][ncol]) {
					queue.add(new Point(nrow, ncol, type, dist + 1));
					visited[nrow][ncol] = true;
				} else if(type == 1) {
					queue.add(new Point(nrow, ncol, type, dist + 1));
					map[nrow][ncol] = '*';
				}
			}
		}
		return 0;
	}

	private static void print(Point front) {
		for(int row = 0; row < R; row++) {
			for(int col = 0; col < C; col++) {
				System.out.print(map[row][col]);
			} System.out.println();
		} System.out.println(front);
		System.out.println();
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
	
	static String src = "8 6\n" + 
			"D...*.\n" + 
			".XXX..\n" + 
			".X*...\n" + 
			".XS...\n" + 
			".XXX..\n" + 
			"......\n" + 
			"XXXXX.\n" + 
			"*.....";
}
