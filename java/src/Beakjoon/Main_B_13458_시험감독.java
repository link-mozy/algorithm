package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 12. 2.
 *  @see  https://www.acmicpc.net/problem/13458
 *  @mem  128392 KB
 *  @time 448 ms
 *  @caution 
 *  int 범위를 넘기 때문에 자료형을 long 사용 해야 함.
*/
public class Main_B_13458_시험감독 {
	
	static int A;
	static long B, C;
	static long [] room; // A의 갯수가 room 배열 크기
	static long result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		// 입력 구간
		result = 0;
		A = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		room = new long [A];
		for(int i = 0; i < A; i++) {
			room[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		// Solution
		for(int i = 0; i < A; i++) {
			// 총 감독관은 무조건 한명 필요
			result += 1;
			room[i] -= B;
			// 부 감독관 인원 구하기
			if(room[i] > 0) {
				result += Long.valueOf(room[i] / C).intValue();
				if((room[i] % C) != 0) result += 1;
			}
		}
	
		System.out.println(result);
	}
	
	static String src = "5\r\n"
			+ "10 9 10 9 10\r\n"
			+ "7 2";
}
