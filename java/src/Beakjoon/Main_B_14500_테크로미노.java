package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since Nov 7, 2020
 *  @see https://www.acmicpc.net/problem/14500
 *  @mem 31776
 *  @time 888 
 *  @caution 
 *  dfs로 푸는데, visited 전역으로 선언해싿면 백트로킹 해줘야하고, dfs 로 하면, (ㅏ, ㅜ, ㅓ, ㅗ) 모양은
 *  만들수없으므로 따로 구해줘야한다.
 *  문제를 읽고 만들수있는 도형을 미리 생각하는게 문제 키포인트
 *  알고리즘 보충 수업을 듣고 풀수있었다... (처음에 dfs로 풀었지만, dfs로 만들수없는 도형을 bfs를 적용하려고함....)
*/

public class Main_B_14500_테크로미노 {
	
	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int max;
	
	static int [][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		visited = new boolean [N][M];
		max = Integer.MIN_VALUE;
		
		// 값 입력
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int column = 0; column < M; column++) {
				map[row][column] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 테크로미노
		for (int row = 0; row < N; row++) {
			for(int column =0; column < M; column++) {
				dfs(row, column, 0, 0);
				dfs2(row, column);
			}
		}
		System.out.println(max);
	}
	

	private static void dfs(int row, int column, int count, int value) {
		if(count == 4) {
			max = Math.max(max, value);
			return;
		} else {
			for(int d = 0; d < 4; d++) {
				int nrow = row + dir[d][0];
				int ncolumn = column + dir[d][1];
				if(!isin(nrow, ncolumn)) continue;
				if(visited[nrow][ncolumn]) continue;
				visited[nrow][ncolumn] = true;
				dfs(nrow, ncolumn, count + 1, value + map[nrow][ncolumn]);
				visited[nrow][ncolumn] = false;
			}
		}
	}
	
	
	private static void dfs2(int row, int column) {
		int dir4 = 0;
		int value = map[row][column];
		int min = 1001;
		for(int d = 0; d < 4; d++) {
			int nrow = row + dir[d][0];
			int ncolumn = column + dir[d][1];
			if(isin(nrow, ncolumn)) {
				dir4++;
				value += map[nrow][ncolumn];
				min = Math.min(min, map[nrow][ncolumn]);
			}
		}
		if (dir4 == 4) max = Math.max(max, (value - min));
		if (dir4 == 3) max = Math.max(max, value);
	}


	private static boolean isin(int row, int column) {
		return -1 < row && row < N && -1 < column && column < M;
	}


	static String src = "5 5\n" + 
			"1 2 3 4 5\n" + 
			"5 4 3 2 1\n" + 
			"2 3 4 5 6\n" + 
			"6 5 4 3 2\n" + 
			"1 2 1 2 1";
}
