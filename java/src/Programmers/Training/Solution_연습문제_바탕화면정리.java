package Programmers.Training;

import java.util.Arrays;

/**
 *  @author mozy
 *  @since 2023. 3. 16.
 *  @see https://school.programmers.co.kr/learn/courses/30/lessons/161990
 *  @mem
 *  @time
 *  @scoure 1028(+4)
 *  @caution
 *  오랜만에 알고리즘 연습
 */
public class Solution_연습문제_바탕화면정리 {
    public static void main(String[] args) {
        // String [] wallpaper = {".#...", "..#..", "...#."};
        String [] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }

    static public int[] solution(String[] wallpaper) {
        // 시작점 (lux, luy) : 가장 작은 수
        // 끝점 (rdx, rdy) : 가장 큰 수
        int lux = 51, luy = 51, rdx =0 , rdy = 0;
        for (int row = 0; row < wallpaper.length; row++) {
            for (int column = 0; column < wallpaper[row].length(); column++) {
                char check = wallpaper[row].charAt(column);
                if (check == '#') {
                    if ( column <= luy ) luy = column;
                    if ( row <= lux ) lux = row;
                    if ( (column + 1) >= rdy ) rdy = (column + 1);
                    if ( (row + 1) >= rdx ) rdx = (row + 1);
                }
            }
        }
        int[] answer = {lux, luy, rdx, rdy};
        return answer;
    }
}
