package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2022. 5. 10.
 * @see  https://www.acmicpc.net/problem/1806
 * @mem  23044 KB
 * @time 224 ms
 * @caution
 * 투 포인터 문제, 왼쪽 포인터와 오른쪽 포인터를 만들어 중복으로 검사하는 것을 줄일 수 있다.
 */
public class Main_B_1806_부분합 {
	
	static int N, S;
	static int array [];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		array = new int [N + 1];
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		solution();
	}
	
	private static void solution() {
		int R = 0, sum = 0, ans = N + 1;
		
		for(int L = 1; L <= N; L++) {
			// L - 1 을 구간에서 제외하기
			sum -= array[L - 1];
			
			// R 을 옮길 수 있을 때 까지 옮기기
			while((R+1) <= N && sum < S) {
				R++;
				sum += array[R];
			}
			
			// [L ... R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
			if(sum >= S) {
				ans = Math.min(ans, (R - L + 1));
			}
		}
		
		// ans 값을 보고 불가능 판단하기
		if(ans == N + 1) {
			ans = 0;
		}
		
		System.out.println(ans);
	}

	static String src = "10 15\r\n"
			+ "5 1 3 5 10 7 4 9 2 8";
}
