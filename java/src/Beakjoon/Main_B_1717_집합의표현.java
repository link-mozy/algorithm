package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 26.
 *  @see  https://www.acmicpc.net/problem/1717
 *  @mem  68692
 *  @time 1072
 *  @caution 
 *  union-find algorithm
*/
public class Main_B_1717_집합의표현 {
	
	static int parent [];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()) + 1;
		int m = Integer.parseInt(st.nextToken());
		parent = new int [n];
		
		for(int i = 0; i < n; i++) parent[i] = i;
		
		for(int i = 0; i < m; i++) {
			String line[] = in.readLine().split(" ");
			int a = Integer.parseInt(line[1]);
			int b = Integer.parseInt(line[2]);
			
			if("0".equals(line[0])) {
				union(a, b);
			} else {
				if(find(a) == find(b)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		
		System.out.println(sb);
		
	}
	
	static int find(int number) {
		if(number == parent[number]) {
			return number;
		}
		return parent[number] = find(parent[number]);
	}
	
	static void union(int number1, int number2) {
		number1 = find(number1);
		number2 = find(number2);
		
		if(find(number1) == find(number2)) {
			return;
		} else {
			parent[number1] = number2;
		}
	}
	
	static String src = "7 8\n" + 
			"0 1 3\n" + 
			"1 1 7\n" + 
			"0 7 6\n" + 
			"1 7 1\n" + 
			"0 3 7\n" + 
			"0 4 2\n" + 
			"0 1 1\n" + 
			"1 1 1";
}
