package Hanghae99;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 1/20/25
 *  @see <a href="https://www.acmicpc.net/problem/1260" />
 *  @mem 20064 KB
 *  @time 216 ms
 *  @caution DFS, BFS
*/
public class Main_B_1260_DFS와BFS {

    static int N, M, V;
    static boolean map[][];
    static boolean visited[];

    static StringBuilder sb1;
    static StringBuilder sb2;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();

        map = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            map[x][y] = true;
            map[y][x] = true;
        }

        sb1 = new StringBuilder();
        sb2 = new StringBuilder();
    }

    static void dfs(int node) {
        visited[node] = true;
        sb1.append(node).append(" ");
        // to: 해당 노드
        for(int i = 1; i <= N; i++) {
            if(map[node][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int node) {
        Arrays.fill(visited, false);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int front = queue.poll();
            sb2.append(front).append(" ");

            for(int i = 1; i <= N; i++) {
                if(map[front][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    // Main
    public static void main(String[] args) {
        input();
        dfs(V);
        bfs(V);
        System.out.println(sb1);
        System.out.println(sb2);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
