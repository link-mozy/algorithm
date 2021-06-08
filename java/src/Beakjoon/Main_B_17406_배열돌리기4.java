package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2021. 6. 9.
 * @see  https://www.acmicpc.net/problem/17406
 * @mem  35120
 * @time 268
 * @caution 
 * 순열, 구현 문제
 * 순열을 만드는것은 쉬우나, 이차원 배열을 돌리는 알고리즘 구현이 생각보다 어려웠다.
 * 처음에는 방향을 주어 값일 옮기는 것을 구현하려고 했는데, 생각보다 잘안되어
 * 각 방향마다 값을 이동하도록 구현하였다. (메모리, 시간 비효율적...)
 */
public class Main_B_17406_배열돌리기4 {
	
	static int map [][];
	static int rotationOperationArr [][];
	static int N, M, K; // Row, Column, Rotation Count
	
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(str));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int [N + 1][M + 1];
		rotationOperationArr = new int [K][3];
		min = Integer.MAX_VALUE;
		
		/** input map **/
		for(int row = 1; row < N + 1; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 1; col < M + 1; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			} // for col
		} // for row
		
		/** input rotationOperation  **/
		for(int k = 0; k < K; k++) { // 0번째는 0으로 고정
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 3; i++) {
				rotationOperationArr[k][i] = Integer.parseInt(st.nextToken());
			} // for i
		} // for k

		permutation(0, new int [K], new boolean [K]);
		
		System.out.println(min);
		
	} // end main

	private static void permutation(int r, int[] numbers, boolean[] visited) {
		if(r == K) {
			play(numbers);
			return;
		} else {
			for(int i = 0; i < K; i++) {
				if(visited[i]) continue;
				visited[i] = true;
				numbers[r] = i;
				permutation(r + 1, numbers, visited);
				visited[i] = false;
			}
		}
	} // permutation

	private static void play(int[] numbers) {
		int nMap [][] = new int [N + 1][M + 1];
		
		for(int row = 1; row < N + 1; row++) {
			nMap[row] = Arrays.copyOf(map[row], M + 1);
		}
		
		for(int num = 0; num < numbers.length; num++) {
			int minRow = rotationOperationArr[numbers[num]][0] - rotationOperationArr[numbers[num]][2];
			int maxRow = rotationOperationArr[numbers[num]][0] + rotationOperationArr[numbers[num]][2];
			int minCol = rotationOperationArr[numbers[num]][1] - rotationOperationArr[numbers[num]][2];
			int maxCol = rotationOperationArr[numbers[num]][1] + rotationOperationArr[numbers[num]][2];
			
			rotationOperation(minRow, maxRow, minCol, maxCol, nMap);
		}
		getMinValue(nMap);
	} // play

	private static void getMinValue(int[][] _map) {
		for(int row = 1; row < N + 1; row++) {
			int sum = 0;
			for(int col = 1; col < M + 1; col++) {
				sum += _map[row][col];
			}
			if(min > sum) min = sum;
		}
		
	} // getMinValue

	private static void rotationOperation(int minRow, int maxRow, int minCol, int maxCol, int [][] _map) {
		/** 탈출 조건 **/
		if(minRow == maxRow && minCol == maxCol) return;
		
		int point [] = {_map[minRow][minCol],	// 0
						_map[minRow][maxCol],	// 1
						_map[maxRow][minCol],	// 2
						_map[maxRow][maxCol]};	// 3
		
		// point(minRow, minCol) -> point(minRow, maxCol) : 우
		for(int dCol = maxCol; dCol > minCol; dCol--) {
			if((minCol + 1) == dCol) _map[minRow][dCol] = point[0];
			else _map[minRow][dCol] = _map[minRow][dCol - 1];
		}
		// point(minRow, maxCol) -> point(maxRow, maxCol) : 하
		for(int dRow = maxRow; dRow > minRow; dRow--) {
			if((minRow + 1) == dRow) _map[dRow][maxCol] = point[1];
			else _map[dRow][maxCol] = _map[dRow - 1][maxCol];
		}
		// point(maxRow, maxCol) -> point(maxRow, minCol) : 좌
		for(int dCol = minCol; dCol < maxCol; dCol++) {
			if((maxCol - 1) == dCol) _map[maxRow][dCol] = point[3];
			else _map[maxRow][dCol] = _map[maxRow][dCol + 1];
		}
		// point(maxRow, minCol) -> point(minRow, minCol) : 상
		for(int dRow = minRow; dRow < maxRow; dRow++) {
			if((maxRow - 1) == dRow) _map[dRow][minCol] = point[2];
			else _map[dRow][minCol] = _map[dRow + 1][minCol];
		}
		
		rotationOperation(minRow + 1, maxRow - 1, minCol + 1, maxCol - 1, _map);
	} // rotationOperation

	static String str = "5 6 2\n"
			+ "1 2 3 2 5 6\n"
			+ "3 8 7 2 1 3\n"
			+ "8 2 3 1 4 5\n"
			+ "3 4 5 1 1 1\n"
			+ "9 3 2 1 4 3\n"
			+ "3 4 2\n"
			+ "4 2 1";
}