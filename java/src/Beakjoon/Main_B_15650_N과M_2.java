package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 *  @author mozy
 *  @since 2021. 2. 11.
 *  @see https://www.acmicpc.net/problem/15650
 *  @mem  11532
 *  @time 84
 *  @caution
 *  중복값을 제외한 순열 = 조합
 *  조합을 구현하는 문제
*/

public class Main_B_15650_N과M_2 {
	
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		sb = new StringBuilder();
		String numbers [] = in.readLine().split(" ");
		N = Integer.parseInt(numbers[0]);
		M = Integer.parseInt(numbers[1]);
		
		combination(1, 0, new int [M]);
		System.out.println(sb);
	}
	
	private static void combination(int start, int r, int[] numberArr) {
		if(r == M) {
			
			for(int i = 0; i < M; i++) {
				sb.append(numberArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			
			for(int i = start; i <= N; i++) {
				numberArr[r] = i;
				
				combination(i + 1, r + 1, numberArr);
			}
		}
	}

	static String src = "4 2";
}
