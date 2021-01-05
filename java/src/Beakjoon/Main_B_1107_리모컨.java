package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 5.
 *  @see  https://www.acmicpc.net/problem/1107
 *  @mem  12096
 *  @time 120
 *  @caution 
 *  브루트포스 문제, 반복문을 사용하여 모든 경우의 값을 비교하여 푸는 문제...
 *  완탐(중복 순열)을 사용하여 문제를 풀려고 했으나, 001001값을 만들어야할때, 0번이 고장난 경우 숫자가 시작하는 부분전에는 0이 존재하면서
 *  숫자가 시작하고나서부터는 0이 존재하면 안될때 순열을 만드는 것이 까다로워 포기하고
 *  모든 경우를 찾는 코드를 작성
 *  그리고 중간 중간 예외를 만들어 해결해야한다...
 *  모든 숫자 버튼이 고장난경우, 0버튼이 고장나고 찾아야하는 숫자가 1자리 숫자인 경우 등...
*/
public class Main_B_1107_리모컨 {
	
	static int N;
	static int M;
	static int min;
	static boolean [] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		nums = new boolean [10];
		min = Math.abs(N - 100);
		
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0; i < M; i++) {
				int idx = Integer.parseInt(st.nextToken());
				nums[idx] = true;
			}
		}
		
		if(min == 0) {
			System.out.println(min);
			return;
		}
		
		if(M == 10) {
			System.out.println(min);
			return;
		}
		
		for(int i = 0; i < 999999; i++) {
			if(i < 10 && nums[i]) continue;
			solution(i);
		}
		
		System.out.println(min);
	}
	
	private static void solution(int num) {
		int click = 0;
		for(int _num = num; _num > 0; _num /= 10) {
			click++;
			int idx = _num % 10;
			if(nums[idx]) return;
		}
		if(click == 0) click++;

		min = Math.min(min, Math.abs(N - num) + click);
	}

}
