package Basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NextPermutation {

	static int N, origin[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		origin = new int [N];
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) origin[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(origin);
		
		do {
			System.out.println(Arrays.toString(origin));
		} while (next_permutation(origin));
	}

	private static boolean next_permutation(int[] arr) {
		// step1
		int i = N - 1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		
		// i가 0이라는 말은 이 순열이 내림차순 형태로 정렬되어 있다는 것.
		// 다음 순열이 없는 경우이기 때문에 false를 반환해준다.
		if(i == 0) return false;
		
		// step2
		// 내가 찾은 교환위치와 교환할 큰 값을 찾는 과정이다.
		int j = N - 1;
		while(arr[i - 1] >= arr[j]) --j;
		
		// step3
		// j와 i-1번째의 배열 값을 서로 교환해준다.
		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;
		
		// step4
		// i부터 맨뒤에까지를 오름차순으로 교환해준다.
		int k = N-1;
		while(i < k) {
			temp = arr[i];
			arr[i] = arr[k];
			arr[i] = temp;
			++i; --k;
		}
		return true;
	}
}
