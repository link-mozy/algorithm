package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 6.
 *  @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq
 *  @mem  18872 
 *  @time 118
 *  @caution 
 *  DFS를 수영장 요금 종류에 맞게 실행한다.
*/
public class Solution_1952_수영장_DFS {
	
	static int fee[], days[];
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			fee = new int [4];
			days = new int [12];
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0; i < 4; i++) fee[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0; i < 12; i++) days[i] = Integer.parseInt(st.nextToken());
			
			dfs(0, 0);
			sb.append("#" + tc + " " + min).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(int pay, int start) {
		if(start > 12) return;
		if(start == 12) {
			if(pay < min) min = pay;
			return;
		} else {
			// fee[3]
			if(start == 0) dfs(pay + fee[3], start + 12);

			if(days[start] > 0) {
				// fee[2]
				int cnt = 0;
				for(int month = start; month < 12 && cnt < 3; cnt++, month++) {
				}
				dfs(pay + fee[2], start + cnt);
				// fee[1]
				dfs(pay + fee[1], start + 1);
				// fee[0]
				dfs(pay + (fee[0] * days[start]), start + 1);
			} else {
				dfs(pay, start + 1);
			}
		}
	}

	static String src = "10\n" + 
			"10 40 100 300\n" + 
			"0 0 2 9 1 5 0 0 0 0 0 0\n" + 
			"10 100 50 300\n" + 
			"0 0 0 0 0 0 0 0 6 2 7 8\n" + 
			"10 70 180 400\n" + 
			"6 9 7 7 7 5 5 0 0 0 0 0\n" + 
			"10 70 200 550\n" + 
			"0 0 0 0 8 9 6 9 6 9 8 6\n" + 
			"10 80 200 550\n" + 
			"0 8 9 15 1 13 2 4 9 0 0 0\n" + 
			"10 130 360 1200\n" + 
			"0 0 0 15 14 11 15 13 12 15 10 15\n" + 
			"10 180 520 1900\n" + 
			"0 18 16 16 19 19 18 18 15 16 17 16\n" + 
			"10 100 200 1060\n" + 
			"12 9 11 13 11 8 6 12 8 7 15 6\n" + 
			"10 170 500 1980\n" + 
			"19 18 18 17 15 19 19 16 19 15 17 18\n" + 
			"10 200 580 2320\n" + 
			"12 28 24 24 29 25 23 26 26 28 27 22";
	
}
