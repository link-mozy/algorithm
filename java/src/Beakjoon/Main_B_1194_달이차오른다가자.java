package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 15.
 *  @see https://www.acmicpc.net/problem/1194
 *  @mem  15192
 *  @time 108
 *  @caution 
 *  3차 배열(visited) 이며 비트 마스크를 사용해야한다.
 *  a~f 까지 6가지의 종류의 키가있으며 각각의 visited 맵을 가지고있어야한다.
 *  6가지의 키가 만들수있는 조합으로 visited를 가야하므로 visited는 결국 최대 50 * 50 * 1 << 6(64) 가 된다.
 *  그리고 클래스의 key 변수를 생성해 갖고있을수있는 키의 변수(비트 마스크)로 사용한다.
 *  처음에 위의 컨셉을 못만들어 문제를 못풀고 설명을 보고서야 풀수 있었다.
*/
public class Main_B_1194_달이차오른다가자 {
	
	static int N, M;
	static char map[][];
	static boolean visited[][][]; // row, column, key
	
	static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		visited = new boolean [N][M][1 << 6];
		
		Queue<Point> queue = new LinkedList<>();
		
		for(int row = 0; row < N; row++) {
			map[row] = in.readLine().toCharArray();
			for(int col = 0; col < M; col++) {
				if(map[row][col] == '0') {
					queue.add(new Point(row, col, 0, 0));
					visited[row][col][0] = true;
				}
			}
		}
		
		int result = bfs(queue);
		System.out.println(result);
	}
	
	private static int bfs(Queue<Point> queue) {
		int row;
		int col;
		int key;
		int count;
		
		while(!queue.isEmpty()) {
			Point front = queue.poll();
			row = front.row;
			col = front.col;
			key = front.key;
			count = front.count;
			
			if(map[row][col] == '1') {
				return count; // 종료
			}
			
			for(int d = 0; d < 4; d++) {
				int nrow = row + dir[d][0];
				int ncol = col + dir[d][1];
				
				if(!isin(nrow, ncol) || map[nrow][ncol] == '#' || visited[nrow][ncol][key])
					continue;
				// 키일때
				if(0 <= (map[nrow][ncol] - 'a') && (map[nrow][ncol]) - 'a' < 6) {
					int nkey = (1 << (map[nrow][ncol] - 'a')) | key;
					queue.add(new Point(nrow, ncol, nkey, count + 1));
					visited[nrow][ncol][nkey] = true;
				}
				// 문일때
				else if(0 <= (map[nrow][ncol] - 'A') && (map[nrow][ncol]) - 'A' < 6) {
					int door = (1 << (map[nrow][ncol] - 'A')) & key;
					// 문이 열리는 경우
					if(door > 0) {
						queue.add(new Point(nrow, ncol, key, count + 1));
						visited[nrow][ncol][key] = true;
					}
				}
				else {
					queue.add(new Point(nrow, ncol, key, count + 1));
					visited[nrow][ncol][key] = true;
				}
			}
		}
		return -1;
	}

	private static boolean isin(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < M;
	}

	static class Point {
		int row;
		int col;
		int key;
		int count;
		
		public Point(int row, int col, int key, int count) {
			this.row = row;
			this.col = col;
			this.key = key;
			this.count = count;
		}
	}
	
	static String src = "7 8\n" + 
			"a#c#eF.1\n" + 
			".#.#.#..\n" + 
			".#B#D###\n" + 
			"0....F.1\n" + 
			"C#E#A###\n" + 
			".#.#.#..\n" + 
			"d#f#bF.1";
}
