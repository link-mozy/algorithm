package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 3. 19.
 *  @see  https://www.acmicpc.net/problem/17070
 *  @mem  14868
 *  @time 272
 *  @caution 
 *  DFS로 해결
 *  문제 컨셉은 쉬운데, 구현에서 자꾸 실수하는 문제.
 *  방향이 오른쪽, 아래로 가기때문에 방문체크는 하지않아도 되나 조건에 따라 예외를 잘걸어주면 되는 문제
 *  
*/
public class Main_B_17070_파이프옮기기1_DFS {

	static int N, result;
	static int map[][];
	static int dir[][] = {{0, 1}, {1, 0}, {1, 1}}; // 가로, 세로, 대각선
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		map = new int [N][N];
		
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int col = 0; col < N; col++) map[row][col] = Integer.parseInt(st.nextToken());
		}
		
		result = 0;
		dfs(0, 0, 1); // type, row, col
		
		System.out.println(result);
		
	} // main
	
	private static void dfs(int type, int row, int col) {
		if(row == N -1 && col == N - 1) {
			result++;
			return;
		} else {
			for(int d = 0; d < 3; d++) {
				if(type == 0 && d == 1) continue;		// 90도 회전 불가능
				else if(type == 1 && d == 0) continue;	// 90도 회전 불가능
				
				int nrow = row + dir[d][0];
				int ncol = col + dir[d][1];
				
				if(!isin(nrow, ncol)) continue;
				if(d == 2) {	// 대각선은 3곳 체크
					if(map[nrow][col] == 0 && map[row][ncol] == 0 && map[nrow][ncol] == 0) dfs(d, nrow, ncol);
				} else {		// 대각선이 아니면, 가로 or 세로만 체크
					if(map[nrow][ncol] == 0) dfs(d, nrow, ncol);
				}
			}
		}
		
	} // dfs

	private static boolean isin(int row, int col) {
		return row < N && col < N;
	}

	static String src = "6\n" + 
			"0 0 0 0 0 0\n" + 
			"0 1 0 0 0 0\n" + 
			"0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0";
}
