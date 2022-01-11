package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2021. 10. 22.
 * @see  https://www.acmicpc.net/problem/1182
 * @mem  11508 KB
 * @time 92 ms
 * @caution 
 * 백트래킹 문제
 * 진부분집합이므로, 아무것도 선택안했을때 S==0
 */
public class Main_B_1186_부분수열의합 {

	static int N, S, ans;
	static int [] nums;
	
	public static void main(String[] args) {
		input();
		rec_func(1, 0);
		// S == 0 이라면
		if(S == 0) {
			ans--; // 공집합도 추가
		}
		System.out.println(ans);
	}

	private static void rec_func(int k, int value) {
		if(k == N + 1) {
			if(S == value) {
				ans++;
			}
		} else {
			// k 번째 원소를 더하며 재귀함수 호출
			rec_func(k + 1, value + nums[k]);
			rec_func(k + 1, value);
		}
	}

	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			nums = new int [N + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String src = "5 0\n"
			+ "-7 -3 -2 5 8";
}
