package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 3. 21.
 *  @see  https://www.acmicpc.net/problem/17136
 *  @mem  21116
 *  @time 248
 *  @caution
 *  DFS + 백트랙킹
 *  구현 문제, 혼자서 문제 풀이 까지 생각을 도출하지 못하여 풀이를 보고 풀음.
 *  -> 복습 필요
 *  possible 함수를 만들수있는게 중요! 색종이를 붙일수있는 것을 확인하고 색종이를 붙이고 백트랙킹 알고리즘 해야함 
*/
public class Main_B_17136_색종이붙이기 {

	static int map [][];
	static int counts [] = {5, 5, 5, 5, 5};
	static boolean visited [][];
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		
		map = new int [10][10];
		min = Integer.MAX_VALUE;
		
		for(int row = 0; row < 10; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int col = 0; col < 10; col++) map[row][col] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0, 0);
		
		System.out.println((min == Integer.MAX_VALUE)? -1 : min);
		
	} // main
	
	private static void dfs(int row, int col, int count) {
		// (0, 0) 부터 마지막 (9,9) 까지 갈 경우에 색종이 최소값 구하기
		if(row >= 9 && col > 9) {
			min = Math.min(min, count);
			return;
		}
		
		// count가 result보다 크거나 같으면 시간 낭비이기 때문에 종료 (가지 치기)
		if(count >= min) return;
		
		// 줄마다 마지막 칸을 넘을 경우 다음 줄로 이동
		if(col > 9) {
			dfs(row + 1, 0, count);
			return;
		}
		
		// 제일 큰 색종이 부터 붙이기
		// 배열 값이 1이 있으면 시작
		if(map[row][col] == 1) {
			// 큰 색종이 부터 준비
			for(int i = 4; i >= 0; i--) {
				// 색종이가 남아있고, 색종이의 크기 만큼 붙일 수 있는지 확인
				if(counts[i] > 0 && possible(row, col, i + 1)) {
					// 색종이 붙여.
					attach(row, col, i + 1);
					
					// 색종이 개수 줄여
					counts[i]--;
					
					// 다음 dfs
					dfs(row, col + 1, count + 1);
					
					// 색종이 떼.
					detach(row, col, i + 1);
					
					// 색종이 개수 늘려
					counts[i]++;
					
				} // if counts && possible
				
			} // for
			
		} // if map[row][col] == 1
		
		// 배열 값이 1이 아니면
		else {
			dfs(row, col + 1, count);
		}
		
	} // dfs

	private static void detach(int row, int col, int len) {
		for(int nrow = row; nrow < row + len; nrow++) {
			for(int ncol = col; ncol < col + len; ncol++) {
				map[nrow][ncol] = 1;
			}
		}
	}

	private static void attach(int row, int col, int len) {
		for(int nrow = row; nrow < row + len; nrow++) {
			for(int ncol = col; ncol < col + len; ncol++) {
				map[nrow][ncol] = 0;
			}
		}
	}

	private static boolean possible(int row, int col, int len) {
		for(int nrow = row; nrow < row + len; nrow++) {
			for(int ncol = col; ncol < col + len; ncol++) {
				// 범위를 벗어나거나 그 위치가 1이 아니라면 false 리턴
				if(!isin(nrow, ncol) || map[nrow][ncol] != 1) return false;
			}
		}
		return true;
	}

	private static boolean isin(int row, int col) {
		return 0 <= row && row < 10 && 0 <= col && col < 10;
	}

	static String src = "0 0 0 0 0 0 0 0 0 0\n" + 
			"0 1 1 0 0 0 0 0 0 0\n" + 
			"0 0 1 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 1 1 0 0 0 0\n" + 
			"0 0 0 0 1 1 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0 0\n" + 
			"0 0 1 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0 0";
}
