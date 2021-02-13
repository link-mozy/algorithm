package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 *  @author mozy
 *  @since 2021. 2. 13.
 *  @see https://www.acmicpc.net/problem/15652
 *  @mem  13968
 *  @time 100
 *  @caution
 *  중복 조합, 같은 숫자를 뽑을 수 있는 조합
 *  기본 조합 알고리즘 코드에서 재귀를 호출할때 i에 + 1을 하지 않으면 된다. 
*/
public class Main_B_15652_N과M_4 {
	
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		sb = new StringBuilder();
		
		String inputNM [] = in.readLine().split(" ");
		N = Integer.parseInt(inputNM[0]);
		M = Integer.parseInt(inputNM[1]);
		
		combination(1, 0, new int [M]);
		System.out.println(sb);
	}
	
	private static void combination(int start, int r, int[] numbers) {
		if(r == M) {
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			for(int i = start; i <= N; i++) {
				numbers[r] = i;
				combination(i, r + 1, numbers);
			}
		}
	}

	static String src = "4 2";
}
