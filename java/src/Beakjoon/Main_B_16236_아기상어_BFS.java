package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2020. 12. 29.
 *  @see  https://www.acmicpc.net/problem/16236
 *  @mem  24196
 *  @time 172
 *  @caution 
 *  물고기를 찾아가는 Queue(BFS)와 먹을수있는 물고기 리스트 PriorityQueue를 만들어 풀었다.
 *  물고기는 한마리씩 먹기때문에 먹을수있는 물고기의 가장 첫번째(우선순위가 높은것)을 하나 꺼내어 먹고 초기화 시켜주는 식으로 문제를 풀었다.
 *  BFS와 시뮬레이션... 처음으로 아기상어를 풀었다!
*/
public class Main_B_16236_아기상어_BFS {
	
	static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(in.readLine());
		map = new int [N][N];
		Fish shark = null;
		
		for(int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int column = 0; column < N; column++) {
				map[row][column] = Integer.parseInt(st.nextToken());
				if(map[row][column] == 9) {
					shark = new Fish(row, column, 0, 2);
				}
			}
		}
		
		int eatCnt = 0;
		int result = 0;

		PriorityQueue<Fish> pq = new PriorityQueue<Fish>();
		while(true) {
			boolean [][] visited = new boolean [N][N];
			Queue<Fish> queue = new LinkedList<>();
			// 아기상어 준비
			map[shark.row][shark.column] = 0;
			queue.add(shark);
			visited[shark.row][shark.column] = true;

			// 먹을 수 있는 물고기 찾기
			while(!queue.isEmpty()) {
				Fish front = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int _row = front.row + dir[d][0];
					int _column = front.column + dir[d][1];
					if(isin(_row, _column) && !visited[_row][_column]) {
						if(map[_row][_column] > shark.size) continue;
						if(map[_row][_column] != 0 && map[_row][_column] < shark.size) {
							pq.add(new Fish(_row, _column, front.dist + 1));
						}
						queue.add(new Fish(_row, _column, front.dist + 1));
						visited[_row][_column] = true;
					}
				}
			} // queue loop
			
			// 종료
			if(pq.isEmpty()) break;
			
			// 물고기 먹기
			Fish first = pq.poll();
			shark.row = first.row;
			shark.column = first.column;
			shark.dist = 0;
			eatCnt++;
			if(eatCnt == shark.size) {
				shark.size++;
				eatCnt = 0;
			}
			result += first.dist;
			pq.clear();
			
		} // while loop 
		
		System.out.println(result);
		
	} // main
	
	private static boolean isin(int row, int column) {
		return 0 <= row && row < N && 0 <= column && column < N;
	}

	static class Fish implements Comparable<Fish>{
		int row;
		int column;
		int size;
		int dist;
		
		public Fish(int row, int column) {
			this.row = row;
			this.column = column;
		}


		public Fish(int row, int column, int dist) {
			this(row, column);
			this.dist = dist;
		}
		
		public Fish(int row, int column, int dist, int size) {
			this(row, column, dist);
			this.size = size;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.dist == o.dist) {
				if(this.row == o.row) {
					if(this.column <= o.column) return -1;
					else return 1;
				}
				else if (this.row < o.row) return -1;
				else return 1;
			}
			else if(this.dist < o.dist) return -1;
			else return 1;
		}

		@Override
		public String toString() {
			return "[r:" + row + ", c:" + column + ", s:" + size + ", d:" + dist + "] ";
		}
		
		
	}
	
	static String src = "6\n" + 
			"1 1 1 1 1 1\n" + 
			"2 2 6 2 2 3\n" + 
			"2 2 5 2 2 3\n" + 
			"2 2 2 4 6 3\n" + 
			"0 0 0 0 0 6\n" + 
			"0 0 0 0 0 9";
}