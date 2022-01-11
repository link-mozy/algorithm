package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2021. 10. 16.
 * @see  https://www.acmicpc.net/problem/14888
 * @mem  13288 KB
 * @time 100 ms
 * @caution 
 */
public class Main_B_14888_연산자끼워넣기 {

	static int N, max, min;
	static int [] nArr, oArr, other;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		input();
		rec_func(1);
		
		sb.append(max).append("\n").append(min);
		System.out.println(sb.toString());
	}
	
	static int calcurator() {
		int value = nArr[1];
		for(int i = 1; i <= N-1; i++) {
			if(other[i] == 1) value = value + nArr[i + 1];
			else if(other[i] == 2) value = value - nArr[i + 1];
			else if(other[i] == 3) value = value * nArr[i + 1];
			else if(other[i] == 4) value = value / nArr[i + 1];
		}
		
		return value;
	}

	private static void rec_func(int k) {
		if (k == N) {
			int value = calcurator();
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			for(int i = 1; i <= 4; i++) {
				if (oArr[i] > 0) {
					other[k] = i;
					oArr[i]--;
					rec_func(k + 1);
					other[k] = 0;
					oArr[i]++;
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		// 초기값 세팅
		N = Integer.parseInt(br.readLine());
		nArr = new int [N + 1];
		oArr = new int [5]; // 4 + 1
		other = new int [N];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		// An 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) nArr[i] = Integer.parseInt(st.nextToken());
		// 연산자 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 4; i++) oArr[i] = Integer.parseInt(st.nextToken());
	}
	
	static String src = "2\n"
			+ "5 6\n"
			+ "0 0 1 0";
}
