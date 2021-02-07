package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * 복습, 조합과 배열의 활용 문제.
 * 조합을 통해 선택과 비선택으로 구분하고, 선택한 부분은 양수, 선택하지 않은 부분은 음수라는 컨셉을 도출하는 것이 문제의 중요 포인트
 * 조합, 구현을 복습하는 문제였다.
*/
public class Solution_1494_사랑의카운슬러_review {
	
	static int N;
	static int arr[][];
	static long min;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int [N][2];
			min = Long.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, N/2, new boolean [N]);
			sb.append("#" + tc + " " + min).append("\n");
		} // test case loop
		
		System.out.println(sb);
	}
	
	private static void combination(int start, int r, boolean[] visited) {
		if(r == 0) {
			long x = 0;
			long y = 0;
			
			// 좌표의 벡터 연산
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					// +
					x += arr[i][0];
					y += arr[i][1];
				} else {
					// -
					x -= arr[i][0];
					y -= arr[i][1];
				}
			}
			
			// 최솟값 비교
			min = Math.min(min, (x*x + y*y));
			
			return;
		}
		
		for(int i = start; i < N; i++) {
			visited[i] = true;
			combination(i + 1, r - 1, visited);
			visited[i] = false;
		}
	}

	static String src = "2\n" + 
			"4\n" + 
			"6 0\n" + 
			"3 3\n" + 
			"-7 2\n" + 
			"-4 -1\n" + 
			"2\n" + 
			"-100000 100000\n" + 
			"100000 -100000";
}
