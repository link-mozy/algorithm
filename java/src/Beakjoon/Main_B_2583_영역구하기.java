package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B_2583_영역구하기 {
	
	/**
	 *  @author mozy
	 *  @since Oct 24, 2020
	 *  @see https://www.acmicpc.net/problem/2583
	 *  @mem 14248
	 *  @time 96
	 *  @caution 
	 *  dfs로 문제를 풀었다. 다만, 한번만 방문해야하기 때문에 visited를 돌려놓지 않는다.
	 *  
	*/

	static int M, N, K, count;
	static int [][] map;
	static boolean [][] visited;
	static int [][] paper;
	
	static int [][] dir = {{0,-1}, {-1,0}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int [M][N];
		visited = new boolean [M][N];
		paper = new int [K][4];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < 4; j++) { // 0:column1, 1:row1, 2:column2, 3:row2
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// 색종이 그리기
			for(int row = paper[i][1]; row < paper[i][3]; row++) {
				for(int column = paper[i][0]; column < paper[i][2]; column++) {
					map[row][column] = 1;
				}
			}
		}
		
		// 영역 구하기
		for(int row = 0; row < M; row++) {
			for(int column = 0; column < N; column++) {
				if(map[row][column] == 0 && !visited[row][column]) {
					count = 0;
					dfs(row, column);
					priorityQueue.add(count);
				}
			}
		}
		
		// 결과 출력
		sb.append(priorityQueue.size()).append("\n");
		while(!priorityQueue.isEmpty()) {
			sb.append(priorityQueue.poll()+ " ");
		}
		System.out.println(sb);
	}
	
	static void dfs(int row, int column) {
		visited[row][column] = true;
		count++;
		
		for(int d = 0; d < dir.length; d++) {
			int row_ = row + dir[d][0];
			int column_ = column + dir[d][1];
			
			if(isin(row_, column_) && map[row_][column_] == 0 && !visited[row_][column_]) {
				dfs(row_, column_);
			}
		}
	}
	
	static boolean isin(int row, int column) {
		return -1 < row && row < M && -1 < column && column < N;
	}
	
	static String src = "5 7 3\n" + 
			"0 2 4 4\n" + 
			"1 1 2 5\n" + 
			"4 0 6 2";
}
