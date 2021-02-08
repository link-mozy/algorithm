package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 8.
 *  @see https://www.acmicpc.net/problem/17142
 *  @mem  40752
 *  @time 236
 *  @caution
 *  조합이랑 구현문제,
 *  바이러스이지만 선택되지 않은 바이러스 처리하는 것이 제일 중요!
 *  나는 DFS에서 큐에 담았던 바이러스를 꺼냈을때, 기존에 활성화된 바이러스지만 선택되지 않았으면, 비교하지 않고 넘어가게했다. 
*/
public class Main_B_17142_연구소3 {

	static int N, M, len, min;
	static int map[][];
	static List<Virus> viruses;
	
	static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		viruses = new LinkedList<Virus>();
		map = new int [N][N];
		min = Integer.MAX_VALUE;
		
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if(map[row][col] == 2) viruses.add(new Virus(row, col));
			}
		}

		len = viruses.size();
		combination(0, 0, new int [M]);
		
		System.out.println((min == Integer.MAX_VALUE)? -1 : min);
	}
	
	private static void combination(int start, int r, int[] choiced) {
		if(r == M) {
			attack(choiced);
			return;
		}
		
		for(int i = start; i < len; i++) {
			choiced[r] = i;
			combination(i + 1, r + 1, choiced);
		}
	}

	private static void attack(int[] choiced) {
		boolean visited [][] = new boolean [N][N];
		LinkedList<Virus> queue = new LinkedList<Virus>();
		int max = 0;
		
		for(int i = 0; i < M; i++) {
			Virus virus = viruses.get(choiced[i]);
			visited[virus.row][virus.col] = true;
			virus.day = 0;
			queue.add(virus);
		}
		
		while(!queue.isEmpty()) {
			Virus front = queue.poll();
			if(map[front.row][front.col] != 2
			  &&front.day > max) max = front.day;
			
			for(int d = 0; d < 4; d++) {
				int nrow = front.row + dir[d][0];
				int ncol = front.col + dir[d][1];
				
				if(isin(nrow, ncol) && !visited[nrow][ncol]) {
					int point = map[nrow][ncol];
					if(point == 1) {
						visited[nrow][ncol] = true;
					} else {
						visited[nrow][ncol] = true;
						queue.add(new Virus(nrow, ncol, front.day + 1));
					}
				}
			}
		}
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(map[row][col] == 1) continue;
				if(!visited[row][col]) return;
			}
		}

		min = Math.min(min, max);
	}

	private static boolean isin(int row, int col) {
		return -1 < row && row < N && -1 < col && col < N;
	}

	static class Virus {
		int row;
		int col;
		int day;
		
		public Virus(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		public Virus(int row, int col, int day) {
			this(row, col);
			this.day = day;
		}

		@Override
		public String toString() {
			return "Virus [row=" + row + ", col=" + col + "]";
		}
	}
	
	static String src = "5 1\n" + 
			"1 1 1 1 1\n" + 
			"1 1 1 1 1\n" + 
			"1 1 1 1 1\n" + 
			"0 2 0 2 0\n" + 
			"1 1 1 1 1";
}
