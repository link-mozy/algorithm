package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 *  @author mozy
 *  @since 2021. 3. 19.
 *  @see https://www.acmicpc.net/problem/17070
 *  @mem 
 *  @time 
 *  @caution
 *  시간 초과 로 실패한 방법
 *  BFS도 풀수는 있다고하는데... 시간 초과남... 
*/
public class Main_B_17070_파이프옮기기1 {
	
	static int N;
	static int map [][];
	static int dir [][] = {{0, 1}, {1, 0}, {1, 1}}; // 가로, 세로, 대각선
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(in.readLine());
		
		map = new int [N][N];
		
		StringTokenizer st;
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int col = 0; col < N; col++) map[row][col] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bfs());
		
	} // main
	
	private static int bfs() {
		int result = 0;
		
		Queue<Pipe> queue = new LinkedList<Pipe>();
		queue.add(new Pipe(0, 0, 1)); // type, row, col 순서
		
		while(!queue.isEmpty()) {
			Pipe front = queue.poll();
			int type = front.type;
			
			if(front.row == N -1 && front.col == N - 1) {
				result++;
				continue;
			}
			
			for(int d = 0; d < 3; d++) {
				int nrow = front.row + dir[d][0];
				int ncol = front.col + dir[d][1];
				
				if(type == 0 && d == 1) continue; // 가로이면, 세로로 갈 수 없다.
				else if(type == 1 && d == 0) continue; // 세로이면, 가로로 갈 수 없다.
				
				if(checkArea(d, nrow, ncol)) queue.add(new Pipe(d, nrow, ncol));
			} // for d
			
		} // while queue
		
		return result;
	} // function bfs
	
	private static boolean checkArea(int type, int row, int col) {
		if(row >= N || col >= N) return false;
		
		if(type != 2) {
			if(map[row][col] == 0) return true;
		} else {
			if (map[row][col] == 0 && map[row - 1][col] == 0 && map[row][col - 1] == 0) return true;
		}
		return false;
	}

	static class Pipe {
		int type;
		int row;
		int col;
		
		public Pipe(int type, int row, int col) {
			this.type = type;
			this.row = row;
			this.col = col;
		}
	}

	static String src = "6\n" + 
			"0 0 0 0 0 0\n" + 
			"0 1 0 0 0 0\n" + 
			"0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0";
	
}
