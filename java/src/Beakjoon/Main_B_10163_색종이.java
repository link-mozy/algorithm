package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_10163_색종이 {
	/**
	 *  @author mozy
	 *  @since Oct 23, 2020
	 *  @see 
	 *  @mem 
	 *  @time 
	 *  @caution
	 *  테스트 케이스는 성공했으나 제출은 실패
	 *   
	*/
	
	static final int WIDTH = 101, HEIGHT = 101;
	
	static int [][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; 
	static int N;
	static int [][] papers; // 색종이 정보
	static int [][] whitepaper; // 도화지
	static boolean [][] visited; // 방문 여부
	static int [] count;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		count = new int [N + 1];
		whitepaper = new int [HEIGHT][WIDTH]; 
		visited = new boolean [HEIGHT][WIDTH];
		papers = new int [N][4]; // 0:column, 1:row, 2:width, 3:height
		
		for(int i = 0; i < N; i++) {
			// 색종이 정보 입력 받기
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < 4; j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// 색종이 그리기
			int width = papers[i][0] + papers[i][2];
			int height = papers[i][1] + papers[i][3];
			for(int row = papers[i][1]; row < height; row++) {
				for(int column = papers[i][0]; column < width; column++) {
					whitepaper[row][column] = i+1;
				}
			}
		}
		
//		// 입력값 확인
//		System.out.println(Arrays.deepToString(papers));
		
//		// 색종이 확인
//		for(int row = 0; row < HEIGHT; row++) {
//			System.out.println(Arrays.toString(whitepaper[row]));
//		}
		
		// 색종이 넓이 구하기
		for(int i = 0; i < N; i++) {
			int startcolumn = papers[i][0];
			int startrow = papers[i][1];
			
			if(visited[startrow][startcolumn]) break;
			Queue<Point> queue = new LinkedList<Point>();
			queue.add(new Point(startrow, startcolumn, whitepaper[startrow][startcolumn]));
			while(!queue.isEmpty()) {
				Point point = queue.poll();
				
				int srow = point.row;
				int scolumn = point.column;
				visited[srow][scolumn] = true;
				count[point.value]++;
				
				for(int d = 0; d < 4; d++) {
					int nrow = srow + dir[d][0];
					int ncolumn = scolumn + dir[d][1];
					
					if(isin(nrow, ncolumn) 
					&& !visited[nrow][ncolumn] 
					&& whitepaper[nrow][ncolumn] != 0) {
						queue.add(new Point(nrow, ncolumn, whitepaper[nrow][ncolumn]));
						visited[nrow][ncolumn] = true;
					}
				}
			}
		}

		// 결과값 출력
		for(int i = 1; i <= N; i++) {
			sb.append(count[i] + "\n");
		}
		
		System.out.println(sb);
	}
	
	static String src = "2\n" + 
			"0 0 10 10\n" + 
			"2 2 6 6";
	
//	static String src = "1\n" + 
//			"1 4 3 2";
	
	static class Point {
		int row;
		int column;
		int value;
		
		public Point(int row, int column, int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}

		@Override
		public String toString() {
			return "(" + row + ", " + column + ", " + value + ")";
		}
	}
	
	static boolean isin(int row, int column) {
		return 0 <= row && row < HEIGHT && 0 <= column && column < WIDTH;
	}
}
