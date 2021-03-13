package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 *  @author mozy
 *  @since 2021. 3. 13.
 *  @see  https://www.acmicpc.net/problem/16637
 *  @mem  11544
 *  @time 84
 *  @caution
 *  백트래킹 알고리즘 // 순열 알고리즘
 *  문제 너무 어려웠다. 순차적으로 계산하는 경우와 괄호를 사용하는 경우를 같이 진행해줘야한다.
 *  괄호로 계산할때는 뒤에 오는 값들의 연산을하고 현재 숫자와 계산을 해줘야한다. (계산 두번!)
 *  그리고 마지막 결과값이 Long 자료형이 아니면 런타임 에러가 난다.
*/
public class Main_B_16637_괄호추가하기 {
	
	static int numbers [];
	static char operators [];
	static int depth;
	static Long max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(in.readLine());
		String line = in.readLine();
		
		max = Long.MIN_VALUE;
		depth = N / 2;
		numbers = new int [depth + 1];
		operators = new char [depth];
		for(int i = 0, a = 0, b = 0; i < N; i++) {
			if(i % 2 == 0) numbers[a++] = line.charAt(i) - '0'; 
			else {
				operators[b++] = line.charAt(i);
			}
		}
		
		 permutation(0, numbers[0]);
		
		 System.out.println(max);
	}
	
	private static void permutation(int r, int value) {
		if(r >= depth) {
			max = Math.max(max, value);
			return;
		} else {
			int nValue = 0;
			// 일반적인 계산 순서
			nValue = calculator(value, numbers[r + 1], operators[r]);
			permutation(r + 1, nValue);
			// 괄호 계산 순서
			if(r + 1 < depth) {
				nValue = calculator(numbers[r + 1], numbers[r + 2], operators[r + 1]);
				nValue = calculator(value, nValue, operators[r]);
				permutation(r + 2, nValue);
			}
		}
	}

	private static int calculator(int number1, int number2, char operator) {
		switch (operator) {
		case '*':
			return number1 * number2;
		
		case '+':
			return number1 + number2;
			
		case '-':
			return number1 - number2;
			
		default:
			return 0;
		}
	}

	static String src = "9\n" + 
			"3+8*7-9*2";
}
