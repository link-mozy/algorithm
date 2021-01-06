package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 7.
 *  @see https://www.acmicpc.net/problem/2630
 *  @mem  13304
 *  @time 120
 *  @caution
 *  DFS이며, 교수님 코드를 참고...
 *  혼자서 못풀듯하다. 나누고 시작할때, 계속해서 0부터 시작해서 증가하는 것을 해야하는데...
 *  아이디어를 도출을 못함... 
*/
public class Main_B_2630_색종이만들기 {
	
	static int map[][];
	static int color [];
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(in.readLine());
		map = new int [N][N];
		color = new int [2];
		
		for(int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(0, 0, N);
		System.out.printf("%d\n%d", color[0], color[1]);
		
	}
	
	private static void solution(int row, int col, int n) {
		if(check(row, col, n)) {
			color[map[row][col]]++;
		} else {
			for(int _row = 0; _row < n; _row += n/2) {
				for(int _col = 0; _col < n; _col += n/2) {
					solution(row + _row, col + _col, n/2);
				}
			}
		}
	}

	private static boolean check(int row, int col, int n) {
		int _color = map[row][col];
		for(int _row = 0; _row < n; _row++) {
			for(int _col = 0; _col < n; _col++) {
				if(_color != map[row + _row][col + _col]) return false;
			}
		}
		return true;
	}

	static String src = "8\n" + 
			"1 1 0 0 0 0 1 1\n" + 
			"1 1 0 0 0 0 1 1\n" + 
			"0 0 0 0 1 1 0 0\n" + 
			"0 0 0 0 1 1 0 0\n" + 
			"1 0 0 0 1 1 1 1\n" + 
			"0 1 0 0 1 1 1 1\n" + 
			"0 0 1 1 1 1 1 1\n" + 
			"0 0 1 1 1 1 1 1";
}