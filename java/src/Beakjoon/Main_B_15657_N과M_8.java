package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 17.
 *  @see https://www.acmicpc.net/problem/15657
 *  @mem  17928 
 *  @time 120
 *  @caution
 *  중복조합 문제. 
*/
public class Main_B_15657_N과M_8 {

	static int N, M;
	static int numbers[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		sb =new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int [N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		
		combination(0, 0, new int [M]);
		
		System.out.println(sb);
		
	}
	
	private static void combination(int start, int r, int[] numberArr) {
		if(r == M) {
			for(int i = 0; i < M; i++) sb.append(numberArr[i]).append(" ");
			sb.append("\n");
			return;
		} else {
			for(int i = start; i < N; i++) {
				numberArr[r] = numbers[i];
				combination(i, r + 1, numberArr);
			}
		}
	}

	static String src = "4 2\n" + 
			"9 8 7 1";
}
