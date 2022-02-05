package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2022. 2. 5.
 * @see  https://www.acmicpc.net/problem/10816
 * @mem  184460 KB
 * @time 1164 ms
 * @caution 
 * 이분탐색 알고리즘.
 * 이분탐색을 같은 값의 가장 오른쪽, 왼쪽을 각각 찾아 해결하는 문제.
 * 포인트, 같은 값의 가장 왼쪽을 찾을 때는 if( number <= cards[mid] )
 * 가장 오른쪽을 찾을 때는 if( number < cards[mid] )
 * 꼭 기억 해두자.
 */
public class Main_B_10816_숫자카드2 {

	static int N, M;
	static int [] cards, numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		input();
		proc();
	}

	private static void proc() {
		Arrays.sort(cards, 1, N + 1);
		
		for(int i = 0; i < M; i++) {
			int lower = lowerBound(1, N, numbers[i]);
			int uppper = upperBound(1, N, numbers[i]);
			sb.append((uppper - lower)).append(" ");
		}
		
		System.out.println(sb);
	}

	private static int lowerBound(int left, int right, int number) {
		int answer = right + 1;
		while( left <= right ) {
			int mid = (left + right) / 2;
			if( number <= cards[mid] ) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}

	private static int upperBound(int left, int right, int number) {
		int answer = right + 1;
		while( left <= right ) {
			int mid = (left + right) / 2;
			if( number < cards[mid] ) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}

	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			StringTokenizer st;
			N = Integer.parseInt(br.readLine());
			cards = new int [N + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			numbers = new int [M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String src = "10\n"
			+ "6 3 2 10 10 10 -10 -10 7 3\n"
			+ "8\n"
			+ "10 9 -5 2 3 4 5 -10";
}
