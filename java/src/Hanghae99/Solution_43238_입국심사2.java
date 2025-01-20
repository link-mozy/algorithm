package Hanghae99;

import java.util.Arrays;

/**
 *  @author mozy
 *  @since 1/20/25
 *  @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java" />
 *  @mem KB
 *  @time ms
 *  @caution 이진탐색
 *  right 를 세팅을할때 고민이 필요하다.
*/
public class Solution_43238_입국심사2 {

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }

    static public boolean check(int n, int[] times, long time) {
        long _n = 0;
        for(int _time : times) {
            _n += time / _time;
        }
        return n <= _n;
    }

    static public long solution(int n, int[] times) {
        long answer = 0;
        // 정렬
        Arrays.sort(times);
        // 이진 탐색
        long left = 1;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {
            long mid = (left + right) / 2;
            if(check(n, times, mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        // 결과
        return answer;
    }
}
