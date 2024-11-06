package Hanghae99;

import java.io.*;
import java.util.*;

/**
 *  @author mozy
 *  @since 11/6/24
 *  @see <a href="" />
 *  @mem 257984 KB
 *  @time 840 ms
 *  @caution BFS 문제
 *  탈출조건
 *  - 거리가 기준거리보다 크다면 더 이상 따라갈 필요가 없다.
 *  - 방문한적이 있다면, 더 이상 최소 거리가 아니다. (최초 한번이 최소이기 때문.)
*/
public class Main_B_18352_특정거리의도시찾기 {

    static FastReader scan = new FastReader();
    static final int INF = -1;
    static int N, M, K, X;
    static List<Integer> cities [];
    static int dist [];

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt(); // 거리
        X = scan.nextInt(); // 출발 도시
        cities = new ArrayList [N + 1];
        dist = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            cities[i] = new ArrayList<>();
            dist[i] = INF;
        }
        for(int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            // a 에서 b 로
            cities[a].add(b);
        }
    }

    static void bfs() {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        queue.add(X);
        dist[X] = 0; // 최초 출발 도시
        while (!queue.isEmpty()) {
            int currentCity = queue.poll();
            if(dist[currentCity] > K) break; // 거리보다 크다면 더이상 따라갈 필요가 없다.
            if(dist[currentCity] == K) result.add(currentCity);

            for(int nextCity : cities[currentCity]) {
                if(dist[nextCity] != INF) continue; // 방문한적이 있다면 더이상 최단 거리가 아니다.
                dist[nextCity] = dist[currentCity] + 1;
                queue.add(nextCity);
            }
        }
        Collections.sort(result);
        for(int city : result) sb.append(city).append("\n");

        if(sb.length() == 0) sb.append("-1");
        System.out.println(sb);
    }

    // Main
    public static void main(String[] args) {
        input();
        bfs();
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
