package Programmers.General;

public class Solution_72410_신규아이디추천 {
	
	public static void main(String[] args) {
//		String new_id = "...!@BaT#*..y.abcdefghijklm";
		String new_id = "abcdefghijklmn.p";
		
		System.out.println(solution(new_id));
	}

	static public String solution(String new_id) {
		/** step.1 **/
		String answer = new_id.toLowerCase();
		/** step.2 **/
		answer = answer.replaceAll("[^a-z0-9-_.]", "");
		/** step.3 **/
		answer = answer.replaceAll("[.]{2,}", ".");
		/** step.4 **/
		answer = answer.replaceAll("^[.]{1,}|[.]{1,}$", "");
		/** step.5 **/
		if(answer.equals("")) answer = "a";
		/** step.6 **/
		if(answer.length() > 15 ) {
			answer = answer.substring(0, 15);
		}
		answer = answer.replaceAll("[.]{1,}$", "");
		/** step.7 **/
		if(answer.length() <= 2) {
			while(answer.length() != 3) {
				answer += answer.substring(answer.length() - 1);
			}
		}
		
		return answer;
	}
}
