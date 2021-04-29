package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2021. 4. 30.
 * @see  https://www.acmicpc.net/problem/17281
 * @mem  60728
 * @time 472
 * @caution 
 * 순열 & 구현 문제.
 * 타자 이동 및 득점 주의 해야함.
 */
public class Main_B_17281_Baseball_2 {
	
	static final int PLAYER_NUM = 9;
	static int N;
	static int max;
	static int playersArr [][];
	static boolean visited [];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		max = 0;
		// N : inning
		N = Integer.parseInt(in.readLine());
		playersArr = new int [N][PLAYER_NUM];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < PLAYER_NUM; j++) playersArr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean [PLAYER_NUM];
		int players [] = new int [PLAYER_NUM];
		players[3] = 0; // 아인타는 자신이 가장 좋아하는 선수 1번 선수를 4번 타자로 미리 결정
		playGame(0, players);
		
		System.out.println(max);
		
	} // main
	

	// permutation function
	private static void playGame(int r, int [] players) {
		if(r == PLAYER_NUM) {
			baseballGame(players);
			return;
		} else {
			for(int i = 1; i < PLAYER_NUM; i++) {
				if(r == 3) r++;
				if(visited[i]) continue;
				visited[i] = true;
				players[r] = i;
				playGame(r + 1, players);
				visited[i] = false;
			}
		}
	}

	// baseball rule function
	private static void baseballGame(int[] players) {
		int outCount = 0, current = 0, point = 0; // 아웃카운트, 탐자순서번호, 점수
		
		// round : inning
		for(int round = 0; round < N; round++) {
			outCount = 0;
			boolean base [] = new boolean [4];
			
			while(outCount < 3) { // 3 out change (end)
				int playerNum = players[current];
				base[0] = true; // base[0] : 타자
				if (playersArr[round][playerNum] == 0) outCount++;
				else {
					for(int idx = 3; idx >= 0; idx--) {
						if (base[idx] == false) continue;
						int temp = idx + playersArr[round][playerNum];
						if (temp > 3) point++; // 득점
						else base[temp] = true; // 타자 이동
						base[idx] = false;
					} // while.else.for
					
				} // while.else
				current++;
				if (current == 9) current = 0;
				
			} // while
			
		} // for
		max = Math.max(max, point);
		
	} // fn_baseballGame

	static String src = "9\n"
			+ "1 2 4 3 0 2 1 0 3\n"
			+ "1 2 1 2 0 0 0 0 1\n"
			+ "3 4 2 3 1 2 3 4 0\n"
			+ "0 1 2 3 4 2 1 0 0\n"
			+ "0 0 0 0 0 0 1 4 4\n"
			+ "0 4 0 4 0 4 0 4 0\n"
			+ "0 4 2 2 2 2 2 2 2\n"
			+ "1 1 1 1 1 1 1 1 0\n"
			+ "0 2 0 3 0 1 0 2 0";
}
