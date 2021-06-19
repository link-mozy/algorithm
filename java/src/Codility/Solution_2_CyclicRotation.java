package Codility;

import java.util.Arrays;

public class Solution_2_CyclicRotation {

	public static void main(String[] args) {
		int [] A = {3, 8, 9, 7, 6};
		int K = 3;
		
		solution(A, K);
	}
	
	static public int[] solution(int[] A, int K) {
		int len = A.length;
		
		if(len == 0) return A;
		for(int k = 0; k < K; k++) {
			// Rotation
			int lastNum = A[len - 1];
			for(int i = len - 1; i > 0; i--) A[i] = A[i - 1];
			A[0] = lastNum;
		}
		
		System.out.println(Arrays.toString(A));
        return A;
    }
}
