package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 3. 7.
 *  @see  https://www.acmicpc.net/problem/1976
 *  @mem  15312
 *  @time 128
 *  @caution 
 *  union-find 알고리즘.
 *  연결되어있을때 union하고 route(계횐한 경로)를 갈때 연결되어있는지 확인한다.
*/
public class Main_B_1976_여행가자_review {
	
	static int parent [];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		parent = new int [N + 1];
		for(int i = 1; i <= N; i++) parent[i] = i;
		
		for(int row = 1; row <= N; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int col = 1; col <= N; col++) {
				if("1".equals(st.nextToken())) union(row, col);
			}
		}
		
		int route [] = new int [M];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < M; i++) route[i] = Integer.parseInt(st.nextToken());
		
		int firstPoint = find(route[0]);
		boolean resultFlag = true;
		for(int i = 1; i < M; i++) {
			if(firstPoint != find(route[i])) {
				resultFlag = false;
				break;
			}
		}
		
		System.out.println((resultFlag)? "YES" : "NO");
	}
	
	private static void union(int number1, int number2) {
		number1 = find(number1);
		number2 = find(number2);
		
		if(number1 != number2) parent[number2] = number1;
	}

	private static int find(int number) {
		if(number == parent[number]) return number;
		else return parent[number] = find(parent[number]);
	}

	static String src = "3\n" + 
			"3\n" + 
			"0 1 0\n" + 
			"1 0 1\n" + 
			"0 1 0\n" + 
			"1 2 3";
}
