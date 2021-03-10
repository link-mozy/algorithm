package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 *  @author mozy
 *  @since 2021. 3. 10.
 *  @see  https://www.acmicpc.net/problem/7568
 *  @mem  11508
 *  @time 80
 *  @caution
 *  부르트포스 알고리즘 
*/
public class Main_B_7568_덩치 {
	
	static int bulk [][];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		bulk = new int [N][3]; // 0:목무게 1:키 2:등수
		
		for(int i = 0; i < N; i++) {
			String xy [] = in.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			
			bulk[i][0] = x;
			bulk[i][1] = y;
			bulk[i][2] = 1;
		} // for
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(bulk[i][0] < bulk[j][0]
				&& bulk[i][1] < bulk[j][1]) bulk[i][2]++;
			}
			sb.append(bulk[i][2]).append(" ");
		}
		
		System.out.println(sb);
	} // main
	
	static String src = "5\n" + 
			"55 185\n" + 
			"58 183\n" + 
			"88 186\n" + 
			"60 175\n" + 
			"46 155";
}
