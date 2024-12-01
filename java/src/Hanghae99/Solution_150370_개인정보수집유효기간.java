package Hanghae99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  @author mozy
 *  @since 12/1/24
 *  @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/150370" />
 *  @mem KB
 *  @time ms
 *  @caution 구현
*/
public class Solution_150370_개인정보수집유효기간 {

    public static void main(String[] args) {
        String today = "2022.05.19";
        String [] terms = {"A 6", "B 12", "C 3"};
        String [] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int [] result = solution(today, terms, privacies);
        System.out.println(Arrays.toString(result));
    }

    static public int getDate(String date) {
        String [] yyyyMMdd = date.split("\\.");
        return Integer.parseInt(yyyyMMdd[0]) * 12 * 28  // year
                + Integer.parseInt(yyyyMMdd[1]) * 28    // month
                + Integer.parseInt(yyyyMMdd[2]);        // day
    }

    static public int getDate(String date, int[] terms, String term) {
        String [] yyyyMMdd = date.split("\\.");
        int _date = Integer.parseInt(yyyyMMdd[0]) * 12 * 28  // year
                + Integer.parseInt(yyyyMMdd[1]) * 28    // month
                + Integer.parseInt(yyyyMMdd[2]);        // day
        int _term = terms[term.charAt(0)-'A'] * 28;
        return _date + _term;
    }

    static public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        int _today = getDate(today);
        int [] _terms = new int [26]; // A~Z

        for (String term : terms) {
            String [] tmp = term.split(" ");
            _terms[tmp[0].charAt(0)-'A'] = Integer.parseInt(tmp[1]);
        }
        // 로직
        for (int i = 0; i < privacies.length; i++) {
            String [] privacy = privacies[i].split(" "); // 0:날짜, 1:약관
            int _privacy = getDate(privacy[0], _terms, privacy[1]);
            if (_privacy <= _today) answer.add(i + 1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
