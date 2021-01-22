package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 22.
 *  @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b_WPaAEIBBASw
 *  @mem  59064
 *  @time 388
 *  @caution
 *  조합문제
 *  단순히 조합만하는 것이 아니라 문제 컨셉을 이해하는 것이 중요.
 *  처음에는 점이 두점이 될때까지 dfs를 타도록 하면, 메모리 초과가난다.
 *  두 컨셉으로 나누는것이 중요. 뽑혔는가 안뽑혔는가, 그러면 두 점으로 되니깐 두 분류의 합을 백터로 구해서 최소값을 구하도록 한다.
*/
public class Solution_1494_사랑의카운슬러 {

	static int map[][];
	static boolean visited[];
	static int N;
	static Long min;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			
			map = new int [N][2];
			visited = new boolean [N];
			min = Long.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[i][0] = x;
				map[i][1] = y;
			}
			
			dfs(0, 0);
			sb.append("#" + tc + " " + min).append("\n");
		} // test case loop
		
		System.out.println(sb);
	}
	

	private static void dfs(int now, int count) {
		if(count == N/2) {
			long x = 0; long y = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					x += map[i][0];
					y += map[i][1];
				} else {
					x -= map[i][0];
					y -= map[i][1];
				}
			}
			min = Math.min(min, x*x + y*y);
			return;
		}
		
		for(int i = now; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			dfs(i + 1, count + 1);
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
