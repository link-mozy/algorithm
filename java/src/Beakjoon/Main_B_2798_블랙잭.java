package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 3. 8.
 *  @see 
 *  @mem 
 *  @time 
 *  @caution
 *  부르트포스 문제. 조합 사용.
*/
public class Main_B_2798_블랙잭 {

	static int N, M, result;
	static int numberArr [];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numberArr = new int [N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) numberArr[i] = Integer.parseInt(st.nextToken());
		
		result = 0;
		combination(0, 0, 0);
		
		System.out.println(result);
	}
	
	private static void combination(int r, int start, int sum) {
		if(r == 3) {
			if(Math.abs(M - sum) < Math.abs(M - result)) result = sum;
			return;
		} else {
			
			for(int i = start; i < N; i++) {
				sum += numberArr[i];
				combination(r + 1, i + 1, sum);
				sum -= numberArr[i];
			}
		}
	}

	static String src = "5 13\n" + 
			"1 6 5 3 4";
}
