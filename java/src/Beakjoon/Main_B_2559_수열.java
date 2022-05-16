package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2022. 5. 16.
 * @see  https://www.acmicpc.net/problem/2559
 * @mem  22564 KB
 * @time 228 ms
 * @caution
 * 투 포인트 문제, K까지 떨어진 날짜를 R이라는 포인터로 이동시켜 최대값을 계산
 */
public class Main_B_2559_수열 {
	
	static int N, K;
	static int [] array;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new int [N + 1];
		st = new StringTokenizer(in.readLine());
		
		for(int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		solution();
		
	}
	
	private static void solution() {
		int R = 0, sum = 0, ans = -100 * N;

		for(int L = 1; L + K - 1 <= N; L++) {
			sum -= array[L - 1];
			
			while(R + 1 <= L + K -1) {
				sum += array[++R];
			}
			
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}

	static String src = "10 2\r\n"
			+ "3 -2 -4 -9 0 3 7 13 8 -3";
}
