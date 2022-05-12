package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2022. 5. 12.
 * @see  https://www.acmicpc.net/problem/2003
 * @mem  14352 KB
 * @time 112 ms
 * @caution
 * 투 포인트를 사용하여 문제 해결
 * 투 포인트에서 주의할 점은 처음에 왼쪽 값을 지워주는 것을 잊지 말자!
 */

public class Main_B_2003_수들의합2 {

	static int N, M;
	static int array[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N + 1];

		st = new StringTokenizer(in.readLine());

		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		solution();
	}

	private static void solution() {
		int R = 0, sum = 0, ans = 0;

		for (int L = 1; L <= N; L++) {
			sum -= array[L - 1];
			
			while(R + 1 <= N && sum < M) {
				R++;
				sum += array[R];
			}
			
			if(sum == M) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

	static String src = "4 2\r\n"
			+ "1 1 1 1";
}
