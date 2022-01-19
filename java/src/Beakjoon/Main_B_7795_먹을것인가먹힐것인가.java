package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2022. 1. 20.
 *  @see  https://www.acmicpc.net/problem/7795
 *  @mem  38432 KB
 *  @time 356 ms
 *  @caution
 *  이분 탐색 문제.
 *  이분 탐색의 정형화된 코드 패턴을 알아 두자.
 *  이분 탐색을 하기 위해서는 사전의 탐색하려는 배열이 정렬 되어야 한다.
 *  Arrays.sort 로 정렬 시 마지막 인덱스를 넣을때, 배열의 크기가 마지막 인덱스까지 정렬 함.
*/
public class Main_B_7795_먹을것인가먹힐것인가 {

	static int N, M;
	static int [] A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int [N + 1];
			B = new int [M + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			pro();
		}
	}

	private static void pro() {
		int ans = 0;
		// TODO B 배열 정렬
		Arrays.sort(B, 1, M + 1);
		
		// TODO A 배열의 값으로 B배열의 먹을 수 있는 값 검색
		for(int i = 1; i <= N; i++) {
			ans += binarySearch(B, 1, M, A[i]);
		}
		
		// TODO 정답 호출
		System.out.println(ans);
	}

	private static int binarySearch(int[] array, int L, int R, int X) {
		// TODO array[L...R]에서 X 미만의 수(X 보다 작은 수) 중 제일 오른쪽 인덱스를 return 하는 함수
		// 그런 게 없다면 L - 1 을 return 한다.
		int result = L - 1;
		
		while(L <= R) {
			int mid = (L + R) / 2;
			if( array[mid] < X) {
				result = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return result;
	}

	static String src = "2\n" + 
			"5 3\n" + 
			"8 1 7 3 1\n" + 
			"3 6 1\n" + 
			"3 4\n" + 
			"2 13 7\n" + 
			"103 11 290 215";
}
