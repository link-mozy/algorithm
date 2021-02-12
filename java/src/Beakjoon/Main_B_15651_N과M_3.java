package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 *  @author mozy
 *  @since 2021. 2. 12.
 *  @see https://www.acmicpc.net/problem/15651
 *  @mem  111904 
 *  @time 396
 *  @caution 
 *  순열 문제, 중복 허용 순열
 *  재귀를 사용하여 쉽게 풀수있는 문제이다.
*/

public class Main_B_15651_N과M_3 {

	static int N, M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		sb = new StringBuilder();
		
		String [] inputNM = in.readLine().split(" ");
		N = Integer.parseInt(inputNM[0]);
		M = Integer.parseInt(inputNM[1]);
		
		permutation(0, 0, new int [M]);
		
		System.out.println(sb);
	}
	
	private static void permutation(int start, int r, int[] numberse) {
		if(r == M) {
			for(int i = 0; i < M; i++) {
				sb.append(numberse[i]).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			for(int i = 1; i <= N; i++) {
				numberse[r] = i;
				permutation(i, r + 1, numberse);
			}
		}
	}

	static String src = "4 2";
}
