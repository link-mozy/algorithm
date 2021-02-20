package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 20.
 *  @see  https://www.acmicpc.net/problem/15665
 *  @mem  210048
 *  @time 880
 *  @caution
 *  중복순열 + LinkedHashSet 
*/
public class Main_B_15665_N과M_11 {

	static int N, M;
	static int numbers[];
	static LinkedHashSet<String> hashSet; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		hashSet = new LinkedHashSet<String>();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine(), " ");
		numbers = new int [N];
		for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		
		permutation(0, "");
		StringBuilder sb = new StringBuilder();
		for(String numberString : hashSet) sb.append(numberString).append("\n");
		System.out.println(sb);
	}
	
	private static void permutation(int r, String numberString) {
		if(r == M) {
			hashSet.add(numberString.trim());
			return;
		} else {
			for(int i = 0; i < N; i++) {
				permutation(r + 1, numberString + " " + numbers[i]);
			}
		}
	}

	static String src = "4 4\n" + 
			"1 1 2 2";
}