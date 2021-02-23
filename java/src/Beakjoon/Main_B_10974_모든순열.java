package Beakjoon;

import java.util.Scanner;

/**
 *  @author mozy
 *  @since 2021. 2. 23.
 *  @see  https://www.acmicpc.net/problem/10974
 *  @mem  22984
 *  @time 240
 *  @caution 
 *  순열 문제.
*/
public class Main_B_10974_모든순열 {

	static int N;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = Integer.parseInt(sc.nextLine());
		
		permutatin(0, new int [N], new boolean [N + 1]);
		
		System.out.println(sb);
	}

	private static void permutatin(int r, int[] numberArr, boolean[] visited) {
		if(r == N) {
			for(int i = 0; i < N; i++) sb.append(numberArr[i]).append(" ");
			sb.append("\n");
			return;
		} else {
			for(int i = 1; i < N + 1; i++) {
				if(visited[i]) continue;
				visited[i] = true;
				numberArr[r] = i;
				permutatin(r + 1, numberArr, visited);
				visited[i] = false;
			}
		}
	}

}
