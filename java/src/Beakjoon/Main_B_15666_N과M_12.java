package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 22.
 *  @see  https://www.acmicpc.net/problem/15666
 *  @mem  12312
 *  @time 88
 *  @caution
 *  중복 조합, 입력받은 배열에서 전의 값과 비교하여 같으면 패스한다. 
*/
public class Main_B_15666_N과M_12 {

	static int N, M;
	static int numbers[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int [N+1];
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i < N + 1; i++) numbers[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(numbers);
		
		combination(1, 0, new int [M]);
		
		System.out.println(sb);
	}
	
	private static void combination(int start, int r, int[] numberArr) {
		if(r == M) {
			for(int i = 0; i < M; i++) sb.append(numberArr[i]).append(" ");
			sb.append("\n");
			return;
		} else {
			for(int i = start; i < N + 1; i++) {
				if(numbers[i - 1] == numbers[i]) continue;
				numberArr[r] = numbers[i];
				combination(i, r + 1, numberArr);
			}
		}
	}

	static String src = "4 2\n" + 
			"9 7 9 1";
}
