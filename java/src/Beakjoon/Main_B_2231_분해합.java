package Beakjoon;

import java.util.Scanner;

/**
 *  @author mozy
 *  @since 2021. 3. 09.
 *  @see  https://www.acmicpc.net/problem/2231
 *  @mem  12832
 *  @time 218
 *  @caution
 *  부르트포스, 완전탐색 문제
*/
public class Main_B_2231_분해합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = 0;
		
		for(int i = 1; i < N; i++) {
			int sumNumber = sum(i);
			if(i + sumNumber == N) {
				M = i;
				break;
			}
		} // for
		System.out.println(M);
	} // main

	private static int sum(int i) {
		int totalNumber = 0;
		while(i > 0) {
			totalNumber += (i%10);
			i /= 10;
		} // while
		return totalNumber;
	} // sum
}
