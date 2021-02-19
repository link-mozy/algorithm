package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 19.
 *  @see  https://www.acmicpc.net/problem/15664
 *  @mem  11616 
 *  @time 76
 *  @caution 
 *  조합 + LinkedHashSet 자료형 문제
 *  N과M(9)에서 처음 배운 LinkedHashSet 을 이용한 문자열 처리를 사용하면 쉽게 풀수있다.
*/
public class Main_B_15664_N과M_10 {

	static int N, M;
	static int numbers [];
	static LinkedHashSet<String> hashSet;
	
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		hashSet = new LinkedHashSet<String>();
		visited = new boolean [10001];
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int [N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		
		combination(0, 0, "");

		StringBuilder sb = new StringBuilder();
		for(String numberString : hashSet) sb.append(numberString).append("\n");
		System.out.println(sb);
	}
	
	private static void combination(int start, int r, String numberString) {
		if(r == M) {
			hashSet.add(numberString.trim());
			return;
		} else {
			for(int i = start; i < N; i++) {
				combination(i + 1, r + 1, numberString + " " + numbers[i]);
			}
		}
	}

	static String src = "4 4\n" + 
			"1 1 2 2";
}
