package Hanghae99;

import java.io.*;
import java.util.*;

/**
 *  @author mozy
 *  @since 11/1/24
 *  @see <a href="" />
 *  @mem 90008 KB
 *  @time 864 ms
 *  @caution DFS 문제
 *  자잘한 실수 주의...
 *  1. ArrayList 재선언...
 *  2. count 값 정적 선언...
 *     만약 재귀함수 파라미터로 사용할 경우 if 검사에서 값을 사용해야함...
 *     그렇지 않을 경우. 중복값이 존재할 수 있다...
*/
public class Main_B_24479_깊이우선탐색1 {

    static int N, M, R;
    static List<Integer> array[];
    static int visited[];
    static int count = 1;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt();
        visited = new int[N + 1];
        Arrays.fill(visited, 0);
        array = (ArrayList<Integer>[]) new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            array[u].add(v);
            if (u != v) array[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(array[i]);
        }
    }

    static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    // int r : 시작 정점
    static void dfs(int r) {
        visited[r] = count++;
        for (int i = 0; i < array[r].size(); i++) {
            int nextN = array[r].get(i);
            if (visited[nextN] == 0) {
                dfs(nextN);
            }
        }
    }

    // Main
    public static void main(String[] args) {
        input();
        dfs(R);
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