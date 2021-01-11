package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 11.
 *  @see  https://www.acmicpc.net/problem/3109
 *  @mem  52048
 *  @time 348
 *  @caution 
 *  문제에서 방향을 제시해준다. (오른쪽, 오른쪽위, 오른쪽아래) 그런데, 내 마음데로 다섯방향으로 하여 문제를 틀렷다.
 *  그리고 처음에 dfs를 만들때 visited를 회수하는식으로 하면 시간초과가 난다...
 *  시간초과났을때... 해결하는게 너무 어렵다...
*/
public class Main_B_3109_빵집 {

	static int R, C;
	static char map[][];
	static boolean visited[][];
	
	// static int dir[][] = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}};
	static int dir[][] = {{-1, 1},{0, 1},{1,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		visited = new boolean [R][C];
		int result = 0;
		for(int row = 0; row < R; row++) {
			map[row] = in.readLine().toCharArray();
			for(int col = 0; col < C; col++) {
				if(map[row][col] == 'x') visited[row][col] = true;
			}
		}
		
		for(int row = 0; row < R; row++) {
			if(dfs(row, 0)) result++;
		}
		System.out.println(result);
	}
	
	private static boolean dfs(int row, int col) {
		visited[row][col] = true;
		
		if(col == C - 1) {
			return true;
		} else {
			int nrow;
			int ncol;
			
			for(int d = 0; d < 3; d++) {
				nrow = row + dir[d][0];
				ncol = col + dir[d][1];
				
				if(!isin(nrow, ncol) || visited[nrow][ncol] || map[nrow][ncol] == 'x') {
					continue;
				}
				if(dfs(nrow, ncol)) {
					return true;
				} 
			}
			
			return false;
		}
	}
	
	static void printVisited() {
		for(int row = 0; row < R; row++) {
			for(int col = 0; col < C; col++) {
				System.out.print((visited[row][col])? 1 : 0);
			} System.out.println();
		} System.out.println();
	}

	private static boolean isin(int row, int col) {
		return 0 <= row && row < R && 0 <= col && col < C;
	}

	static String src = "5 9\n" + 
			".x.....x.\n" + 
			".x..x..x.\n" + 
			".x..x..x.\n" + 
			"....x....\n" + 
			".x..x..x.";
}
