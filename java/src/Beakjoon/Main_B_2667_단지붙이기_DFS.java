package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 *  @author mozy
 *  @since Dec 19, 2020
 *  @see  https://www.acmicpc.net/problem/2667
 *  @mem 11560
 *  @time 80
 *  @caution
 *  dfs, bfs 문제
 *  DFS를 사용하여 문제를 풀었고, for문을 돌면서 조건에 맞으면 dfs함수를 타도록하였다.
*/
public class Main_B_2667_단지붙이기_DFS {
	
	static int N;
	static int [][] map;
	static boolean [][] visited;
	static int [][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int num = 1;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(in.readLine());
		map = new int [N][N];
		visited = new boolean [N][N];
		
		Queue<Integer> result = new PriorityQueue<Integer>();
		
		for(int row = 0; row < N; row++) {
			String line = in.readLine();
			for(int column = 0; column < N; column++) {
				map[row][column] = line.charAt(column) - 48;
			}
		}
		
		for(int row = 0; row < N; row++) {
			for(int column = 0; column < N; column++) {
				if(map[row][column] == 0 || visited[row][column]) {
					continue;
				}
				cnt = 0;
				dfs(row, column);
				num++;
				result.add(cnt);
			}
		}
		
		int len = result.size();
		sb.append(len + "\n");
		while (!result.isEmpty()) {
			sb.append(result.poll() + "\n");
		}
		System.out.println(sb);
	}
	
	private static void print() {
		for(int row = 0; row < N; row++) {
			for(int column = 0; column < N; column++) {
				System.out.print(map[row][column]);
			}
			System.out.println();
		}
	}
	
	private static void dfs(int row, int column) {
		if(visited[row][column] || map[row][column] == 0) {
			return;
		}
		
		visited[row][column] = true;
		map[row][column] = num;
		cnt++;
		
		for(int d = 0; d < 4; d++) {
			int _row = row + dir[d][0];
			int _column = column + dir[d][1];
			
			if(isin(_row, _column)) {
				dfs(_row, _column);
			}
		}
	}

	private static boolean isin(int row, int column) {
		return 0 <= row && row < N && 0 <= column && column < N;
	}

	static String src = "7\n" + 
			"0110100\n" + 
			"0110101\n" + 
			"1110101\n" + 
			"0000111\n" + 
			"0100000\n" + 
			"0111110\n" + 
			"0111000";
}
