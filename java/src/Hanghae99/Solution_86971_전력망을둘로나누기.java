package Hanghae99;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  @author mozy
 *  @since 11/20/24
 *  @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/86971" />
 *  @mem KB
 *  @time ms
 *  @caution 완전 탐색
 *  - BFS 를 사용하는데, 왔던 노드(송정탑) 방향으로는 가지 않는다.
*/
public class Solution_86971_전력망을둘로나누기 {

    public static void main(String[] args) {
        // 테스트 1
//        int [][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
//        solution(9, wires);
        // 테스트 2
        int [][] wires = {{1,2},{2,3},{3,4}};
        solution(4, wires);
    }

    static class Node {
        int from;
        int num;

        public Node(int from, int num) {
            this.from = from;
            this.num = num;
        }
    }

    static List<Integer> [] nodeList;

    static public void init(int n, int [][] wires) {
        nodeList = new ArrayList [n+1];
        for (int i = 0; i <= n; i++) nodeList[i] = new ArrayList<>();
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            nodeList[v1].add(v2);
            nodeList[v2].add(v1);
        }
    }

    static public int bfs(int from, int num) {
        int count = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(from, num));

        while (!queue.isEmpty()) {
            Node front = queue.poll();
            count++; // 꺼내면서 count 증가
            for(int connectNum : nodeList[front.num]) {
                if(front.from == connectNum) continue; // 연결된 노드가 나의 출처라면 생략
                queue.add(new Node(front.num, connectNum));
            }
        }

        return count;
    }

    static public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        init(n, wires);
        for(int i = 0; i < wires.length; i++) {
            int wiresCount1 = bfs(wires[i][0], wires[i][1]);
            int wiresCount2 = bfs(wires[i][1], wires[i][0]);
            answer = Math.min(answer, Math.abs(wiresCount1 - wiresCount2));
        }

        return answer;
    }
}
