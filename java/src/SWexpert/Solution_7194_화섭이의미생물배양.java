package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 6.
 *  @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWksRe4KARQDFAVE
 *  @mem  16,076 kb
 *  @time 98 ms
 *  @caution
 *  DFS로 풀려고했으나, 메모리 초과로 루프를 사용하여 문제 해결
*/
public class Solution_7194_화섭이의미생물배양 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int day = 0;
			
			if(b == 1) {
				int tmp = t - s;
				if(tmp % a == 0) {
					day = tmp / a;
				} else {
					day = -1;
				}
				sb.append(day + "\n");
				continue;
			}
			
			while(s != t) {
				if(t % b == 0) {
					if(t/b < s) {
						day++;
						t -= a;
					} else {
						day++;
						t /= b;
					}
				} else {
					day++;
					t -= a;
				}
				if(s > t) {
					day = -1;
					break;
				}
			}
			
			sb.append(day + "\n");
		} // tc loop
		
		System.out.println(sb);
	}
	
	static String src = "6\n" + 
			"10 40 4 2\n" + 
			"10 28 4 2\n" + 
			"10 99 4 2\n" + 
			"10 104 4 2\n" + 
			"10 24 4 2\n" + 
			"10 13 2 1";
}
