package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_14696_딱지놀이 {
	
	/**
	 *  @author mozy
	 *  @since Oct 24, 2020
	 *  @see https://www.acmicpc.net/problem/14696 
	 *  @mem 28024
	 *  @time 260
	 *  @caution 
	 *  2중 배열을 만들어 등급이 높은 딱지를 우선으로 비교하면 풀린다.
	*/
	
	static int N;
	static int [][] playerA;
	static int [][] playerB;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		playerA = new int [N][5];
		playerB = new int [N][5];
		
		// 값 입력
		for(int i = 0; i < N; i++) {
			int count = 0;
			
			// A
			st = new StringTokenizer(in.readLine(), " ");
			count = Integer.parseInt(st.nextToken());
			for(int j = 0; j < count; j++) {
				int number = Integer.parseInt(st.nextToken());
				playerA[i][number]++;
			}
			// B
			st = new StringTokenizer(in.readLine(), " ");
			count = Integer.parseInt(st.nextToken());
			for(int j = 0; j < count; j++) {
				int number = Integer.parseInt(st.nextToken());
				playerB[i][number]++;
			}
		}
		
//		// 입력값 확인
//		for(int i = 0; i < N; i++) {
//			System.out.println("A:" + Arrays.toString(playerA[i]));
//			System.out.println("B:" + Arrays.toString(playerB[i]));
//			System.out.println();
//		}
		
		// 딱지 경기하기
		for(int i = 0; i < N; i++) {
			for(int j = 4; j > 0; j--) {
				if(j == 1 && playerA[i][j] == playerB[i][j]) { // D
					sb.append("D\n");
				} else if (playerA[i][j] > playerB[i][j]) { // A
					sb.append("A\n");
					break;
				} else if (playerA[i][j] < playerB[i][j]) { // B
					sb.append("B\n");
					break;
				}
			}
		}
		
		// 출력
		System.out.println(sb);
	}
	
	static String src = "5\n" + 
			"1 4\n" + 
			"4 3 3 2 1\n" + 
			"5 2 4 3 2 1\n" + 
			"4 4 3 3 1\n" + 
			"4 3 2 1 1\n" + 
			"4 2 3 2 1\n" + 
			"4 4 3 2 1\n" + 
			"3 4 3 2\n" + 
			"5 4 4 2 3 1\n" + 
			"5 4 2 4 1 3";
}
