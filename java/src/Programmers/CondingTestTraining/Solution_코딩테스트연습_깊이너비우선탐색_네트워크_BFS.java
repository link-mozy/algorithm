package Programmers.CondingTestTraining;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_코딩테스트연습_깊이너비우선탐색_네트워크_BFS {
    static private final int CONNECTED = 1;

    public static void main(String[] args) {
        int n = 3;
        int [][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, computers));
    }

    static public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean [] visited = new boolean [n];

        Arrays.fill(visited, false);
        for (int node = 0; node < n; node++) {
            if (visited[node]) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(node);

            while(!queue.isEmpty()) {
                int currentNode = queue.poll();
                visited[currentNode] = true;

                for(int i = 0; i < n; i++) {
                    if(currentNode != i && computers[currentNode][i] == CONNECTED && !visited[i]) {
                        queue.add(i);
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}
