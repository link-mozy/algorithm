package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2022. 5. 26.
 * @see  https://www.acmicpc.net/problem/11728
 * @mem  323896 KB
 * @time 1164 ms
 * @caution
 * 두 포인터 문제.
 * 소룰션 보고 문제를 풀었다. 단순하게 두 배열의 값을 비교해서 넣으면 문제를 해결 할 수 있다.
 */
public class Main_B_11728_배열합치기 {

	static int N, M;
	static int [] array_a, array_b;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		init();
		proc();
	}

	private static void proc() {
		int L = 1, R = 1;
		while(L <= N && R <= M) {
			if(array_a[L] <= array_b[R]) sb.append(array_a[L++]).append(" ");
			else sb.append(array_b[R++]).append(" ");
		}
		
		while(L <= N) sb.append(array_a[L++]).append(" ");
		while(R <= M) sb.append(array_b[R++]).append(" ");
        
        System.out.println(sb);
	}

	private static void init() {
		try {
			sb = new StringBuilder();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			in = new BufferedReader(new StringReader(src));
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			array_a = new int [N + 1];
			array_b = new int [M + 1];
			
			st = new StringTokenizer(in.readLine());
			for(int i = 1; i <= N; i++) {
				array_a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(in.readLine());
			for(int i = 1; i <= M; i++) {
				array_b[i] = Integer.parseInt(st.nextToken());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	static String src = "4 3\r\n"
			+ "2 3 5 9\r\n"
			+ "1 4 7";
}
