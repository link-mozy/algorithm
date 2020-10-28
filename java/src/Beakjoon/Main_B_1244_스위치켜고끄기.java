package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_B_1244_스위치켜고끄기 {
	
	/**
	 *  @author mozy
	 *  @since Oct 23, 2020
	 *  @see https://www.acmicpc.net/problem/1244
	 *  @mem 13076
	 *  @time 88
	 *  @caution 
	 *  남자와 여자인 경우를 구현
	 *  마지막 출력할때 20개씩 나눠서 출력하라는데, 초기화할때 0으로 하면 반복문 마지막에 플러스 되기때문에 -1 해줘야한다. (기억해야함.)
	*/
	
	static int N, T;
	static int [] switcharray;
	static int [][] students;

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		
		// 값 입력받기
		N = Integer.parseInt(in.readLine());
		switcharray = new int [N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		
		for(int i = 1; i <= N; i++) {
			switcharray[i] = Integer.parseInt(st.nextToken());
		}
		
		T = Integer.parseInt(in.readLine());
		students = new int [T][2];
		
		for(int i = 0; i < T; i++) {
			// 남학생은 1, 여학생은 2 입력 받음
			st = new StringTokenizer(in.readLine(), " ");
			students[i][0] = Integer.parseInt(st.nextToken());
			students[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		// 입력 값 확인
//		System.out.println(Arrays.toString(switcharray));
//		System.out.println(Arrays.deepToString(students));
		
		// 스위치 변환
		for(int i = 0; i < T; i++) {
			int gender = students[i][0];
			int number = students[i][1];
			if(gender == 1) {
				men(number);
			}
			else if(gender == 2) {
				women(number);
			}
		}
		
		// 결과보기
		// 한 줄에 20개씩 출력한다.
		for(int i = 1, count = 0; i <= N; i++, count++) {
			sb.append(switcharray[i]);
			if(count == 19) {
				sb.append("\n");
				count = -1;
			} else {
				sb.append(" ");
			}
		}
		System.out.println(sb);
		
	}
	
	static void men(int number) {
		for(int i = number; i <= N; i+=number) {
			int tmp = switcharray[i];
			switcharray[i] = (tmp == 0)? 1: 0;
		}
	}
	
	static void women(int number) {
		for(int start = number, end = number; start > 0 && end <= N; start--, end++) {
			if(switcharray[start] == switcharray[end]) {
				int tmp = (switcharray[start] == 0)? 1: 0;
				switcharray[start] = tmp;
				switcharray[end] = tmp;
			}
			else {
				break;
			}
		}
	}
	
	static String src = "8\n" + 
			"0 1 0 1 0 0 0 1\n" + 
			"2\n" + 
			"1 3\n" + 
			"2 3";
}
