package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 6.
 *  @see 
 *  @mem 
 *  @time 
 *  @caution
 *  Fail (Runtime error)
 *  메모리 초과, 해결 못함. 
*/
public class Solution_7194_화섭이의미생물배양_DFS {

	static int S, T, A, B;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			S = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			
			if(B == 1) {
				int tmp = T - S;
				if(tmp % A == 0) {
					min = tmp / A;
				} else {
					min = -1;
				}
			} else {
				dfs(T, 0);
				if(min == Integer.MAX_VALUE) min = -1;
			}
			sb.append("#" + tc + " " + min).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(int t, int cnt) {
		if(t == S) {
			if(cnt < min) min = cnt;
			return;
		}
		if(t < S) {
			return;
		}
		if(t%B == 0) {
			if(t / B >= S) dfs(t / B, cnt + 1);
			if(t - A >= S) dfs(t - A, cnt + 1);
		} else {
			dfs(t - A, cnt + 1);
		}
	}

	static String src = "6\n" + 
			"10 40 4 2\n" + 
			"10 28 4 2\n" + 
			"10 99 4 2\n" + 
			"10 104 4 2\n" + 
			"10 24 4 2\n" + 
			"10 13 2 1";
}
