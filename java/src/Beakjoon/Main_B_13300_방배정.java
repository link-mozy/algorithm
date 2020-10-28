package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_B_13300_방배정 {
	
	/**
	 *  @author mozy
	 *  @since Oct 23, 2020
	 *  @see https://www.acmicpc.net/problem/13300
	 *  @mem 13404
	 *  @time 92
	 *  @caution 
	 *  나누기 연산 몫, 나머지 를 활용하여 문제를 풀었다.
	*/
	
	static int N, K;
	static int [][] student;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		student = new int [7][2]; // 0: 여자, 1:남자
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			student[grade][gender]++;
		}
		
//		// 입력값 확인
//		for(int i = 1; i < 7; i++) {
//			System.out.println(Arrays.toString(student[i]));
//		}
		
		// 최소 방구하기
		for(int i = 1; i < 7; i++) {
			for(int j = 0; j < 2; j++) {
				result += (student[i][j] / K);
				result += (student[i][j]%K > 0)? 1:0;
			}
		}
		
		System.out.println(result);
	}
	
	static String src = "16 2\n" + 
			"1 1\n" + 
			"0 1\n" + 
			"1 1\n" + 
			"0 2\n" + 
			"1 2\n" + 
			"0 2\n" + 
			"0 3\n" + 
			"1 3\n" + 
			"1 4\n" + 
			"1 3\n" + 
			"1 3\n" + 
			"0 6\n" + 
			"1 5\n" + 
			"0 5\n" + 
			"1 5\n" + 
			"1 6";
}
