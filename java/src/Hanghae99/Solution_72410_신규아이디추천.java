package Hanghae99;

/**
 *  @author mozy
 *  @since 12/1/24
 *  @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/72410 " />
 *  @mem KB
 *  @time ms
 *  @caution 구현
*/
public class Solution_72410_신규아이디추천 {

    public static void main(String[] args) {
        String test1 = "...!@BaT#*..y.abcdefghijklm";
        String test2 = "z-+.^.";
        String test3 = "=.=";
        String test4 = "123_.def";
        String test5 = "abcdefghijklmn.p";
        System.out.println(solution(test1));
        System.out.println(solution(test2));
        System.out.println(solution(test3));
        System.out.println(solution(test4));
        System.out.println(solution(test5));
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
