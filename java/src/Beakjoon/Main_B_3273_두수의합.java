package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2022. 1. 26.
 *  @see  https://www.acmicpc.net/problem/3273
 *  @mem  26028 KB
 *  @time 308 ms
 *  @caution 
 *  이진 탐색 알고리즘
 *  꼭 이진 탐색 알고리즘을 사용 할 필요는 없지만, 사용했을 경우 적은 시간 사용.
 *  문제에서 i가 j보다 작다는 조건 추가
*/
public class Main_B_3273_두수의합 {
	
	static int N, X;
	static int [] a;

	public static void main(String[] args) {
		input();
		pro();
	}

	private static void pro() {
		int answer = 0;
		// sorting
		Arrays.sort(a, 1, N+1);
		
		for(int i = 1; i <= N; i++) {
			boolean finded = find(a[i], i, 1, N);
			if(finded) answer++;
		}
		System.out.println(answer);
	}

	private static boolean find(int a_i, int i,int left, int right) {
		while(left <= right) {
			int mid = (left + right) / 2;
			int temp = a_i + a[mid];
			if( temp == X && i < mid) {
				return true;
			}
			if( temp < X ) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			N = Integer.parseInt(br.readLine());
			a = new int [N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			X = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	static String src = "9\r\n"
			+ "5 12 7 10 9 1 2 3 11\r\n"
			+ "13";
}
