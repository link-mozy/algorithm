package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2022. 1. 15.
 * @see  https://www.acmicpc.net/problem/15970
 * @mem  14492 KB
 * @time 144 ms
 * @caution 
 * 정열의 특징을 활용한 문제
 * 정열은 비슷한 값 끼리 인접한다라는 특징을 활용하여 문제를 푼다.
 * 정열 후 양옆의 값을 비교하여 최소 값들만 저장 
 * for 문은 적개 사용하고 사용한 곳에서 많은 로직을 할 수 있도록 코드 작성 하기!
 */
public class Main_B_15970_화살표그리기 {

	static int N;
	static LinkedList [] array;
	static int result;
	
	public static void main(String[] args) {
		init();
		solution();
	}

	@SuppressWarnings("unchecked")
	private static void solution() {
		for(int color_idx = 1; color_idx <= N; color_idx ++) {
			int size = array[color_idx].size();
			if(size > 0) {
				Collections.sort(array[color_idx]);
				
				for(int idx = 0; idx < size; idx++) {
					int left;
					int right;
					if((idx - 1) > -1) {
						left = ((int) array[color_idx].get(idx) - (int) array[color_idx].get(idx-1));
					} else {
						left = Integer.MAX_VALUE;
					}
					if((idx + 1) < size) {
						right = ((int) array[color_idx].get(idx+1) - (int) array[color_idx].get(idx));
					} else {
						right = Integer.MAX_VALUE;
					}
					result += (right < left)? right : left;
				}
			}
		}
		
		System.out.println(result);
	}

	// input and initiate
	@SuppressWarnings("unchecked")
	private static void init() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			StringTokenizer st;
			N = Integer.parseInt(br.readLine());
			array = new LinkedList [N+1];
			for(int i = 1; i <= N; i++) {
				array[i] = new LinkedList<Integer>();
			}
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // 좌표
				int y = Integer.parseInt(st.nextToken()); // 색상
				array[y].push(x);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String src = "7\n"
			+ "6 1\n"
			+ "7 2\n"
			+ "9 1\n"
			+ "10 2\n"
			+ "0 1\n"
			+ "3 1\n"
			+ "4 1";
}
