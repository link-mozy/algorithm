package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  @author mozy
 *  @since 2020. 12. 27.
 *  @see 
 *  @mem  49,900
 *  @time 207
 *  @caution
 *  문제를 이해하기도 힘들었다...
 *  처음에 주위에 폭탄이없는 곳을 연속해서 없애주는 곳을 찾아서 카운트해준다. (BFS)
 *  -> 문제의 핵심이고 경계를 찾는거라고도 한다.
 *  그리고 아직 카운트하지 않은 곳을 찾아 카운트해준다.
*/
public class Solution_1868_파핑파핑지뢰찾기_BFS {

	static int T;
	static int N;
	static int[][] mapCnt;
	static char[][] map;
	static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new char [N][N];
			mapCnt = new int [N][N];
			
			int count = 0;
			for(int row = 0; row < N; row++) {
				map[row] = in.readLine().toCharArray();
			}
			
			// 숫자 붙이기
			getCount();
			
			// 0 인곳 클릭!
			for(int row = 0; row < N; row++) {
				for(int column = 0; column < N; column++) {
					if(mapCnt[row][column] == 0 && map[row][column] == '.') {
						count++;
						click(new Point(row, column));
					}
				}
			} // click loop
			
			// 나머지 dot count 하기
			count = dotCount(count);
			
			System.out.println("#" + tc + " " + count);
			
		} // tc loop
		
	} // main
	
	private static int dotCount(int count) {
		for(int row = 0; row < N; row++) {
			for(int column = 0; column < N; column++) {
				if(map[row][column] == '.') count++;
			}
		}
		return count;
	}

	private static void click(Point click) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(click);
		map[click.row][click.column] = 'v';
		while(!queue.isEmpty()) {
			Point front = queue.poll();
			
			for(int d = 0; d < 8; d++) {
				int _row = front.row + dir[d][0];
				int _column = front.column + dir[d][1];
				if(!isin(_row, _column)) continue;
				if(map[_row][_column] == '.') {
					map[_row][_column] = 'v';
					if(mapCnt[_row][_column] == 0) {
						queue.add(new Point(_row, _column));
					}
				}
			}
		}
	}

	private static void getCount() {
		for(int row = 0; row < N; row++) {
			for(int column = 0; column < N; column++) {
				int cnt = 0;
				if(map[row][column] == '.') {
					for(int d = 0; d < 8; d++) {
						int _row = row + dir[d][0];
						int _column = column + dir[d][1];
						if(isin(_row, _column) && map[_row][_column] == '*') cnt++;
					}
					mapCnt[row][column] = cnt;
				}
			}
		}
	}

	static void print() {
		for(int row = 0; row < N; row++) {
			for(int column = 0; column < N; column++) {
				System.out.print(map[row][column] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static boolean isin(int row, int column) {
		return 0 <= row && row < N && 0 <= column && column < N;
	}

	static class Point{
		int row;
		int column;
		
		public Point(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}
	}

	private static String src = "2\n" + 
			"3\n" + 
			"..*\n" + 
			"..*\n" + 
			"**.\n" + 
			"5\n" + 
			"..*..\n" + 
			"..*..\n" + 
			".*..*\n" + 
			".*...\n" + 
			".*...";
}
