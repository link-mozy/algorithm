package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 14.
 *  @see https://www.acmicpc.net/problem/15654
 *  @mem  30932
 *  @time 256
 *  @caution 
 *  순열 문제, 방문을 체크해주는 배열과, 결과를 담을 배열을 만들어 문제를 푼다.
*/
public class Main_B_15654_N과M_5 {

	static int N, M;
	static int [] numbers;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine(), " ");
		
		numbers = new int [N];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		permutation(0, new boolean [N], new int [M]);
		
		System.out.println(sb);
	}
	
	private static void permutation(int r, boolean visited[], int resultArray []) {
		if(r == M) {
			for(int i = 0; i < M; i++) {
				sb.append(resultArray[i]).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			for(int i = 0; i < N; i++) {
				if(visited[i]) continue;
				visited[i] = true;
				resultArray[r] = numbers[i];
				permutation(r + 1, visited, resultArray);
				visited[i] = false;
			}
		}
	}

	static String src = "4 2\n" + 
			"9 8 7 1";
}
