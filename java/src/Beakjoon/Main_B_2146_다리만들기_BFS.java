package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2020. 12. 30.
 *  @see https://www.acmicpc.net/problem/2146
 *  @mem  77424
 *  @time 208
 *  @caution 
 *  처음에 입력받을때 모든 맵을 다받고
 *  다음에 모든 맵을 돌면서 섬을 분류하고
 *  다음에 A섬에서 다른 섬을 찾는데 모든 맵을 돌면서 찾도록 한다.
*/
public class Main_B_2146_다리만들기_BFS {

	static int N;
	static int[][] map;
	static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st; 
		
		N = Integer.parseInt(in.readLine());
		
		map = new int [N][N];
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int column = 0; column < N; column++) {
				map[row][column] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 섬 구분하기 & 가장자리 구하기
		boolean [][] visited = new boolean [N][N];
		int num = 0;
		Queue<Point> list = new LinkedList<Point>();
		
		for(int row = 0; row < N; row++) {
			for(int column = 0; column < N; column++) {
				if(visited[row][column] || map[row][column] == 0) continue;
				num++;
				Queue<Point> queue = new LinkedList<Point>();
				queue.add(new Point(row, column));
				visited[row][column] = true;
				
				while(!queue.isEmpty()) {
					Point front = queue.poll();
					map[front.row][front.column] = num;
					if(check(front.row, front.column)) list.add(new Point(front.row, front.column, num));
					for(int d = 0; d < 4; d++) {
						int _row = front.row + dir[d][0];
						int _column = front.column + dir[d][1];
						if(isin(_row, _column) && !visited[_row][_column] && map[_row][_column] > 0) {
							queue.add(new Point(_row, _column));
							visited[_row][_column] = true;
						}
					}
				} // while loop
			}
		}
		
		// 가장 짧은 섬 찾기
		int minDist = Integer.MAX_VALUE;
		while(!list.isEmpty()) {
			minDist = Math.min(solution(list.poll()), minDist);
		}
		
		System.out.println(minDist);
		
	} // main
	
	static int solution(Point start) {
		int dist = 1000000;
		int num = map[start.row][start.column];
		boolean [][] visited = new boolean [N][N];
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(start);
		visited[start.row][start.column] = true;
		
		while(!queue.isEmpty()) {
			Point front = queue.poll();
			for(int d = 0; d < 4; d++) {
				int _row = front.row + dir[d][0];
				int _column = front.column + dir[d][1];
				if(isin(_row, _column) && !visited[_row][_column] && map[_row][_column] != num) {
					if(map[_row][_column] != 0) {
						return front.dis;
					}
					queue.add(new Point(_row, _column, num, front.dis+1));
					visited[_row][_column] = true;
				}
			}
		}
		
		return dist;
	}
	
	private static void print() {
		for(int row = 0; row < N; row++) {
			System.out.println(Arrays.toString(map[row]));
		}
		System.out.println();
	}

	private static boolean check(int row, int column) {
		for(int d = 0; d < 4; d++) {
			int _row = row + dir[d][0];
			int _column = column + dir[d][1];
			if(isin(_row, _column) && map[_row][_column] == 0) return true;
		}
		return false;
	}

	private static boolean isin(int row, int column) {
		return 0 <= row && row < N && 0 <= column && column < N;
	}

	static class Point {
		int row;
		int column;
		int num;
		int dis;
		
		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}

		public Point(int row, int column, int num) {
			this(row, column);
			this.num = num;
		}

		public Point(int row, int column, int num, int dis) {
			this(row, column, num);
			this.dis = dis;
		}

		@Override
		public String toString() {
			return "[r:" + row + ", c:" + column + ", n:" + num + ", d:" + dis + "] ";
		}
	}
	
	private static String src = "5\n" + 
			"1 0 0 0 0\n" + 
			"0 0 0 0 0\n" + 
			"0 0 0 0 1\n" + 
			"0 0 0 0 0\n" + 
			"0 0 0 0 1";
}
