package Programmers;

import java.util.Arrays;

public class Solution_42576_완주하지못한선수 {

	public static void main(String[] args) {
		String [] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(participant, completion));
	}
	
	static public String solution(String[] participant, String[] completion) {
		String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int len = participant.length;
        
        for(int i = 0; i < len; i++) {
        	if(i == (len - 1)) {
        		answer = participant[len - 1];
        		break;
        	}
        	if(!participant[i].equals(completion[i])) {
        		answer = participant[i];
        		break;
        	}
        }
        
        return answer;
    }
}
