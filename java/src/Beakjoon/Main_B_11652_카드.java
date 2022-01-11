package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

/**
 * @author mozy
 * @since 2021. 10. 23.
 * @see  https://www.acmicpc.net/problem/11652
 * @mem  24552 KB
 * @time 300 ms
 * @caution 
 * 정렬 응용 문제.
 * 배열에 카드를 넣고 정렬을 한다.
 * 정렬 후 정렬의 특징인, 자신과 비슷한 값을 인접하게 갖고있는다. 를 이용하여
 * 현재 이전의 값과 비교 후 같으면, 카드의 개수를 증가
 * 카드의 개수가 최대이면 최대개수의 카드를 저장해 둔다.
 */
public class Main_B_11652_카드 {

	static long [] array;
	static int N;
	
	public static void main(String[] args) {
		input();
		
		pro();
	}

	private static void pro() {
		// Sort 정렬하기
		Arrays.sort(array, 1, N + 1); // <- Sort 할때 index 설정 해주기
		// mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(array[1]등장 횟수)
		long mode = array[1];
		int modeCnt = 1, curCnt = 1;
		
		// Todo
		// 2번 원소 부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는 지, 새로운 숫자가 나왔는지 판단하여
		// curCnt를 갱신해주고, 최빈값을 갱신하는 작업.
		for(int i = 2; i <= N; i++) {
			if(array[i] == array[i-1]) {
				curCnt++;
			} else {
				curCnt = 1;
			}
			if(modeCnt < curCnt) {
				modeCnt = curCnt;
				mode = array[i];
			}
		}
		
		// 정답 출력
		System.out.println(mode);
	}

	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			N = Integer.parseInt(br.readLine());
			array = new long [N + 1];
			for(int i = 1; i <= N; i++) {
				array[i] = Long.parseLong(br.readLine());
			}
		} catch (Exception e) {
		}
	}
	
	static String src = "7\n"
			+ "3\n"
			+ "6\n"
			+ "3\n"
			+ "3\n"
			+ "6\n"
			+ "3\n"
			+ "6";
}
