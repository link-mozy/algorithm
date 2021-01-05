package Basic;

public class Permutation {

	public static void main(String[] args) {
		int num = 3;
		int [] arr = {1, 2, 3};
		int [] output = new int [num];
		boolean [] visited = new boolean [num];
		
		System.out.println("permutation 1:");
		permutation1(arr, output, visited, 0, num, 3);
		System.out.println("permutation 2:");
		permutation2(arr, 0, num, 3);
	}

	/*
	 * 자리를 바꾸어 순열 구하기
	 * 1,2,3 -> 2,1,3 (1과 2 자리 바꾸기)
	 */
	private static void permutation2(int[] arr, int depth, int num, int r) {
		if(depth == r) {
			print(arr, r);
			return;
		}
		
		for(int i = depth; i < num; i++) {
			swap(arr, depth, i);
			permutation2(arr, depth + 1, num, r);
			swap(arr, depth, i);
		}
	}

	private static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	/*
	 * 방문을 이용한 순열 구하기
	 */
	private static void permutation1(int[] arr, int[] output, boolean[] visited, int depth, int num, int r) {
		if(depth == r) {
			print(output, r);
			return;
		}
		
		for(int i = 0; i < num; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				permutation1(arr, output, visited, depth + 1, num, r);
				visited[i] = false;
			}
		}
	}

	/*
	 * 출력
	 */
	private static void print(int[] output, int r) {
		for (int i = 0; i < r; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}
}
