package Hanghae99;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/8/24
 *  @see <a href="https://www.acmicpc.net/problem/7569" />
 *  @mem 120324 KB
 *  @time 564 ms
 *  @caution bfs 문제
*/
public class Main_B_7569_토마토 {
    static FastReader scan = new FastReader();

    // M : 가로 , M : 세로 , H : 높이
    static int M, N, H;
    static int box [][][];
    static LinkedList<Tomato> queue;
    static int day;
    static boolean isOk = true;

    // h, n, m
    static int dir [][] = {
            { 1, 0, 0 },
            { 0, 0,-1 },
            { 0, 1, 0 },
            {-1, 0, 0 },
            { 0, 0, 1 },
            { 0,-1, 0 } };

    static class Tomato {
        int h, n, m;

        public Tomato(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }

    static void input() {
        queue = new LinkedList<>();
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();
        box = new int [H + 1][N + 1][M + 1];
        for (int h = 0; h <= H; h++) {
            for (int n = 0; n <= N; n++) {
                for (int m = 0; m <= M; m++) {
                    if(h == 0 || n == 0 || m == 0) box[h][n][m] = -1;
                    else {
                        int status = scan.nextInt();
                        box[h][n][m] = status;
                        if(isOk && status == 0) isOk = false;
                        if(box[h][n][m] == 1) queue.add(new Tomato(h, n, m));
                    }
                }
            }
        }
    }

    static void printBox() {
        StringBuilder sb = new StringBuilder();
        for (int h = 1; h <= H; h++) {
            for (int n = 1; n <= N; n++) {
                for (int m = 1; m <= M; m++) {
                    sb.append(box[h][n][m]).append(" ");
                }
                sb.append("\n");
            }
            sb.append("----------------------------\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Tomato front = queue.poll();
            int frontDay = box[front.h][front.n][front.m];
            day = Math.max(day, frontDay);
            // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 토마토 익히기
            for(int d = 0; d < dir.length; d++) {
                int h = front.h + dir[d][0];
                int n = front.n + dir[d][1];
                int m = front.m + dir[d][2];
                if(!isIn(h, n, m)) continue;
                if(box[h][n][m] != 0) continue;
                box[h][n][m] = frontDay + 1;
                queue.add(new Tomato(h, n, m));
            }
        }
    }

    static int output() {
        for (int h = 1; h <= H; h++) {
            for (int n = 1; n <= N; n++) {
                for (int m = 1; m <= M; m++) {
                    if(box[h][n][m] == 0) {
                        return -1;
                    }
                }
            }
        }
        return day - 1;
    }

    static boolean isIn(int h, int n, int m) {
        return 0 < h && 0 < n && 0 < m && h <= H && n <= N && m <= M;
    }

    // Main
    public static void main(String[] args) {
        input();
        if(isOk) {
            System.out.println(0);
            return;
        }
        bfs();
        System.out.println(output());
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
