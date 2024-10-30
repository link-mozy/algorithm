package Hanghae99;

import java.util.Arrays;

/**
 *  @author mozy
 *  @since 10/30/24
 *  @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/43238" />
 *  @mem KB
 *  @time ms
 *  @caution 이진탐색
 *  값을 넣을때 꼭 형변환 해줘야한다.
*/
public class Solution_43238_입국심사 {

    public static void main(String[] args) {

        int n = 6;
        int [] times = {10, 7};

        System.out.println(solution(n, times));
    }

    static public long solution(int n, int[] times) {
        Arrays.sort(times); // 정렬 (오름차순)
        long answer = 0;
        long left = 0;
        long right = (long) times[times.length - 1] * n; // 가장오래걸리는 심사원 * 인원수
        // 주의! right 값을 구할때 꼭 (long)으로 타입 형변환 한다.

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = getCount(mid, times);
            if(n <= count) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    static public long getCount(long mid, int[] times) {
        long count = 0;
        for(long time : times) {
            count += mid / time;
        }
        return count;
    }
}
