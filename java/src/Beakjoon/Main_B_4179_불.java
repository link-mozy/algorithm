package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 7.
 *  @see https://www.acmicpc.net/problem/4179
 *  @mem  79588
 *  @time 588
 *  @caution 
 *  Point 클래스에 type 변수를 만들고, 하나의 큐에 지훈이와 불을 넣는데, 순서는
 *  불다음에 지훈이를 넣도록하는것이 포인트!!!
 *  이유는 이미 지훈이 위치는 우리가 알기때문에 맵에 불이 번지고 지훈이가 이동하는 것!
 *  큐의 포인트가 없어질때까지 지훈이가 가장자리에 도착 못한다면 종료!
*/
public class Main_B_4179_불 {

	static char map[][];
	static int R, C;
	static boolean visited[][];
	static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		visited = new boolean [R][C];
		
		Point jihun = null;
		Queue<Point> queue = new LinkedList<>();
		
		for(int row = 0; row < R; row++) {
			String line = in.readLine().replace(" ", "");
			map[row] = line.toCharArray();
			for(int col = 0; col < C; col++) {
				if(map[row][col] == 'J') {
					
					// 가장자리에 위치한다면 바로 종료
					if(isEdge(row, col)) {
						System.out.println(1);
						return;
					}
					
					map[row][col] = '.';
					visited[row][col] = true;
					jihun = new Point(row, col, 0, 0);
					
				}
				else if(map[row][col] == 'F') {
					queue.add(new Point(row, col, 0, 1));
				}
			}
		}
		
		queue.add(jihun);
		bfs(queue);
	}


	private static void bfs(Queue<Point> queue) {
		int row;
		int col;
		int dist;
		int type;
		
		while(!queue.isEmpty()) {
			Point front = queue.poll();
			row = front.row;
			col = front.col;
			dist = front.dis;
			type = front.type;
			
			if(isEdge(row, col) && type == 0) {
				System.out.println(dist + 1);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nrow = row + dir[d][0];
				int ncol = col + dir[d][1];
				
				if(!isIn(nrow, ncol) || map[nrow][ncol] == '#' || map[nrow][ncol] == 'F')
					continue;
				
				if(type == 0 && !visited[nrow][ncol]) {
					queue.add(new Point(nrow, ncol, dist + 1, type));
					visited[nrow][ncol] = true;
				} else if(type == 1) {
					// 4방향 불 퍼지기
					map[nrow][ncol] = 'F';
					queue.add(new Point(nrow, ncol, 0, type));
				}
			}
		}
		
		System.out.println("IMPOSSIBLE");
		
	}


	private static boolean isEdge(int row, int col) {
		for(int d = 0; d < 4; d++) {
			int _row = row + dir[d][0];
			int _col = col + dir[d][1];
			
			if(!isIn(_row, _col)) {
				return true;
			}
		}
		return false;
	}


	private static boolean isIn(int row, int col) {
		return 0 <= row && row < R && 0 <= col && col < C;
	}


	static class Point {
		int row;
		int col;
		int dis;
		int type;
		
		public Point(int row, int col, int dis, int type) {
			super();
			this.row = row;
			this.col = col;
			this.dis = dis;
			this.type = type;
		}
	}
	

	static String src = "4 4\n" + 
			"####\n" + 
			"#JF#\n" + 
			"#..#\n" + 
			"#..#";
}
