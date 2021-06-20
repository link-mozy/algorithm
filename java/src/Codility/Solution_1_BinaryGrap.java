package Codility;

/**
 * @author mozy
 * @since 2021. 6. 19.
 * @see  https://app.codility.com
 * @mem  
 * @time 
 * @caution 
 * 코딜리티 에디터 사용법 익히기
 */
public class Solution_1_BinaryGrap {

	public static void main(String[] args) {
		int N = 32;
		solution(N);
	}
	
	static public int solution(int N) {
        String binaryNumber = Integer.toBinaryString(N);
        int max = Integer.MIN_VALUE;
        int startIdx = 0;
        
        for(int idx = 0; idx < binaryNumber.length(); idx++) {
        	char number = binaryNumber.charAt(idx);
        	if(number == '1') {
        		// max 값 비교
        		int dis = idx - startIdx - 1;
        		if(max < dis) max = dis;
        		startIdx = idx;
        	}
        }
        
        return (max < 0)? 0: max;
    }
}
