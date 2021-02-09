package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 10.
 *  @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD
 *  @mem  19,168 
 *  @time 112
 *  @caution 
 *  완탐, 가지치기
 *  만들었던 숫자는 가지쳐주는 것이 핵심
 *  완탐할때, 모든 경우의 수를 만들어야하는데...
 *  아직도 좀 헷갈리는것이 한번 바꿨던 자리를 또 가도되는줄 알았는데... 그렇게 하면 안된다고한다.
 *  문제를 잘못 이해했나보다...
*/
public class Solution_1244_최대상금 {

	static Set<Integer> visitedNumber;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			visitedNumber = new HashSet<Integer>();
			max = -1;
			
			String number = st.nextToken();
			int numbers[] = new int [number.length()];
			for(int i = 0; i < numbers.length; i++) numbers[i] = number.charAt(i) - '0';
			int count = Integer.parseInt(st.nextToken());

			findMaxNumber(numbers, count);

			sb.append("#" + tc + " " + max).append("\n");
		} // test case loop
		
		System.out.println(sb);
	}
	
	private static void findMaxNumber(int[] numbers, int count) {
		int number = 0;
		int j = 1;
		
		for(int i = numbers.length - 1; i >= 0; i--) {
			number += numbers[i] * j;
			j *= 10;
		}

		int visited = number + (count * j);
		if(visitedNumber.contains(visited)) {
			// 만들었던 숫자는 방문했었기 때문에 탈출
			return;
		} else {
			visitedNumber.add(visited);
		}
		
		if(count == 0) {
			// 꼭 카운트를 다 사용해야지 비교할수있다.
			if(number > max) max = number;
		} else {
			// 모든 경우의 수를 구한다.
			for(int x = 0; x < numbers.length - 1; x++) {
				for(int y = x + 1; y < numbers.length; y++) {
					// swap
					int temp = numbers[x];
					numbers[x] = numbers[y];
					numbers[y] = temp;
					
					findMaxNumber(numbers, count - 1);
					
					// swap
					temp = numbers[x];
					numbers[x] = numbers[y];
					numbers[y] = temp;
				}
			}
		}
		
	}

	static String src = "1\n" + 
			"4321 1";
}
