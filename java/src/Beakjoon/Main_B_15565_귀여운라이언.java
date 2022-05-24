package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2022. 5. 24.
 * @see  https://www.acmicpc.net/problem/15565
 * @mem  76600 KB
 * @time 352 ms
 * @caution
 * 두 포인터 문제.
 * 왼쪽 포인터와 오른쪽 포인터를 만들어 계산.
 * 오른쪽 포인터 증가 시킬때, 라이언의 총 개수 비교값이 K 값 보다 작다고 해야 함.
 * 그래야 K 값을 비교 할 수 있음.
 */
public class Main_B_15565_귀여운라이언 {

	static int N, K;
	static int [] A; // A : array
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int [N + 1];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		proc();
	}
	
	private static void proc() {
		int R = 0, cnt = 0, ans = 10000001;
		
		for(int L = 1; L <= N; L++) {
			if(A[L - 1] == 1 && cnt > -1) {
				cnt--;
			}
			
			while(R + 1 <= N && cnt < K) {
				R++;
				if(A[R] == 1) {
					cnt++;
				}
			}
			
			if(cnt >= K) {
				ans = Math.min(ans, (R - L) + 1);
			}
		}
		
		if(ans == 10000001) ans = -1;
		
		System.out.println(ans);
	}

	static String src = "10 3\r\n"
			+ "1 2 2 2 1 2 1 2 2 1";
}
