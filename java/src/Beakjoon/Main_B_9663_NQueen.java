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
			if(validity_check()) {
				ans++;
			}
		} else {
			for(int i = 1; i <= N; i++) {
				col[row] = i;
				rec_func(row + 1);
				col[row] = 0;
			}
		}
	}

	private static boolean validity_check() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i - 1; j++) {
				if(attackable(i, col[i], j, col[j])) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean attackable(int r1, int c1, int r2, int c2) {
		if(c1 == c2) return true;
		if(r1 + c1 == r2 + c2) return true;
		if(r1 - c1 == r2 - c2) return true;
		return false;
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
	
	static String src = "8";
}
