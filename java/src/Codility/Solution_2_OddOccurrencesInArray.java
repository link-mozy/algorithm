package Codility;

public class Solution_2_OddOccurrencesInArray {

	public static void main(String[] args) {
		int [] A = {9, 3, 9, 3, 9, 7, 9};
		solution(A);
	}
	
	static public int solution(int[] A) {
		int result = 0;

		for(int i = 0; i < A.length; i++) {
			result ^= A[i];
		}
		
		return result;
    }
}
