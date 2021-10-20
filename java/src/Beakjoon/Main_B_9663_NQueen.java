package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_B_9663_NQueen {

	static int N, ans;
	static int [] col;
	
	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(ans);
	}

	private static void rec_func(int row) {
		if(row == N + 1) {
			ans++;
		} else {
			for(int i = 1; i <= N; i++) {
				boolean possible = true;
				for(int j = 1; j <= row - 1; j++) {
					if(attackable(row, i, j, col[j])) {
						possible = false;
						break;
					}
					
				}
				if(possible) {
					col[row] = i;
					rec_func(row + 1);
					col[row] = 0;
				}
			}
		}
	}

	private static boolean validity_check() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(attackable(i, col[i], j, col[j])) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean attackable(int r1, int c1, int r2, int c2) {
		if(r1 == r2) return false;
		if(r1 + c1 == r2 + c2) return false;
		if(r1 - c1 == r2 - c2) return false;
		return true;
	}

	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			N = Integer.parseInt(br.readLine());
			col = new int [N + 1];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String src = "3";
}
