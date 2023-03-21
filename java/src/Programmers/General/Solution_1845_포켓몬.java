package Programmers.General;

import java.util.HashSet;

public class Solution_1845_포켓몬 {

	public static void main(String[] args) {
		int [] nums = {3,1,2,3};
		System.out.println(solution(nums));
		
	}
	
	static public int solution(int[] nums) {
		int answer = 0;
		int half = nums.length / 2;
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(!set.contains(nums[i])) {
				set.add(nums[i]);
				if(half < set.size()) break;
			}
		}

		answer = (half < set.size())? half : set.size();
		
		return answer;
	}
	
}
