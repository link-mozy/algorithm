package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 3. 5.
 *  @see  https://www.acmicpc.net/problem/1976
 *  @mem  16220
 *  @time 140
 *  @caution 
 *  union-find 알고리즘 응용
 *  union 하는 조건: if(city[row][col] == 1)
 *  아직도 union-find 알고리즘 문제 유형이 익숙치 않아 더 연습이 필요하다.
*/
public class Main_B_1976_여행가자 {

	static int city [][];
	static int parent [];
	static int route []; // 경로
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		city = new int [N + 1][N + 1];
		parent = new int [N + 1];
		
		for(int row = 1; row <= N; row++) {
			parent[row] = row; // make set
			st = new StringTokenizer(in.readLine(), " ");
			for(int col = 1; col <= N; col++) {
				city[row][col] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		route = new int [M];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < M; i++) route[i] = Integer.parseInt(st.nextToken());
		
		// union
		for(int row = 1; row <= N; row++) {
			for(int col = 1; col <= N; col++) {
				if(city[row][col] == 1) uninon(row, col);
			}
		}
		
		// check
		boolean result = true;
		for(int i = 1; i < M; i++) {
			if(find(route[0]) != find(route[i])) {
				result = false;
				break;
			}
		}
		System.out.println((result)? "YES" : "NO");
	}
	
	private static void uninon(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return;
		else if(a < b) parent[b] = a;
		else parent[a] = b;
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
