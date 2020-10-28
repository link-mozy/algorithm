package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B_14891_톱니바퀴 {
	
	static int [][] gears;
	static int [][] targetAndDir;
	static int K;
		
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		
		gears = new int [4][8];
		
		// 입력 받기
		for(int row = 0; row < 4; row++) {
			String line = in.readLine();
			for(int column = 0; column < 8; column++) {
				gears[row][column] = line.charAt(column) - '0';
			}
		}
		
		K = Integer.parseInt(in.readLine());
		targetAndDir = new int [K][2];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			targetAndDir[i][0] = Integer.parseInt(st.nextToken()) - 1;
			targetAndDir[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		// 입력값 확인
//		for(int r = 0; r < 4; r++) {
//			System.out.println(Arrays.toString(gears[r]));
//		}
//		for(int i = 0; i < K; i++) {
//			System.out.println(Arrays.toString(targetAndDir[i]));
//		}
		
		// 톱니바퀴 돌리기
		for(int i = 0; i < K; i++) {
			int number = targetAndDir[i][0];
			run(number, targetAndDir[i][1]);
			System.out.println("round: " + i+1);
			print();
		}
		
		// 결과 출력하기
		int result = 0;
		for(int i = 0; i < 4; i++) {
			result += gears[i][0] * (1 << i);
		}
		System.out.println(result);
	}
	
	private static void run(int number, int dir) {
		
		List<int []> listGears = new LinkedList<int []>();
		int [] firstgear = {number, dir};
		listGears.add(firstgear);
		
		// 오른쪽
		for(int start = number, dir_ = dir; start < 3; start++) {
			int right = start + 1;
			if(gears[start][2] == gears[right][6]) {
				dir_ *= -1;
				int [] nextgear = {right, dir_};
				listGears.add(nextgear);
			}
			else {
				break;
			}
		}
		// 왼쪽
		for(int start = number, dir_ = dir; 0 < start; start--) {
			int left = start - 1;
			if(gears[left][2] == gears[start][6]) {
				dir *= -1;
				int [] nextgear = {left, dir_};
				listGears.add(nextgear);
			}
		}
		
		for(int i = 0; i < listGears.size(); i++) {
			int [] gear = listGears.get(i);
			moveGear(gear[0], gear[1]);
		}
	}

	private static void moveGear(int number, int dir) {
		if(number < 0 || 3 < number) {
			return;
		}
		// 톱니 돌리기
		if(dir > 0) { // 오른쪽으로 돌리기
			for(int i = 7; i > 0; i--) {
				int tmp = gears[number][i];
				gears[number][i] = gears[number][i-1];
				gears[number][i-1] = tmp;
			}
		} else { // 왼쪽으로 돌리기
			for(int i = 0; i < 7; i++) {
				int tmp = gears[number][i];
				gears[number][i] = gears[number][i+1];
				gears[number][i+1] = tmp;
			}
		}
	}
	
	static void print() {
		System.out.println("----- Gear Info -----------------------");
		for(int r = 0; r < 4; r++) {
			System.out.println(Arrays.toString(gears[r]));
		}
		System.out.println("---------------------------------------");
		System.out.println();
	}

	static String src = "10001011\n" + 
			"10000011\n" + 
			"01011011\n" + 
			"00111101\n" + 
			"5\n" + 
			"1 1\n" + 
			"2 1\n" + 
			"3 1\n" + 
			"4 1\n" + 
			"1 -1";
}
