package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2020. 12. 22.
 *  @see 
 *  @mem 102,368 kb 
 *  @time 424 ms
 *  @caution 
 *  처음에 DFS로 풀면 메모리 초과로 인해 런타임 에러가 난다.
 *  중복되는 경우를 가지를 쳐야하는지 모르겠으나 실행속도와 메모리가 좋지는 않다.
*/
public class Solution_7733_치즈도둑_BFS {

	static int T;
	static int N;
	static int [][] cheese;
	static int [][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			cheese = new int[N][N];
			int maxDay = -1;
			int maxCnt = -1;

			for (int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int column = 0; column < N; column++) {
					cheese[row][column] = Integer.parseInt(st.nextToken());
					if (maxDay < cheese[row][column])
						maxDay = cheese[row][column];
				}
			}

			for (int day = 0; day < maxDay; day++) {
				
				int cnt = 0;
				boolean[][] visited = new boolean[N][N];
				Queue<Point> queue = new LinkedList<Point>();

				for (int row = 0; row < N; row++) {
					for (int column = 0; column < N; column++) {
						if (!visited[row][column] && cheese[row][column] > day) {
							
							cnt++;
							// bfs
							queue.add(new Point(row, column));
							visited[row][column] = true;
							
							while(!queue.isEmpty()) {
								Point front = queue.poll();
								
								for(int d = 0; d < 4; d++) {
									int _row = front.row + dir[d][0];
									int _column = front.column + dir[d][1];
									if(isin(_row, _column) && !visited[_row][_column] && cheese[_row][_column] > day) {
										queue.add(new Point(_row, _column));
										visited[_row][_column] = true;
									}
								}
							} // queue.isEmpty
						}
					}
				}
				
				maxCnt = Math.max(maxCnt, cnt);
			} // number loop

			// System.out.println(maxCnt);
			sb.append("#" + tc + " " + maxCnt).append("\n");
		} // tc loop

		System.out.println(sb);
	} // main

	private static boolean isin(int row, int column) {
		return 0 <= row && row < N && 0 <= column && column < N;
	}

	static class Point {
		int row;
		int column;

		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}

	}

	static String src = "2\n" + 
			"2\n" + 
			"1 2\n" + 
			"2 1\n" + 
			"5\n" + 
			"6 8 2 6 2\n" + 
			"3 2 3 4 6\n" + 
			"6 7 3 3 2\n" + 
			"7 2 5 3 6\n" + 
			"8 9 5 2 7";
}
