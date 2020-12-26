package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2020. 12. 26.
 *  @see https://www.acmicpc.net/problem/2636
 *  @mem   14188
 *  @time  132
 *  @caution 
 *  BFS, 치즈없는 곳을 기준으로 BFS를 사용
*/
public class Main_B_2636_치즈_BFS {

	static int[][] map;
	static int R, C;
	static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int day = 0;
		int size = 0;
		boolean[][] visited;
		
		map = new int [R][C];
		
		for(int row = 0; row < R; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int column = 0; column < C; column++) {
				map[row][column] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> removeList = new LinkedList<>();
		while(true) {
			day++;
			Queue<Point> queue = new LinkedList<Point>();
			queue.add(new Point(0, 0));
			visited = new boolean [R][C]; 
			visited[0][0] = true;
			
			while(!queue.isEmpty()) {
				Point front = queue.poll();
				int row = front.row;
				int column = front.column;
				
				for(int d = 0; d < 4; d++) {
					int _row = row + dir[d][0];
					int _column = column + dir[d][1];
					if(isIn(_row, _column) && !visited[_row][_column]) {
						visited[_row][_column] = true;
						if(map[_row][_column] == 0) {
							queue.add(new Point(_row, _column));
						} else {
							removeList.add(new Point(_row, _column));
						}
					}
				}
			}
			
			if(removeList.isEmpty()) {
				break;
			}
			else {
				size = removeList.size();
				while(!removeList.isEmpty()) {
					Point front = removeList.poll();
					map[front.row][front.column] = 0;
				}
			}
		} // while(true) loop
		System.out.println(day - 1);
		System.out.println(size);
		
	} // main
	
	private static boolean isIn(int row, int column) {
		return 0 <= row && row < R && 0 <= column && column < C;
	}

	static class Point {
		int row;
		int column;

		public Point(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}
	}
	
	private static String src = "13 12\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 1 1 0 0 0\n" + 
			"0 1 1 1 0 0 0 1 1 0 0 0\n" + 
			"0 1 1 1 1 1 1 0 0 0 0 0\n" + 
			"0 1 1 1 1 1 0 1 1 0 0 0\n" + 
			"0 1 1 1 1 0 0 1 1 0 0 0\n" + 
			"0 0 1 1 0 0 0 1 1 0 0 0\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0";
}
