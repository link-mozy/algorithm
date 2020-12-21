package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2020. 12. 22.
 *  @see 
 *  @mem 
 *  @time 
 *  @caution
 *  Fail (Runtime error)
 *  메모리가 터진다고한다.... 100 * 100 * 100 이면 터지나... 
*/
public class Solution_7733_치즈도둑_DFS {
	
	static int T;
	static int N;
	static int [][] cheese;
	static boolean [][] visited;
	static int [][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			cheese = new int [N][N];
			int maxDay = -1;
			int maxCnt = -1;
			
			// input
			for(int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for(int column = 0; column < N; column++) {
					cheese[row][column] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, cheese[row][column]);
				}
			}
			
			
			// run
			for(int day = 0; day < maxDay; day++) {
				// 초기화
				visited = new boolean [N][N];
				int cnt = 0;
				
				for(int row = 0; row < N; row++) {
					for(int column = 0; column < N; column++) {
						if(!visited[row][column] && cheese[row][column] > day) {
							cnt++;
							dfs(row, column, day);
						}
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
				
			} // day loop
			sb.append("#" + tc + " " + maxCnt).append("\n");
			
		} // tc loop
		System.out.println(sb);
		
	} // main
	
	static void print() {
		for(int row = 0; row < N; row++) {
			for(int column = 0; column < N; column++) {
				int tmp = (visited[row][column]) ? 1 : 0;
				System.out.print(tmp);
			}
			System.out.println();
 		}
		System.out.println();
	}
	
	private static void dfs(int row, int column, int day) {
		if(visited[row][column]) return;
		if(cheese[row][column] <= day) return;
		
		visited[row][column] = true;
		
		for(int d = 0; d < 4; d++) {
			int _row = row + dir[d][0];
			int _column = column + dir[d][1];
			if(isin(_row, _column) && !visited[_row][_column] && cheese[_row][_column] > day) {
				dfs(_row, _column, day);
			}
		}
	}

	private static boolean isin(int row, int column) {
		return 0 <= row && row < N  && 0 <= column && column < N;
	}

	static String src = "2\n" + 
			"2\n" + 
			"1 2\n" + 
			"2 1\n" + 
			"5\n" + 
			"6 8 2 6 2\n" + 
			"3 2 3 4 6\n" + 
			"6 7 3 3 2\n" + 
			"7 2 5 3 6\n" + 
			"8 9 5 2 7";
}
