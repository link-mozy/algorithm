package Beakjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mozy
 * @since 2022. 1. 15.
 * @see  https://www.acmicpc.net/problem/11652
 * @mem  102292 KB
 * @time 900 ms
 * @caution 
 * 정렬 응용 문제
 * 정렬의 특성 중 비슷한 값끼리 인접한다를 사용하여 문제 해결
 * 정렬 후 자신의 왼쪽(앞) 값이 랑 같을 경우 갯수를 증가하여 문제 해결
 * 주의할 점은 초기 값을 잘 넣어줘야한다는 것!
 */
public class Main_B_11652_카드_2 {

	static int N;
	static long [] cards;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		cards = new long [N];
		for(int i = 0; i < N; i++) {
			cards[i] = scanner.nextLong();
		}

		// 정렬
		Arrays.sort(cards);
		
		// solution
		long maxNum = cards[0];
		int maxCount = 1;
		int currCount = 1;
		
		for(int i = 1; i < N; i++) {
			if(cards[i-1] == cards[i]) {
				currCount++;
			} else {
				currCount = 1;
			}
			if(maxCount < currCount) {
				maxCount = currCount;
				maxNum = cards[i];
			}
		}
		
		System.out.println(maxNum);
	}
	
	// 예제 입력 1
//	5
//	1
//	2
//	1
//	2
//	1
}
