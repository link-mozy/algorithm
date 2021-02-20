package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 20.
 *  @see  https://www.acmicpc.net/problem/15665
 *  @mem  45356
 *  @time 316
 *  @caution
 *  중복 순열 문제, 일반 배열로 문제 해결 (시간 및 메모리 효율적)
 *  배열선언시 +1 크기로 선언한다.
 *  그리고 앞에 문자와 비교해서 연속되는 문자가 같으면, 그냥 지나가도록 한다.
 *  그러면 결국 입력받은 문자는 모두 하나씩 있는것으로 되고 문제를 해결할 수 있다.
 *  처음에는 컨셉을 이해하지 못했는데, 결국 입력 받은 문자가 하나씩이고 중복 순열이면 문제를 풀 수 있다. 
*/
public class Main_B_15665_N과M_11_2 {

	static int N, M;
	static int numbers[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine(), " ");
		numbers = new int [N + 1];
		for(int i = 1; i < N+1; i++) numbers[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(numbers);
		
		permutation(0, new int [M]);
		System.out.println(sb);
	}
	
	private static void permutation(int r, int[] numberArr) {
		if(r == M) {
			for(int i = 0; i < M; i++) sb.append(numberArr[i]).append(" ");
			sb.append("\n");
			return;
		} else {
			for(int i = 1; i < N+1; i++) {
				if(numbers[i -1] == numbers[i]) continue;
				numberArr[r] = numbers[i];
				permutation(r + 1, numberArr);
			}
		}
	}

	static String src = "4 4\n" + 
			"1 1 2 2";
}
