package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2021. 6. 19.
 * @see  https://www.acmicpc.net/problem/17472
 * @mem  11732
 * @time 84
 * @caution 
 * 섬 구별 : BFS,
 * 다리 길이 구하기 : 구현,
 * 최단 길이 구하기 : union-find,
 * 다리 길이 구하기에서 가장 어려웠었다. 섬 중간이 뚫린 상태에서 다른 섬과의 길이를 구하는 경우 때문...
 * 결국 모든 점을 기준으로 양방향으로 구함
 */
public class Main_17472_B_다리만들기2 {
	
	static int N, M;
	static int map [][];
	static int numbers [];
	
	static int dir[][] = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
	
	static PriorityQueue<Point> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// construct map
		map = new int [N][M];
		
		// input map array
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int col = 0; col < M; col++) map[row][col] = Integer.parseInt(st.nextToken());
		}
		
		// numbering map
		boolean visited [][] = new boolean [N][M];
		Queue<Point> queue = new LinkedList<>();
		int number = 0;
		
		for(int row = 0; row < N; row ++) {
			for(int col = 0; col < M; col++) {
				if(!visited[row][col] && map[row][col] != 0) {
					number++;
					visited[row][col] = true;
					queue.add(new Point(row, col, number));
					
					// BFS
					while(!queue.isEmpty()) {
						Point point = queue.poll();
						map[point.row][point.col] = point.num;
						
						for(int d = 0; d < 4; d++) {
							int nRow = point.row + dir[d][0];
							int nCol = point.col + dir[d][1];
							if(isin(nRow, nCol) && !visited[nRow][nCol] && map[nRow][nCol] != 0) {
								visited[nRow][nCol] = true;
								map[row][col] = number;
								queue.add(new Point(nRow, nCol, point.num));
							} // if isin, not visited, not map number 0
						} // for dir
					} // while is not empty
				} // if not visited and map value is not 0
			} // for col
		} // for row
		
		pq = new PriorityQueue<>();
		
		// 다리 구하기
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				if(map[row][col] != 0) {
					getBridge(row, col, map[row][col]);
				} // if : map[row][col] is not 0
			} // for col
		} // for row
		
		/** union-find start **/
		numbers = new int [number + 1];
		for(int i = 1; i < number + 1; i++) numbers[i] = i;
		
		int min = 0;			// 모든 다리의 길이 합 (최소 값)
		boolean connectFlag = true;
		
		while(!pq.isEmpty()) {
			Point front = pq.poll();
			
			if(find(front.row) == find(front.col)) continue;
			min += front.num;
			union(front.row, front.col);
		}
		
		int basicNum = find(1);	// 모든 다리가 연결되어있는지 확인할 때 사용하는 기준 값
		for(int i = 1; i < number + 1; i++) {
			if(basicNum != find(i)) {
				connectFlag = false;
				break;
			}
		}
		
		System.out.println((connectFlag)? min : -1);
	}
	
	// srcNum : source number
	private static void getBridge(int row, int col, int srcNum) {
		
		for(int d = 0; d < 4; d++) {
			int nRow = row;
			int nCol = col;
			int len = 0;
			
			while(true) {
				nRow = nRow + dir[d][0];
				nCol = nCol + dir[d][1];
				
				if(isin(nRow, nCol)) {
					if(map[nRow][nCol] == srcNum) {
						len = 0;
						break;
					} else if(map[nRow][nCol] == 0) {
						// 다리 길이 증가, loop(while) 계속 진행
						len++;
					} else {
						if(len >= 2) pq.add(new Point(srcNum, map[nRow][nCol], len));
						break;
					}
				} else {
					len = 0;
					break;
				}
			} // while
			
		} // for dir
		
	}

	private static void union(int number1, int number2) {
		number1 = find(number1);
		number2 = find(number2);
		
		if(number1 != number2) numbers[number1] = number2;
	}

	private static int find(int number) {
		if(number == numbers[number]) return number;
		return numbers[number] = find(numbers[number]);
	}

	private static void print() {
		for(int row = 0; row < N; row++) {
			System.out.println(Arrays.toString(map[row]));
		} System.out.println();
	}

	private static boolean isin(int row, int col) {
		return -1 < row && row < N && -1 < col && col < M;
	}

	static class Point implements Comparable<Point> {
		int row, col, num;

		public Point(int row, int col, int num) {
			this.row = row;
			this.col = col;
			this.num = num;
		}
		
		@Override
		public int compareTo(Point o) {
			if(this.num < o.num) return -1;
			else if(this.num > o.num) return 1;
			return 0;
		}
		
		@Override
		public String toString() {
			return "(" + row + ", " + col + ", " + num + ")";
		}
	}
	
	static String src = "7 8\n"
			+ "0 0 0 0 0 0 1 1\n"
			+ "1 1 0 0 0 0 1 1\n"
			+ "1 1 0 0 0 0 0 0\n"
			+ "1 1 0 0 0 1 1 0\n"
			+ "0 0 0 0 0 1 1 0\n"
			+ "0 0 0 0 0 0 0 0\n"
			+ "1 1 1 1 1 1 1 1";
}
