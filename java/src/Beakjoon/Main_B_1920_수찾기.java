package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2022. 1. 24.
 *  @see  https://www.acmicpc.net/problem/1920
 *  @mem  60332 KB
 *  @time 648 ms
 *  @caution 
 *  이진 탐색 알고리즘 문제
 *  존재 유무만 알면 되기 때문에 빨리 찾는게 가장 중요한 문제
 *  N의 최대값 100,000
 *  M의 최대값 100,000
 *  100,000 * 100,000 = 10,000,000,000
 *  1초를 넘기므로 일반 반복문으로하면 시간 초과이기 때문
*/
public class Main_B_1920_수찾기 {

	static int N, M;
	static int [] A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = new int [N + 1];
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		B = new int [M];
		for(int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
	}
	
	private static void pro() {
		StringBuilder sb = new StringBuilder();
		
		Arrays.sort(A, 1, N+1);
		
		for(int idx = 0; idx < M; idx++) {
			boolean finded = treeSearch(B[idx], 1, N);
			sb.append( (finded)? 1 : 0).append("\n");
		}
		
		System.out.println(sb);
	}

	private static boolean treeSearch(int mode, int left, int right) {
		while(left <= right) {
			int mid = (left + right) / 2;
			if(mode == A[mid]) return true;
			if( A[mid] <= mode ) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return false;
	}

	static String src = "5\n" + 
			"4 1 5 2 3\n" + 
			"5\n" + 
			"1 3 7 9 5";
}
