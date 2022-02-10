package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2022. 2. 10.
 *  @see  https://www.acmicpc.net/problem/2110
 *  @mem  27812 KB
 *  @time 276 ms
 *  @caution 
 *  parametric search 알고리즘 사용.
 *  determination 함수를 만들때 개수가 입력받은 공유기 개수보다 많을 수 있다라고 해야한다.
 *  이유는 D의 최대값을 구하는 문제이므로 공유기의 거리가 짧아서 여러대를 설치하는 것에서 최대값을 구하는 것이기 때문이다.
 *  강사님 코드 보고 문제를 풀었다. 꼭 다시 풀어볼 문제이다.
*/

public class Main_B_2110_공유기설치 {
	// 1. 주어진 집들을 정렬하기 => O(N log N)
	// 2. D를 정해서 결정 문제 한 번 풀기 => O(N)
	// 3. 정답의 범위를 이분 탐색하면서 풀기 => O(log X)번 반복할 것
	// 4. 총 시간 복잡도: O(N log N + N log X) 'N log X = 10억'

	static int N, C;
	static int [] X;
	
	public static void main(String[] args) {
		input();
		pro();
	}
	
	private static boolean determination(int D) {
		// D 만큼의 거리 차이를 둔다면 C 개 만큼의 공유기를 설치할 수 있는가?
		
		// 제일 왼쪽 집부터 가능한 많이 설치해보자!
		// D 만큼의 거리를 두면서 최대로 설치한 개수와 C를 비교하자.
		int cnt = 1, last = X[1];
		for(int i = 2; i <= N; i++) {
			// 이번에 X[i]에 설치가 가능한가?
			if(X[i] - last >= D) {
				cnt++;
				last = X[i];
			}
		}
		return cnt >= C;
	}

	private static void pro() {
		Arrays.sort(X, 1, N + 1);
		
		int left = 1, right = 1000000000, ans = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(determination(mid)) {
				ans = mid;
				// 가장 큰 YES를 찾고 싶으므로, left를 당겨 준다.
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}

	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			X = new int [N + 1];
			for(int i = 1; i <= N; i++) {
				X[i] = Integer.parseInt(br.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String src = "5 3\n" + 
			"1\n" + 
			"2\n" + 
			"8\n" + 
			"4\n" + 
			"9";
}
