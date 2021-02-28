package Jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 3. 1.
 *  @see  http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1136&sca=4070
 *  @mem  29MB
 *  @time 514ms
 *  @caution 
 *  union-find 문제
 *  find 찾을떼 내가 가리키는 것을 찾도록 해야함. 아직 union-find 에 익숙하지 않아. 계속 실수함...
*/
public class Main_J_1863_종교 {
	
	static int numbers [];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		numbers = new int [n + 1];
		
		for(int i = 1; i <= n; i++) numbers[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int count = 0;
		for(int i = 1; i <= n; i++) if(numbers[i] == i) count++;
		System.out.println(count);
	}

	private static void union(int number1, int number2) {
		number1 = find(number1);
		number2 = find(number2);
		
		if(numbers[number1] < numbers[number2]) numbers[number2] = number1;
		else numbers[number1] = number2;
	}

	private static int find(int number) {
		if(number == numbers[number]) return number;
		return numbers[number] = find(numbers[number]); // 여기 가장 중요!
	}
}
