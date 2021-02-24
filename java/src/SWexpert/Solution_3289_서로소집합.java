package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 24.
 *  @see  https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr
 *  @mem  105556
 *  @time 495
 *  @caution 
 *  union-find 문제, 그래프 만들고 재귀를 통해서 구현.
 *  아직 union-find 익숙하지 않아 연습이 필요하다.
*/
public class Solution_3289_서로소집합 {
	
	static int numberGraph [];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int TC = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			numberGraph = new int [n + 1];
			for(int i = 1; i < n + 1; i++) numberGraph[i] = i;
			
			for(int i = 0; i < m; i++) {
				// solution
				String line[] = in.readLine().split(" ");
				int a = Integer.parseInt(line[1]);
				int b = Integer.parseInt(line[2]);
				
				if("1".equals(line[0])) {	// 1: find
					if(find(a) == find(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				} else {					// 0: union-find
					union(a, b);
				}
			}
			sb.append("\n");
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
		
		if(number1 > number2) numberGraph[number1] = number2;
		else numberGraph[number2] = number1;
	}
	
	static String src = "1\n" + 
			"7 8\n" + 
			"0 1 3\n" + 
			"1 1 7\n" + 
			"0 7 6\n" + 
			"1 7 1\n" + 
			"0 3 7\n" + 
			"0 4 2\n" + 
			"0 1 1\n" + 
			"1 1 1";
}
