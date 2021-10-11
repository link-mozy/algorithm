package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_B_13460_구슬탈출2 {
	
	static int N, M;
	static char map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(str));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int redRow = 0, redCol = 0, blueRow = 0, blueCol = 0;
		map = new char [N][M];
		/** input **/
		for(int row = 0; row < N; row++) {
			String line = br.readLine();
			for(int col = 0; col < M; col++) {
				map[row][col] = line.charAt(col);
				if(map[row][col] == 'R') {
					redRow = row;
					redCol = col;
					map[row][col] = '.';
				} else if(map[row][col] == 'B') {
					blueRow = row;
					blueCol = col;
					map[row][col] = '.';
				}
			} // for:col
		} // for:row
		
	}
	
	static class Balls {
		int redRow, redCol;
		int blueRow, blueCol;
		int count;
		
		public Balls(int redRow, int redCol, int blueRow, int blueCol, int count) {
			super();
			this.redRow = redRow;
			this.redCol = redCol;
			this.blueRow = blueRow;
			this.blueCol = blueCol;
			this.count = count;
		}
	}
	
	static String str = "";
}