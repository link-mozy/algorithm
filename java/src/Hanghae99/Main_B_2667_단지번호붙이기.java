package Hanghae99;

import java.io.*;
import java.util.*;

/**
 *  @author mozy
 *  @since 23/1/25
 *  @see <a href="https://www.acmicpc.net/problem/2667" />
 *  @mem 14308 KB
 *  @time 116 ms
 *  @caution bfs 문제
 */
public class Main_B_2667_단지번호붙이기 {

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int [][] map;
    static boolean [][] visited;

    static int [][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int y = 0; y < N; y++) {
            String line = scan.nextLine();
            for(int x = 0; x < N; x++) {
                map[y][x] = line.charAt(x) - '0';
            }
        }
    }

    static boolean isIn(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    static int bfs(Point start) {
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        while (!queue.isEmpty()) {
            Point front = queue.poll();
            count++;

            for (int[] d : dir) {
                int y = front.y + d[0];
                int x = front.x + d[1];
                if (isIn(y, x) && map[y][x] == 1 && !visited[y][x]) {
                    queue.add(new Point(y, x));
                    visited[y][x] = true;
                }
            }
        }
        return count;
    }

    static void solution() {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(map[y][x] == 1 && !visited[y][x]) {
                    answer.add(bfs(new Point(y, x)));
                }
            }
        }

        answer.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(answer.size());
        for (int count : answer) {
            System.out.println(count);
        }
    }

    // Main
    public static void main(String[] args) {
        input();
        solution();
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
