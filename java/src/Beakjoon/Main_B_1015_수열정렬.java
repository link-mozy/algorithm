package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2022. 1. 11.
 * @see  https://www.acmicpc.net/problem/1015
 * @mem  11656 KB
 * @time 76 ms
 * @caution
 * 정렬 참고(tim sort에 대해 알아보자): https://d2.naver.com/helloworld/0315536
 * 정렬 문제, 숫자와 인덱스를 가지는 객체를 만들고 객체의 배열을 만든다.
 * 배열을 객체의 숫자로 정렬을 한뒤 인덱스의 위치를 가지고 순서를 갖는 배열을 다시 만든다. 
 */

public class Main_B_1015_수열정렬 {

	static int N;
	static int [] P;
	static Elem [] A;
	
	static class Elem implements Comparable<Elem>{
		int idx, number;

		@Override
		public int compareTo(Elem other) {
//			if (this.number != other.number) return this.number - other.number;
//			return this.idx - other.idx;
			// 자바는 오브젝트 Sort(정렬)는 Timsort 이고
			// Timsort는 stable sort이다.
			// 따라서 위의 코드를 다음과 같이 수정 할 수 있다.
			return this.number - other.number;
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(str));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new Elem [N];
		P = new int [N];
		for(int i = 0; i < N; i++) {
			A[i] = new Elem();
			// 배열에 알맞은 값 넣어주기
			A[i].idx = i;
			A[i].number = Integer.parseInt(st.nextToken());
		}
		
		// 자바 배열 객체의 정렬 함수 사용
		Arrays.sort(A);
		
		// A배열의 값을 이용해 P배열 만들기
		for(int a_idx = 0; a_idx < N; a_idx++) {
			P[A[a_idx].idx] = a_idx;
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(P[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	static String str = "3\n"
			+ "2 3 1";
}
