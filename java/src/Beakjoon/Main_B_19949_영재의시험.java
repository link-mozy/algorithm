package Beakjoon;

import java.util.Scanner;

/**
 *  @author mozy
 *  @since 2021. 2. 27.
 *  @see  https://www.acmicpc.net/problem/19949
 *  @mem  13464
 *  @time 284
 *  @caution 
 *  백트랙킹 문제.
 *  조건을 붙이는데, 연속된 자리의 숫자가 동일한 값이면 무시하라는 조건
 *  그리고 값을 넣을때 5(5지선답)라는 것을 주의할것.
*/
public class Main_B_19949_영재의시험 {

	static int numbers [];
	static int total;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		numbers = new int [10];
		total = 0;
		
		for(int i = 0; i < 10; i++) numbers[i] = sc.nextInt();
		
		backtracking(0, new int [10]);
		
		System.out.println(total);
	}
	
	private static void backtracking(int r, int[] numberArr) {
		if(r == 10) {
			int score = 0;
			for(int i = 0; i < 10; i++) if(numberArr[i] == numbers[i]) score++;
			if(5 <= score) total++;
			return;
		} else {
			for(int i = 0; i < 5; i++) {
				int number = i + 1;
				if(r > 1 
					&& number == numberArr[r - 1] 
					&& number == numberArr[r - 2]) {
					continue;
				}
				numberArr[r] = number;
				backtracking(r + 1, numberArr);
			}
		}
	}

}
