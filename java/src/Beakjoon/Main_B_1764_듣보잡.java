package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2022. 1. 25.
 *  @see  https://www.acmicpc.net/problem/1764
 *  @mem  23508 KB
 *  @time 232 ms
 *  @caution 
 *  이진 탐색 알고리즘.
 *  String 정렬 함수 사용 가능
 *  N, M의 최대값 500,000
 *  일반적인 반복문을 사용하여 비교하면 시간 부족 (시간 제한 2초)
*/

public class Main_B_1764_듣보잡 {

	static int N, M;
	static String [] unlistend, unwatched;
	
	public static void main(String[] args) {
		input();
		pro();
	}

	private static void pro() {
		LinkedList<String> list = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		
		Arrays.sort(unlistend, 1, N + 1);
		Arrays.sort(unwatched, 1, M + 1);

		for(int i = 1; i <= N; i++) {
			boolean finded = find(unlistend[i], 1, M);
			if(finded) list.add(unlistend[i]);
		}
		
		sb.append(list.size()).append("\n");
		while(!list.isEmpty()) {
			sb.append(list.pop()).append("\n");
		}
		
		System.out.println(sb);
	}

	private static boolean find(String name, int left, int right) {
		while(left <= right) {
			int mid = (left + right) / 2;
			int compare = name.compareTo(unwatched[mid]);
			if(compare == 0) return true;
			if(compare > 0) {
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
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			unlistend = new String[N + 1];
			unwatched = new String[M + 1];
			
			for(int i = 1; i <= N; i++) {
				unlistend[i] = br.readLine();
			}
			for(int i = 1; i <= M; i++) {
				unwatched[i] = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String src = "3 4\r\n"
			+ "ohhenrie\r\n"
			+ "charlie\r\n"
			+ "baesangwook\r\n"
			+ "obama\r\n"
			+ "baesangwook\r\n"
			+ "ohhenrie\r\n"
			+ "clinton";
}
