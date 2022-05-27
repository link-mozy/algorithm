package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2022. 5. 27.
 * @see  https://www.acmicpc.net/problem/2230
 * @mem  22780 KB
 * @time 268 ms
 * @caution
 * 두 포인터 문제.
 * 두 값을 비교하면서 기준 값보다 크면서 가장 작은 값을 찾으면 되는 문제.
 * while에서 A[R] - A[L] 값을 비교값으로 사용하기 때문에 꼭 R을 1부터 시작해준다.
 * (내가 의도치 않은 곳에서 while이 돌지 않는것같다...)
 */

public class Main_B_2230_수고르기 {

	static int N, M;
	static int [] A;
	
	public static void main(String[] args) {
		init();
		proc();
	}

	private static void proc() {
		int R = 1, ans = Integer.MAX_VALUE;
		// 정열
		Arrays.sort(A, 1, N + 1);
		
		for(int L = 1; L <= N; L++) {
			
			while((R + 1) <= N && (A[R] - A[L]) < M) {
				++R;
			}
			
			if((A[R] - A[L]) >= M) {
				ans = Math.min(ans, (A[R] - A[L]));
			}
		}
		
		System.out.println(ans);
	}

	private static void init() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			in = new BufferedReader(new StringReader(src));
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int [N + 1];
			
			for(int i = 1; i <= N; i++) {
				A[i] = Integer.parseInt(in.readLine()); 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	static String src = "5 6\r\n"
			+ "1\r\n"
			+ "2\r\n"
			+ "3\r\n"
			+ "4\r\n"
			+ "11";
}
