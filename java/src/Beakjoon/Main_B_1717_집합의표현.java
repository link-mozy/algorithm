package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_B_1717_집합의표현 {

	static int numberGraph [];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		numberGraph = new int [n + 1];
		
		for(int i = 0; i < n+1; i++) numberGraph[i] = i;
		
		for(int i = 0; i < m; i++) {
			String line[] = in.readLine().split(" ");
			int a = Integer.parseInt(line[1]);
			int b = Integer.parseInt(line[2]);
			
			if("0".equals(line[0])) {
				// 합집합 연산
				union(a, b);
			} else {
				// 포함 여부 연산
				if(find(a) == find(b))	sb.append("YSE").append("\n");
				else					sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static int find(int number) {
		if(number == numberGraph[number]) {
			return number;
		} else {
			return find(numberGraph[number]);
		}
	}
	
	static void union(int number1, int number2) {
		number1 = find(number1);
		number2 = find(number2);
		
		if(number1 != number2)	numberGraph[number2] = number1;
	}
	
	static String src = "3 3\n" + 
			"0 1 2\n" + 
			"0 1 3\n" + 
			"1 2 3";
}
