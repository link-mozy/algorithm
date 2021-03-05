package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

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
			parent[row] = row;
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
				if(city[row][col]) uninon(row, col);
			}
		}
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

	static class City {
		int left;
		int right;
	}
		
	static String src;
}
