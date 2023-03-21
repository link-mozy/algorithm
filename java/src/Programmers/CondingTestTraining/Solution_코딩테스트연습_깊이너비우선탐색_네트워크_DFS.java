package Programmers.CondingTestTraining;

public class Solution_코딩테스트연습_깊이너비우선탐색_네트워크_DFS {
    public static void main(String[] args) {

        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {1, 1, 0}};

        System.out.println(solution(n, computers));
    }

    static public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean [] visited = new boolean[n];

        for(int i = 0; i < n; i++) visited[i] = false;

        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                answer++;
                dfs(i, visited, computers);
            }
        }
        return answer;
    }

    static public void dfs(int node, boolean [] visited, int [][] computers) {
        visited[node] = true;

        for(int _node = 0; _node < computers.length; _node++) {
            if(computers[node][_node] == 1 && !visited[_node]) {
                dfs(_node, visited, computers);
            }
        }
    }

}
