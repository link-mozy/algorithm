package Programmers.General;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author mozy
 *  @since 11/16/24
 *  @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42840" />
 *  @mem KB
 *  @time ms
 *  @caution 구현 문제
 *  - 각 수포자1, 수포자2, 수포자3 의 찍는 방식을 나머지로 인덱스 하여 점수를 준다.
 *  - 정답의 answer 값을 만드는게 어려웠다...
*/
public class Solution_42840_모의고사 {

    public static void main(String[] args) {
        int ans [] = {1,2,3,4,5};
        solution(ans);
    }

    static public int[] solution(int[] answers) {
        int type1 [] = {1,2,3,4,5};
        int type2 [] = {2,1,2,3,2,4,2,5};
        int type3 [] = {3,3,1,1,2,2,4,4,5,5};

        int count[] = {0,0,0};
        int max = -1;
        List<Integer> ansList = new ArrayList<>();

        for(int i = 0; i < answers.length; i++) {
            int idx = i + 1;
            int idx1 = (i % 5);
            int idx2 = (i % 8);
            int idx3 = (i % 10);
            if(answers[i] == type1[idx1]) count[0]++;
            if(answers[i] == type2[idx2]) count[1]++;
            if(answers[i] == type3[idx3]) count[2]++;
            // System.out.println("i:"+i+", idx:"+idx+", idx1:"+idx1+", idx2:"+idx2+", idx3:"+idx3);
            // System.out.println("answers[i]:"+answers[i]+", type1[idx1]:"+type1[idx1]+", type2[idx2]"+type2[idx2]+", type3[idx3]"+type3[idx3]);
            max = Math.max(Math.max(Math.max(max, count[0]), count[1]), count[2]);
        }
        for(int i = 0; i < 3; i++) {
            if(max == count[i]) {
                ansList.add(i + 1);
            }
        }

        int[] answer = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}
