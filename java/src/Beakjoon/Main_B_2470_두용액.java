package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2022. 2. 8.
 *  @see  https://www.acmicpc.net/problem/2470
 *  @mem  31236 KB
 *  @time 312 ms
 *  @caution 
 *  이분 탐색 알고리즘.
 *  강사님 풀이를 보고 푼 문제.
 *  기준이는 되는 용액의 -1 을 곱한 값과 가장 가까운 값을 찾으면 되는 문제.
 *  찾은 값과 바로직전이 가장 가까운 값이기 때문에 비교를 할때, if(... && Math.abs(array[candidate - 1] + array[idx] < min)과
 *  if(... && Math.abs(array[candidate] + array[idx] < min) 을 해줘야한다.
 *  나중에 다시 꼭 풀어봐야할 문제!
*/
public class Main_B_2470_두용액 {

	static int N;
	static int [] array;
	
	public static void main(String[] args) {
		input();
		proc();
	}

	private static void proc() {
		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		
		Arrays.sort(array, 1, N + 1);
		
		for(int idx = 1; idx <= N - 1; idx++) {
			// array[i] 용액을 사용. 고로 -array[i] 와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾자.
			int candidate = lowerBound(idx + 1, N, -array[idx]);
			
			// array[candidate - 1] 와 array[candidate] 중에 array[i] 와 섞었을 땡의 정보를 정답에 갱신한다.
			if( idx + 1 <= candidate - 1 
			&& candidate - 1 <= N 
			&& Math.abs(array[candidate - 1] + array[idx]) < min) {
				min = Math.abs(array[candidate - 1] + array[idx]);
				left = array[idx];
				right = array[candidate - 1];
			}
			
			if( idx + 1 <= candidate
					&& candidate <= N 
					&& Math.abs(array[candidate] + array[idx]) < min) {
				min = Math.abs(array[candidate] + array[idx]);
				left = array[idx];
				right = array[candidate];
			}
		}
		
		System.out.println(left + " " + right);
	}

	private static int lowerBound(int left, int right, int X) {
		int result = right + 1;
		
		while(left <= right) {
			int mid = (right + left) / 2;
			if( X <= array[mid] ) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}

	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			N = Integer.parseInt(br.readLine());
			array = new int [N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String src = "5\n" + 
			"-2 4 -99 -1 98";
}
