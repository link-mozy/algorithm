package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 19.
 *  @see https://www.acmicpc.net/problem/7569
 *  @mem  123748
 *  @time 612
 *  @caution 
 *  맵 3차 배열, 2차 배열 토마토랑 동일 방법인데, 배열만 3차 일뿐
*/
public class Main_B_7569_토마토 {

	static int N, M, H;
	static int map[][][];
	static boolean visited[][][];
	
	static int dir[][] = {{0, 0, -1}, {0, -1, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 1, 0}, {1, 0, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int [H][N][M];
		visited = new boolean [H][N][M];
		
		Queue<Point> queue = new LinkedList<>();
		
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(in.readLine());
				for(int c = 0; c < M; c++) {
					map[h][r][c] = Integer.parseInt(st.nextToken());
					if(map[h][r][c] == 1) {
						queue.add(new Point(h, r, c));
						visited[h][r][c] = true;
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point front = queue.poll();
			for(int d = 0; d < 6; d++) {
				int nh = front.height + dir[d][0];
				int nr = front.row + dir[d][1];
				int nc = front.column + dir[d][2];
				
				if(!isin(nh, nr, nc) || visited[nh][nr][nc] || map[nh][nr][nc] == -1)
					continue;
				if(map[nh][nr][nc] == 0) {
					queue.add(new Point(nh, nr, nc));
					map[nh][nr][nc] = map[front.height][front.row][front.column] + 1;
					visited[nh][nr][nc] = true;
				}
			}
		}

		System.out.println(check());
	}
	
	static void print() {
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					System.out.print(map[h][r][c] + " ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}
	
	private static int check() {
		int max = -1;
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(map[h][r][c] == 0) return -1;
					else if(max < map[h][r][c]) max = map[h][r][c];
				}
			}
		}
		return max - 1;
	}

	private static boolean isin(int height, int row, int column) {
		return 0 <= height && height < H && 0 <= row && row < N && 0 <= column && column < M;
	}

	static class Point {
		int height;
		int row;
		int column;
		
		public Point(int height, int row, int column) {
			super();
			this.height = height;
			this.row = row;
			this.column = column;
		}
	}
	
	static String src = "5 3 1\n" + 
			"0 -1 0 0 0\n" + 
			"-1 -1 0 1 1\n" + 
			"0 0 0 1 1";
}
