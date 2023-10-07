package Beakjoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2023/10/07
 *  @see <a href="https://www.acmicpc.net/problem/2178" />
 *  @mem 12304KB
 *  @time 100ms
 *  @caution
 *  BFS 로 풀이.
 *  queue 에 넣을때 넣은 순서대로 빼기 때문에 visited 의 값을 변경하고 다시 변경할 필요가 없다.
 *  값을 넣기 전에 마지막 값인지 확인 한다.
 */
public class Main_B_2178_미로탐색_BFS {

    private static int N, M, min;
    private static int [][] map;
    private static boolean [][] visited;
    private static int [][] dir = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new StringReader(src));
            StringTokenizer st;

            st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int [N][M];
            visited = new boolean [N][M];
            // map 입력
            for(int n = 0; n < N; n++) {
                String line = in.readLine();
                for(int m = 0; m < M; m++) {
                    map[n][m] = line.charAt(m) - 48;
                }
            }

            min = 10000;
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(0, 0, 0));
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                Point front = queue.poll();
                for(int d = 0; d < 4; d++) {
                    int _n = front.n + dir[d][0];
                    int _m = front.m + dir[d][1];
                    if(isIn(_n, _m) && check(_n, _m)) {
                        if(_n == N -1 && _m == M-1) { // 마지막에 도착했는지 확인
                            min = Math.min(min, front.dist + 1);
                        } else {
                            visited[_n][_m] = true;
                            queue.add(new Point(_n, _m, front.dist + 1));
                        }
                    }
                }
            }
            System.out.println(min + 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean check(int n, int m) {
        return map[n][m] == 1 && !visited[n][m];
    }

    static boolean isIn(int n, int m) {
        return 0 <= n && 0 <= m && n < N && m < M;
    }

    private static class Point {
        int n;
        int m;
        int dist;

        public Point(int n, int m, int dist) {
            this.n = n;
            this.m = m;
            this.dist = dist;
        }
    }

    static String src = "4 6\n" +
            "101111\n" +
            "101010\n" +
            "101011\n" +
            "111011";
}
