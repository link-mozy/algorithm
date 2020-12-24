package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2020. 12. 25.
 *  @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWyNQrCahHcDFAVP
 *  @mem  104,076 kb
 *  @time 349 ms
 *  @caution 
 *  최단거리는 BFS로 풀어야하는거 아닌가...
 *  Point클래스를 만들고 가로로 시작할때와 세로로 시작할때를 만들어 BFS로 풀었다...
 *  시간과 메모리 효율성이 몹시떨어짐...
*/
public class Solution_8382_방향전환 {
	
	static int T;
	static int [][] dir1 = {{-1, 0}, {1, 0}}; // 세로
	static int [][] dir2 = {{0, -1}, {0, 1}}; // 가로
	static Point start;
	static Point end;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int [][] map = new int [201][201];
			int min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			start = new Point(100 + Integer.parseInt(st.nextToken()), 100 + Integer.parseInt(st.nextToken()), 0);
			int end_column = 100 + Integer.parseInt(st.nextToken());
			int end_row = 100 + Integer.parseInt(st.nextToken());
			
			// 세로 먼저
			start.d = 1;
			boolean [][] visited = new boolean [201][201];
			visited[start.y][start.x] = true;
			Queue<Point> queue = new LinkedList<Point>();
			queue.add(start);
			while(!queue.isEmpty()) {
				Point front = queue.poll();
				int row = front.y;
				int column = front.x;
				if(end_row == row && end_column == column) {
					min = Math.min(min, front.cnt);
				}
				if(front.d > 0) { // 세로
					for(int d = 0; d < 2; d++) {
						int _row = dir1[d][0] + row;
						int _column = dir1[d][1] + column;
						if(isin(_row, _column) && !visited[_row][_column]) {
							visited[_row][_column] = true;
							queue.add(new Point(_column, _row, -1, front.cnt + 1));
						}
					}
				} else { // 가로
					for(int d = 0; d < 2; d++) {
						int _row = dir2[d][0] + row;
						int _column = dir2[d][1] + column;
						if(isin(_row, _column) && !visited[_row][_column]) {
							visited[_row][_column] = true;
							queue.add(new Point(_column, _row, 1, front.cnt + 1));
						}
					}
				}
			} // while
		
			// 가로 먼저
			start.d = -1;
			queue = new LinkedList<Point>();
			visited = new boolean [201][201];
			visited[start.y][start.x] = true;
			queue.add(start);
			while(!queue.isEmpty()) {
				Point front = queue.poll();
				int row = front.y;
				int column = front.x;
				if(end_row == row && end_column == column) {
					min = Math.min(min, front.cnt);
				}
				if(front.d > 0) { // 세로
					for(int d = 0; d < 2; d++) {
						int _row = dir1[d][0] + row;
						int _column = dir1[d][1] + column;
						if(isin(_row, _column) && !visited[_row][_column]) {
							visited[_row][_column] = true;
							queue.add(new Point(_column, _row, -1, front.cnt + 1));
						}
					}
				} else { // 가로
					for(int d = 0; d < 2; d++) {
						int _row = dir2[d][0] + row;
						int _column = dir2[d][1] + column;
						if(isin(_row, _column) && !visited[_row][_column]) {
							visited[_row][_column] = true;
							queue.add(new Point(_column, _row, 1, front.cnt + 1));
						}
					}
				}
			} // while
			
			sb.append("#" + tc + " " + min).append("\n");
			
		} // tc
		
		System.out.println(sb);
		
	} // main
	
	static boolean isin(int row, int column) {
		return 0 <= row && row < 201 && 0 <= column && column < 201;
	}

	static class Point {
		int x;
		int y;
		int d;
		int cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		public Point(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point[" + x + ", " + y + ", " + d + "] ";
		}
	}
	
	static String src = "3\n" + 
			"0 0 1 0\n" + 
			"-1 -1 0 0\n" + 
			"0 0 0 2";
}