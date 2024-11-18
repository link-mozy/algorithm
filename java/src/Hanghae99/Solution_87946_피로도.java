package Hanghae99;

import java.util.Arrays;

public class Solution_87946_피로도 {

    public static void main(String[] args) {
        int [][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(80, dungeons));
    }

    static void dfs(int [][] dungeons, int k, int idx, int count) {
        if(k < dungeons[idx][0]) {
            return;
        }
        result = Math.max(count, result);
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(dungeons, k - dungeons[idx][1], i, count+1);
            visited[i] = false;
        }
    }

    static boolean [] visited;
    static int result;

    static public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        result = answer;
        for (int i = 0; i < dungeons.length; i++) {
            visited[i] = true;
            dfs(dungeons, k, i, 1);
            visited[i] = false;
        }
        answer = result;
        return answer;
    }
}
