package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2022. 2. 8.
 *  @see  https://www.acmicpc.net/problem/2805
 *  @mem  168228 KB
 *  @time 492 ms
 *  @caution
 *  Parametric Search (매개 변수 탐색) 알고리즘 사용.
 *  문제. 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이(H)의 최댓값을 구하시오.
 *  접근 - 매개 변수 만들어 보기
 *  어떤 높이(H)로 잘랐을 때, 원하는 길이 M만큼을 얻을 수 있는가? Yes / No
 *  그리고, 문제 풀이에 사용되는 높이 값은 나무 수(N) * 나무의 길이(M) 을 최대값을 확인해야한다.
 *  최대값은 1,000,000 * 2,000,000,000 이므로 int를 사용할 수 없으므로, long을 사용한다.
 *  강사님 수업 듣고 푼 문제. - 매개 변수 탐색 알고리즘 핵심!
 *  1. 정답을 "매개 변수"로 만들고 `Yes/No`문제(결정문제)로 바꾸기
 *  2. 모든 값에 대해서 `Yes/No`를 채웠다고 생각했을 때, 정렬된 상태인지 확인 하기
 *  3. `Yes/No` 결정하는 문제로 풀기
 *  우선 문제를 매개 변수로 만들기도 잘안되고 매개 변수로 만들더라도 결정하는 알고리즘을 혼자서 구현하기 어려움...
 *  매개 변수 탐색 유형의 문제를 많이 풀어야된다고 한다...
*/
public class Main_B_2805_나무자르기 {

	static int N, M, right;
	static int [] tree;
	
	public static void main(String[] args) {
		input();
		proc();
	}

	private static void proc() {
		int left = 0;
		long ans = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(determination(mid)) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}

	private static boolean determination(int H) {
		long sum = 0;
		for(int i = 1; i <= N; i++) {
			if(tree[i] > H) {
				sum += ( tree[i] - H );
			}
		}
		return sum >= M;
	}

	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			tree = new int [N + 1];
			right = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				if(right < tree[i]) {
					right = tree[i];
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String src = "4 7\n" + 
			"20 15 10 17";
}
