package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 *  @author mozy
 *  @since 2021. 2. 10.
 *  @see https://www.acmicpc.net/problem/15649
 *  @mem  63204
 *  @time 1312
 *  @caution
 *  백트래킹 문제, 순열을 구하는 문제이다.
 *  visited 배열을 만들어 방문여부를 체크하고 재귀호출한뒤 복귀했을때는 방문여부를 풀어주는 식으로 하여 백트래킹을 구현한다. 
*/
public class Main_B_15649_N과M_1 {
	
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		String numbers[] = in.readLine().split(" ");
		N = Integer.parseInt(numbers[0]);
		M = Integer.parseInt(numbers[1]);

		backtracking(0, new int [M], new boolean [N]);
	}


	private static void backtracking(int r, int[] numbers, boolean [] visited) {
		if(r == M) {
			StringBuilder sb = new StringBuilder();
			for(int number : numbers) {
				sb.append(number).append(" ");
			}
			System.out.println(sb);
			return;
			
		} else {
			for(int i = 0; i < N; i++) {
				if(visited[i]) continue;
				
				visited[i] = true;
				numbers[r] = i + 1;
				backtracking(r + 1, numbers, visited);
				
				visited[i] = false;
			}
			
		}
		
	}


	static String src = "4 2";
}
