package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 18.
 *  @see https://www.acmicpc.net/problem/15663
 *  @mem  42740
 *  @time 236
 *  @caution
 *  순열, linkedHashSet 자료형을 통한 중복된 값 없애기...
 *  LinkedHashSet이라는 자료형과 문자열이라는 아이디어를 가지고 문제를 품...
 *  혼자서 문제를 풀때는 boolean [10001] 배열을 만들어 방문여부를 따져 풀었지만,
 *  linkedHashSet이라는 자료형으로 중복되지 않은 순열을 만들 수 있다.
 *  혼자서는 못풀었을것같다...
*/
public class Main_B_15663_N과M_9 {

	static int N, M;
	static int numbers [];
	static LinkedHashSet<String> hashSet;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		hashSet = new LinkedHashSet<String>();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int [N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		
		permutation(0, "", new boolean [N]);
		
		for(String line : hashSet) sb.append(line).append("\n");
		System.out.println(sb);
	}

	private static void permutation(int r, String numberArr, boolean visited[]) {
		if(r == M) {
			hashSet.add(numberArr.trim());
			return;
		} else {
			
			for(int i = 0; i < N; i++) {
				if(visited[i]) continue; 
				visited[i] = true;
				permutation(r + 1, numberArr + " " + numbers[i], visited);
				visited[i] = false;
			}
		}
	}

	static String src = "4 2\n" + 
			"9 7 9 1";
	
}
