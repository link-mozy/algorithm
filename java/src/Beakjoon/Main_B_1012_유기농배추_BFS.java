package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2023/10/08
 *  @see <a href="https://www.acmicpc.net/problem/1012" />
 *  @mem 13616KB
 *  @time 120ms
 *  @caution
 *  BFS 로 풀이.
 *  for 루프에서 BFS 로 연속된 구역있는지 확인한다.
*/
public class Main_B_1012_유기농배추_BFS {

    static int T, N, M, K;
    static int map [][];
    static boolean visited [][];
    static int dir [][] = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new StringReader(str));
            StringTokenizer st;
            T = Integer.parseInt(in.readLine());

            for(int t = 0; t < T; t++) { // T start
                // 값 입력
                st = new StringTokenizer(in.readLine(), " ");
                M = Integer.parseInt(st.nextToken()); // 가로
                N = Integer.parseInt(st.nextToken()); // 세로
                K = Integer.parseInt(st.nextToken()); // 배추의 갯수
                map = new int[N][M];
                visited = new boolean[N][M];
                for(int k = 0; k < K; k++) {
                    st = new StringTokenizer(in.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    map[y][x] = 1;
                }

                solution();

            } // T end
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solution() {
        int count = 0;
        Queue<Point> queue;

        for(int n = 0; n < N; n++) {
            for(int m = 0; m < M; m++) {
                if(isIn(n, m) && check(n, m)) {
                    count++;
                    queue = new LinkedList<>();
                    queue.add(new Point(n, m));
                    visited[n][m] = true;
                    while (!queue.isEmpty()) {
                        Point front = queue.poll();
                        for(int d = 0; d < 4; d++) {
                            int _n = front.y + dir[d][0];
                            int _m = front.x + dir[d][1];
                            if (isIn(_n, _m) && check(_n, _m)) {
                                queue.add(new Point(_n, _m));
                                visited[_n][_m] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean check(int n, int m) {
        return !visited[n][m] && map[n][m] == 1;
    }

    private static boolean isIn(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }

    private static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static String str = "2\n" +
            "10 8 17\n" +
            "0 0\n" +
            "1 0\n" +
            "1 1\n" +
            "4 2\n" +
            "4 3\n" +
            "4 5\n" +
            "2 4\n" +
            "3 4\n" +
            "7 4\n" +
            "8 4\n" +
            "9 4\n" +
            "7 5\n" +
            "8 5\n" +
            "9 5\n" +
            "7 6\n" +
            "8 6\n" +
            "9 6\n" +
            "10 10 1\n" +
            "5 5";
}
