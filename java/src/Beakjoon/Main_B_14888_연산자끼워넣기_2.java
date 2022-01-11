package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2021. 10. 16.
 * @see  https://www.acmicpc.net/problem/14888
 * @mem  11804 KB
 * @time 80 ms
 * @caution 
 */
public class Main_B_14888_연산자끼워넣기_2 {
	
	static int N, max, min;
	static int [] numbers;
	static int [] operation;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		input();
		rec_func(1, numbers[1]);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}

	private static void rec_func(int k, int value) {
		if(k == N) {
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			for(int i = 1; i <= 4; i++) {
				if(operation[i] == 0) continue;
				operation[i]--;
				int newValue = calculator(value, i, numbers[k + 1]);
				rec_func(k + 1, newValue);
				operation[i]++;
			}
		}
	}

	private static int calculator(int operand1, int operation, int operand2) {
		if(operation == 1)
			return operand1 += operand2;
		else if(operation == 2)
			return operand1 -= operand2;
		else if(operation == 3)
			return operand1 *= operand2;
		else 
			return operand1 /= operand2;
	}

	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			N = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			numbers = new int [N + 1];
			operation = new int [4 + 1];
			// 숫자 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) numbers[i] = Integer.parseInt(st.nextToken());
			// 연산자 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= 4; i++) operation[i] = Integer.parseInt(st.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String src = "3\n"
			+ "3 4 5\n"
			+ "1 0 1 0";	
}
