package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 15.
 *  @see https://www.acmicpc.net/problem/15655
 *  @mem  11560
 *  @time 76
 *  @caution
 *  조합문제! 
*/
public class Main_B_15655_N과M_6 {

	static int N, M;
	static int numbers [];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int [N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		
		combination(0, 0, new boolean [N]);
		
		System.out.println(sb);
	}
	
	private static void combination(int start, int r, boolean[] visited) {
		if(r == M) {
			for(int i = 0; i < N; i++) {
				if(visited[i]) sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			for(int i = start; i < N; i++) {
				visited[i] = true;
				combination(i + 1, r + 1, visited);
				visited[i] = false;
			}
		}
	}

	static String src = "4 2\n" + 
			"9 8 7 1";
}
