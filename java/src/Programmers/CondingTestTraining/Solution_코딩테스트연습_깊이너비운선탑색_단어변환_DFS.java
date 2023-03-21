package Programmers.CondingTestTraining;

import java.util.Arrays;

public class Solution_코딩테스트연습_깊이너비운선탑색_단어변환_DFS {
    static private int count = 100;

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        // String [] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String [] words = {"hot", "dot", "dog", "lot", "log"};

        solution(begin, target, words);
    }

    static public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean [] visited = new boolean[words.length];
        // Arrays.fill(visited, false);
        for(int i = 0; i < words.length; i++) visited[i] = false;

        dfs(begin, target, words, visited);
        if(count == 100) count = 0;
        answer = count;
        return answer;
    }

    static public void dfs( String begin, String target, String [] words, boolean [] visited) {
        if(begin.equals(target)) {
            int visitedCount = 0;
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) visitedCount++;
            }
            count = Math.min(visitedCount, count);
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && isChangePossible(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited);
                visited[i] = false;
            }
        }
    }

    static boolean isChangePossible(String begin, String target) {
        int len = begin.length();
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(begin.charAt(i) == target.charAt(i)) count++;
        }
        return (len - 1) == count;
    }
}
