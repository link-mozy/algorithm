package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_14500_테크로미노 {

	
	// 조건1. 정사각형 4개를 이어 붙여야 한다.
	// 조건2. 정사격형은 서로 겹치면 안 된다.
	// 조건3. 도형은 모두 연결되어 있어야 한다.
	// 조건4. 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
	// 세로 크기 : N
	// 가로 크기 : M
	
	static int N, M;
	static int [][] map;
	static int [][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int column = 0; column < M; column++) {
				map[row][column] = Integer.parseInt(st.nextToken());
			}
		}
		
//		// 입력 확인
//		for(int row = 0; row < N; row++) {
//			System.out.println(Arrays.toString(map[row]));
//		}
		
		for(int row = 0; row < N; row++) {
			for(int column = 0; column < M; column++) {
				System.out.println("row: " + row + " column: " + column);
				boolean [][] visited = new boolean [N][M];
				visited[row][column] = true;
				makeFigure(row, column, visited, 1, map[row][column]);
			}
		}
		
		System.out.println(max);
	}
	
	private static void makeFigure(int row, int column, boolean [][] visited, int count, int value) {
		// 탈출 조건
		if(count == 4) {
			System.out.println("Row : " + row + " Column : " + column + " Count : " + count + " Value : " + value);
			printVisited(visited);
			System.out.println();
			
			max = Math.max(max, value);
			return;
		} else {
			
		}

		// 실행
//		printVisited(visited);
//		System.out.println();
		for(int d = 0; d < 4; d++) { // 4방 탐색
			int row_ = row + dir[d][0];
			int column_ = column + dir[d][1];
			
			if(isin(row_, column_) && !visited[row_][column_] && count < 5) {
				visited[row_][column_] = true;
				makeFigure(row_, column_, visited, count + 1, value + map[row_][column_]);
				visited[row_][column_] = false;
			}
		}
	}
	
	static void printVisited(boolean [][] visited) {
		for(int row = 0; row < N; row++) {
			for(int column = 0; column < M; column++) {
				int tmp = (visited[row][column])? 1 : 0;
				System.out.print(tmp);
			}
			System.out.println();
		}
	}

	static boolean isin(int row, int column) {
		return -1 < row && row < N && -1 < column && column < M;
	}
	
	static String src = "5 5\n" + 
			"1 2 3 4 5\n" + 
			"5 4 3 2 1\n" + 
			"2 3 4 5 6\n" + 
			"6 5 4 3 2\n" + 
			"1 2 1 2 1";
	
}
