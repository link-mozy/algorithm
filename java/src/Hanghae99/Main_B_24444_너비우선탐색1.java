package Hanghae99;

import java.io.*;
import java.util.*;

/**
 *  @author mozy
 *  @since 11/1/24
 *  @see <a href="https://www.acmicpc.net/problem/24444" />
 *  @mem 91752 KB
 *  @time 956 ms
 *  @caution bfs 문제
*/
public class Main_B_24444_너비우선탐색1 {

    static int N, M, R;
    static List<Integer> E [];
    static int visited [];

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt();

        E = new List[N + 1];
        visited = new int[N + 1];
        for(int i = 0; i <= N; i++) E[i] = new ArrayList<>();
        for(int i = 1; i <= M; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            E[u].add(v);
            E[v].add(u);
        }
        for(int i = 1; i <= N; i++) Collections.sort(E[i]);
    }

    static void bfs() {
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        visited[R] = count;

        while (!queue.isEmpty()) {
            int v = queue.poll();  // 큐에서 시작 점점 꺼내기
            for(int next : E[v]) { // 인접 접점 꺼내기
                if(visited[next] == 0) { // 방문했는지 확인
                    count++;
                    visited[next] = count;
                    queue.add(next);
                }
            }
        }
    }

    static void output() {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    // Main
    public static void main(String[] args) {
        input();
        bfs();
        output();
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
