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
 * @mem  KB
 * @time ms
 * @caution
 * 이분탐색 알고리즘.
 * 시간초과로 실패. 
 */
public class Main_B_10816_숫자카드2_실패 {
	
	static int N, M;
	static int [] cards, numbers, result;
	
	public static void main(String[] args) {
		input();
		proc();
	}

	private static void proc() {
		StringBuilder sb = new StringBuilder();
		
		// 정렬
		Arrays.sort(cards, 1, N + 1);
		
		for(int i = 0; i < M; i++) {
			int count = 0;
			count = getCount(numbers[i]);
			result[i] = count;
		}
		
		for(int i = 0; i < M; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb);
	}

	private static int getCount(int number) {
		int left = 1;
		int right = N;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int midCard = cards[mid];
			if(midCard == number) {
				return checkLeftRight(mid, number);
			}
			if(midCard < number) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return 0;
	}

	private static int checkLeftRight(int index, int number) {
		int count = 1;
		// left
		int newIndex = index - 1;
		while(newIndex > 0) {
			if(number != cards[newIndex]) break;
			newIndex--;
			count++;
		}
		// right
		newIndex = index + 1;
		while(newIndex <= N) {
			if(number != cards[newIndex]) break;
			newIndex++;
			count++;
		}
		return count;
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
			result = new int [M];
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
