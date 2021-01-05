package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

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
			
			dfs(T, 0);
			if(min == Integer.MAX_VALUE) min = -1;
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
			dfs(t / B, cnt + 1);
			dfs(t - A, cnt + 1);
		} else {
			dfs(t - A, cnt + 1);
		}
	}

	static String src = "5\n" + 
			"10 40 4 2\n" + 
			"10 28 4 2\n" + 
			"10 99 4 2\n" + 
			"10 104 4 2\n" + 
			"10 24 4 2";
}
